package com.iooiee.controller;

import com.iooiee.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    IndexService indexService;

    @RequestMapping("/")
    public String index(Model model) {
        logger.debug(model.toString());
        Map<String, Object> dashboardMap = indexService.dashboardInfo();
        model.addAllAttributes(dashboardMap);
        return "index";
    }

    @RequestMapping("/page1")
    public String page1() throws IOException {
        return "subpage/page1";
    }
    @RequestMapping("/page2")
    public String page2() {
        return "subpage/page2";
    }
    @RequestMapping("/page3")
    public String page3() {
        return "subpage/page3";
    }

    @RequestMapping("/help")
    public String help() {
        return "help";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
