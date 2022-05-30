package com.igroup.signals.trial.HanWang.util;

public class Util
{
    public static float readToFloat(String input)
    {
        try
        {
            return Float.parseFloat(input);
        }
        catch (NumberFormatException numberFormatException)
        {
            //TODO: handle the exceptions.
            return -Float.MAX_VALUE;
        }
    }
}
