package com.igroup.signals.trial.HanWang.util;

public class SinajsUtil
{


    public static String getRequestUrl(String tsCode)
    {
        String code = "";
        if (tsCode.endsWith("SZ"))
        {
           code = "sz" + tsCode.replace(".SZ", "");
        }
        else if (tsCode.endsWith("SH"))
        {

          code = "sh" + tsCode.replace(".SH", "");

        }
        return PropertiesUtil.getSinajsApiUrl() + "list=" + code;
    }
}
