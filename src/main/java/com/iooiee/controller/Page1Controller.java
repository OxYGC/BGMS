package com.iooiee.controller;

import com.iooiee.common.vo.R;
import com.iooiee.model.SvcMonitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description: 第一页相关接口
 *
 * @Author: Yanggc
 * Time: 16:46
 */

@Controller
@RequestMapping("/page1")
public class Page1Controller {

    @RequestMapping("getDatas")
    @ResponseBody
    public R getDatas(){
        List<SvcMonitor>  svcMonitorList= new ArrayList<>();
            Random random = new Random();
            for(int i = 1; i<=10; i++){
            SvcMonitor svcMonitor = new SvcMonitor();
            int rndNum = random.nextInt(1000);
            svcMonitor.setId(rndNum+"");
            svcMonitor.setIp("192.68.1."+rndNum);
            svcMonitor.setPort(rndNum+1000+"");
            svcMonitor.setIsLined("正常");
            svcMonitor.setOnline("在线");
            svcMonitor.setIafStatus(rndNum-1+"");
            svcMonitorList.add(svcMonitor);
        }
        return R.ok().data("svcMonitor",svcMonitorList).message("查询服务数据");
    }
}
