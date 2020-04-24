package com.iooiee.controller;

import ch.qos.logback.classic.Logger;
import com.iooiee.annotation.PermissionLimit;
import com.iooiee.common.vo.R;
import com.iooiee.dao.BackUserDao;
import com.iooiee.model.BackUser;
import com.iooiee.service.LoginService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * Time: 18:43
 */
@Controller
@RequestMapping("/user")
public class BackUserController {

    Logger logger = (Logger) LoggerFactory.getLogger(BackUserController.class);

    @Resource
    private BackUserDao backUserDao;

    @RequestMapping
    @PermissionLimit(adminuser = true)
    public String index(Model model) {
        return "user/user.index";
    }

    @RequestMapping("/update")
    @ResponseBody
    @PermissionLimit(adminuser = true)
    public R update(HttpServletRequest request, BackUser backUser) {

        BackUser loginUser = (BackUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
        if (loginUser.getUsername().equals(backUser.getUsername())) {
            return R.error().message("用户名不合法");
        }

        // valid password
        if (StringUtils.hasText(backUser.getPassword())) {
            backUser.setPassword(backUser.getPassword().trim());
            if (!(backUser.getPassword().length()>=4 && backUser.getPassword().length()<=20)) {
                return  R.error().message("密码长度为4~12位") ;
            }
            // md5 password
            backUser.setPassword(DigestUtils.md5DigestAsHex(backUser.getPassword().getBytes()));
        } else {
            backUser.setPassword(null);
        }

        // write
        backUserDao.update(backUser);
        return R.ok().message("修改用户信息成功!!!");
    }

    @RequestMapping("/updatePwd")
    @ResponseBody
    public R updatePwd(HttpServletRequest request, String password){
        // valid password
        if (password==null || password.trim().length()==0){
            return R.error().message("密码不可为空");
        }
        password = password.trim();
        if (!(password.length()>=4 && password.length()<=20)) {
            return  R.error().message("密码长度为4~12位") ;
        }

        // md5 password
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

        // update pwd
        BackUser loginUser = (BackUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);

        // do write
        BackUser existUser = backUserDao.loadByUserName(loginUser.getUsername());
        existUser.setPassword(md5Password);
        backUserDao.update(existUser);

        return R.ok().message("密码修改成功");
    }
}
