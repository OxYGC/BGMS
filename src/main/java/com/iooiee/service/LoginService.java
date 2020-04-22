package com.iooiee.service;

import com.iooiee.common.constants.ResultCodeEnum;
import com.iooiee.common.utils.CookieUtil;
import com.iooiee.common.utils.JacksonUtil;
import com.iooiee.common.vo.R;
import com.iooiee.dao.BackUserDao;
import com.iooiee.model.BackUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yanggc
 * Time: 18:08
 */
@Configuration
public class LoginService {
    public static final String LOGIN_IDENTITY_KEY = "BGMS_LOGIN_IDENTITY";
    @Resource
    BackUserDao backUserDao;

    private String makeToken(BackUser backUser){
        String tokenJson = JacksonUtil.writeValueAsString(backUser);
        String tokenHex = new BigInteger(tokenJson.getBytes()).toString(16);
        return tokenHex;
    }

    private BackUser parseToken(String tokenHex){
        BackUser backUser = null;
        if (tokenHex != null) {
            // username_password(md5)
            String tokenJson = new String(new BigInteger(tokenHex, 16).toByteArray());
            backUser = JacksonUtil.readValue(tokenJson, BackUser.class);
        }
        return backUser;
    }


    public R login(HttpServletRequest request, HttpServletResponse response, String username, String password, boolean ifRemember){

        // 缺少参数
        if (username==null || username.trim().length()==0 || password==null || password.trim().length()==0){
            return R.setResult(ResultCodeEnum.PARAM_ERROR);
        }

        // passowrd校验错误
        BackUser backUser = backUserDao.loadByUserName(username);
        if (backUser == null) {
            return R.setResult(ResultCodeEnum.PARAM_ERROR);
        }
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!passwordMd5.equals(backUser.getPassword())) {
            return R.setResult(ResultCodeEnum.PARAM_ERROR);
        }

        String loginToken = makeToken(backUser);

        // 登录后设置Cookie
        CookieUtil.set(response, LOGIN_IDENTITY_KEY, loginToken, ifRemember);
        return R.ok();
    }

    /**
     * logout
     *
     * @param request
     * @param response
     */
    public R logout(HttpServletRequest request, HttpServletResponse response){
        CookieUtil.remove(request, response, LOGIN_IDENTITY_KEY);
        return R.ok();
    }

    /**
     * logout
     * 如果已经登录
     * @param request
     * @return
     */
    public BackUser ifLogin(HttpServletRequest request, HttpServletResponse response){
        String cookieToken = CookieUtil.getValue(request, LOGIN_IDENTITY_KEY);
        if (cookieToken != null) {
            BackUser cookieUser = null;
            try {
                cookieUser = parseToken(cookieToken);
            } catch (Exception e) {
                logout(request, response);
            }
            if (cookieUser != null) {
                BackUser dbUser = backUserDao.loadByUserName(cookieUser.getUsername());
                if (dbUser != null) {
                    if (cookieUser.getPassword().equals(dbUser.getPassword())) {
                        return dbUser;
                    }
                }
            }
        }
        return null;
    }
}
