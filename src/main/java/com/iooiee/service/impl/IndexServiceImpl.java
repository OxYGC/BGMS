package com.iooiee.service.impl;

import com.iooiee.service.IndexService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public Map<String, Object> dashboardInfo() {
        int jobInfoCount = 0;
        int jobLogCount = 0;
        int jobLogSuccessCount = 0;
        int executorCount = 0;

        Map<String, Object> dashboardMap = new HashMap<String, Object>();
        dashboardMap.put("jobInfoCount", jobInfoCount);
        dashboardMap.put("jobLogCount", jobLogCount);
        dashboardMap.put("jobLogSuccessCount", jobLogSuccessCount);
        dashboardMap.put("executorCount", executorCount);
        return dashboardMap;
    }
}
