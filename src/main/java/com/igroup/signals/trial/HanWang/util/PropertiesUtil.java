package com.igroup.signals.trial.HanWang.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil
{
    private static String DEFAULT_PROPERTIES = "application.properties";

    private static String tushareApiUrl = null;

    private static String tushareToken = null;

    private static String googleSearchApi = null;

    private static String googleSearchKey = null;

    private static String googleSearchCx = null;

    private static String exchangeTimezone = null;

    private static String sinajsApiUrl = null;

    public static String getSinajsApiUrl()
    {
        if (sinajsApiUrl == null)
        {
            sinajsApiUrl = getProperty("realtime.data.apiUrl");
        }
        return sinajsApiUrl;
    }

    public static String getTushareApiUrl()
    {
        if (tushareApiUrl == null)
        {
            tushareApiUrl = getProperty("tushare.apiUrl");
        }
        return tushareApiUrl;
    }

    public static String getTushareToken()
    {
        if (tushareToken == null)
        {
            tushareToken = getProperty("tushare.token");
        }
        return tushareToken;
    }

    public static String getGoogleSearchApi()
    {
        if (googleSearchApi == null)
        {
            googleSearchApi = getProperty("google.search.apiUrl");
        }
        return googleSearchApi;
    }

    public static String getGoogleSearchKey()
    {
        if (googleSearchKey == null)
        {
            googleSearchKey = getProperty("google.search.key");
        }
        return googleSearchKey;
    }

    public static String getGoogleSearchCx()
    {
        if (googleSearchCx == null)
        {
            googleSearchCx = getProperty("google.search.cx");
        }
        return googleSearchCx;
    }

    public static String getExchangeTimezone()
    {
        if (exchangeTimezone == null)
        {
            exchangeTimezone = getProperty("exchange.timezone");
        }
        return exchangeTimezone;
    }

    public static String getProperty(String propertyName)
    {
        try {
            Resource resource = new ClassPathResource(DEFAULT_PROPERTIES);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            return properties.getProperty(propertyName);
        }
        catch (IOException ioException)
        {

        }
        return null;
    }
}
