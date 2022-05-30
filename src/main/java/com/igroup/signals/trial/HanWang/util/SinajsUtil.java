package com.igroup.signals.trial.HanWang.util;

public class SinajsUtil
{

    public static String getRequestUrl(String tsCode)
    {
        String[] codes = tsCode.split(".");
        if (codes.length != 2)
        {
            return null;
        }
        String part1 = codes[0];
        String part2 = codes[1];
        String code = null;
        if (part2.equals("SH"))
        {
            code = "sh" + part1;
        }
        if (part2.equals("SZ"))
        {
            code = "sz" + part1;
        }
        return PropertiesUtil.getSinajsApiUrl() + "/list=" + code;
    }
}
