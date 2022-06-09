package com.igroup.signals.trial.HanWang.service;

import com.google.gson.Gson;

import com.igroup.signals.trial.HanWang.model.StockCompany;
import com.igroup.signals.trial.HanWang.util.PropertiesUtil;
import com.igroup.signals.trial.HanWang.util.TushareUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TushareService
{



    private final HttpClient httpClient = HttpClient.newBuilder()
            .build();


    public StockCompany getStockCompanyByTscode(String tscode) throws Exception
    {
        String requestBody = TushareUtil.getStockCompanyByTscode(tscode);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(PropertiesUtil.getTushareApiUrl()))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return parseStockCompanyResponse(response.body().toString());
    }

    private StockCompany parseStockCompanyResponse(String responseJson)
    {
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(responseJson, Map.class);
        Map<String, Object> data = (Map<String, Object>) map.get("data");
        if (data != null)
        {
            List<Object> items = (List<Object>)data.get("items");
            if (items.size() > 0)
            {
                List<String> item = (List<String>) items.get(0);
                StockCompany stockCompany = new StockCompany();
                stockCompany.setTsCode(item.get(0));
                stockCompany.setExchange(item.get(1));
                stockCompany.setProvince(item.get(2));
                stockCompany.setCity(item.get(3));
                stockCompany.setIntroduction(item.get(4));
                stockCompany.setWebsite(item.get(5));
                stockCompany.setMainBusiness(item.get(6));
                return stockCompany;
            }
        }
        return null;
    }

}
