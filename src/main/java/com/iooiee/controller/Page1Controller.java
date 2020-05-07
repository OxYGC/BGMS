package com.iooiee.controller;

import com.iooiee.common.vo.R;
import com.iooiee.model.SvcMonitor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.*;

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
    public List<SvcMonitor> getDatas(){
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
        return svcMonitorList;
    }


    @RequestMapping("getSvcDatas")
    @ResponseBody
    public R getSvcDatas(){
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
        return R.ok().data("SvcStates",svcMonitorList).message("查询服务数据");
    }

    //求百分位数
    @RequestMapping("CalcPercentile")
    @ResponseBody
    public R CalcPercentile(@Param("per") double per){
        double[] arrs = {2,4,5,1,3,3,4,1,2,5};
        List<Double> doubleList = new ArrayList<>();
        for (double currArr : arrs) {
            doubleList.add(currArr);
        }
        double percentile = getPercentile(doubleList, per);
        return R.ok().message("查询服务数据");

    }
    public static double percentile(double[] data,double p){
        int n = data.length;
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        double px =  p*(n-1);
        int i = (int)java.lang.Math.floor(px);
        double g = px - i;
        if(g==0){
            return data[i];
        }else{
            return (1-g)*data[i]+g*data[i+1];
        }
    }


    private static double getPercentile(List<Double> dataList, double p) {
        int n = dataList.size();
        dataList.sort(new Comparator<Double>() {
            //从小到大排序
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 == null || o2== null){
                return 0;
                }
                return o1.compareTo(o2);
            }
        });
        double px =  p*(n-1);
        int i = (int)java.lang.Math.floor(px);
        double g = px - i;
        if(g==0){
            return dataList.get(i);
        }else{
            return (1-g)*dataList.get(i)+g*dataList.get(i+1);
        }
    }




}
