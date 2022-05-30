package com.igroup.signals.trial.HanWang.service;

import com.igroup.signals.trial.HanWang.model.ExchangeCalendar;
import com.igroup.signals.trial.HanWang.model.StockRealTime;
import com.igroup.signals.trial.HanWang.repo.ExchangeCalendarRepo;
import com.igroup.signals.trial.HanWang.util.PropertiesUtil;
import com.igroup.signals.trial.HanWang.util.SinajsUtil;
import com.igroup.signals.trial.HanWang.util.Util;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class RealTimeService
{
    private final HttpClient httpClient = HttpClient.newBuilder()
            .build();

    private final ExchangeCalendarRepo exchangeCalendarRepo;

    public RealTimeService(ExchangeCalendarRepo exchangeCalendarRepo) {
        this.exchangeCalendarRepo = exchangeCalendarRepo;
    }


    public StockRealTime getStockRealTime(String tsCode) throws Exception
    {
        String url = SinajsUtil.getRequestUrl(tsCode);
        System.out.println("tscode= " + tsCode + ", " + url);
        if (url == null)
        {
            return null;
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .headers("Referer", "https://finance.sina.com.cn")
                .GET()
                .build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return parseSinajsResult(response.body().toString());
    }

    protected StockRealTime parseSinajsResult(String response)
    {
        response = response.replace("\"", "");
        String[] responses = response.split("=");
        if (responses.length != 2)
        {
            return null;
        }
        String[] results = responses[1].split(",");
        if (results.length < 31)
        {
            return null;
        }
        StockRealTime stockRealTime = new StockRealTime();
        stockRealTime.setName(results[0]);
        stockRealTime.setTodayOpen(Util.readToFloat(results[1]));
        stockRealTime.setLastClose(Util.readToFloat(results[2]));
        stockRealTime.setNowPrice(Util.readToFloat(results[3]));
        stockRealTime.setTodayHigh(Util.readToFloat(results[4]));
        stockRealTime.setTodayLow(Util.readToFloat(results[5]));
        stockRealTime.setBidPrice(Util.readToFloat(results[6]));
        stockRealTime.setAuctionPrice(Util.readToFloat(results[7]));
        stockRealTime.setBid1Shares(Util.readToFloat(results[8]));
        stockRealTime.setBid1Price(Util.readToFloat(results[9]));
        stockRealTime.setBid2Shares(Util.readToFloat(results[10]));
        stockRealTime.setBid2Price(Util.readToFloat(results[11]));
        stockRealTime.setBid3Shares(Util.readToFloat(results[12]));
        stockRealTime.setBid3Price(Util.readToFloat(results[13]));
        stockRealTime.setBid4Shares(Util.readToFloat(results[14]));
        stockRealTime.setBid4Price(Util.readToFloat(results[15]));
        stockRealTime.setBid5Shares(Util.readToFloat(results[16]));
        stockRealTime.setBid5Price(Util.readToFloat(results[17]));
        stockRealTime.setAuction1Shares(Util.readToFloat(results[18]));
        stockRealTime.setAuction1Price(Util.readToFloat(results[19]));
        stockRealTime.setAuction2Shares(Util.readToFloat(results[20]));
        stockRealTime.setAuction2Price(Util.readToFloat(results[21]));
        stockRealTime.setAuction3Shares(Util.readToFloat(results[22]));
        stockRealTime.setAuction3Price(Util.readToFloat(results[23]));
        stockRealTime.setAuction4Shares(Util.readToFloat(results[24]));
        stockRealTime.setAuction4Price(Util.readToFloat(results[25]));
        stockRealTime.setAuction5Shares(Util.readToFloat(results[26]));
        stockRealTime.setAuction5Price(Util.readToFloat(results[27]));
        stockRealTime.setDate(results[28]);
        stockRealTime.setTime(results[29]);
        return stockRealTime;
    }


    protected boolean isTradingTime(ZonedDateTime zonedDateTime)
    {
        String timezone = PropertiesUtil.getExchangeTimezone();
        ZonedDateTime beijingTime = zonedDateTime.withZoneSameInstant(ZoneId.of(timezone));
        ExchangeCalendar today = exchangeCalendarRepo.findByDate(beijingTime);
        if (today != null && today.isOpen())
        {
            int hour = beijingTime.getHour();
            int min = beijingTime.getMinute();
            if (hour >= 13 && hour <=15)
            {
                return true;
            }
            if (hour >= 10 && hour <=11)
            {
                return true;
            }
            if (hour == 9 && min >= 30)
            {
                return true;
            }
            if (hour == 11 && min <= 30)
            {
                return true;
            }
        }
        return false;
    }
}
