package com.iooiee.controller;

import com.iooiee.dao.BackUserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private BackUserDao backUserDao;

    @RequestMapping
    public String index(Model model) {
        return "user/user.index";
    }

}
