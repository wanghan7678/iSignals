package com.igroup.signals.trial.HanWang.util;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TushareUtil {


    public static String getStockBasicByTscode(String tscode)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ts_code", tscode);
        return createRequest("stock_basic", parameters, null);
    }

    public static String getStockCompanyByTscode(String tscode)
    {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ts_code", tscode);
        List<String> fields = new ArrayList<>();
        fields.add("ts_code");
        fields.add("exchange");
        fields.add("province");
        fields.add("city");
        fields.add("introduction");
        fields.add("website");
        fields.add("main_business");
        return createRequest("stock_company", parameters, fields);
    }

    protected static String createRequest(String apiName, Map<String, Object> parameters, List<String> fields)
    {

        Gson gson = new Gson();
        String token = PropertiesUtil.getTushareToken();
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("api_name", apiName);
        requestMap.put("token", token);
        requestMap.put("params", parameters);
        requestMap.put("fields", fields);
        return gson.toJson(requestMap);
    }

}

