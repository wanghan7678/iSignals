package com.igroup.signals.trial.HanWang.service;

import com.igroup.signals.trial.HanWang.model.StockCompany;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TushareServiceTest
{

    @Test
    public void test_readStockCompany() throws Exception
    {
        String tsCode = "000001.SZ";
        TushareService tushareService = new TushareService();

        StockCompany stockCompany = tushareService.getStockCompanyByTscode(tsCode);

        assertNotNull(stockCompany);

        assertEquals(stockCompany.getTsCode(), tsCode);

        assertEquals(stockCompany.getProvince(), "广东");

    }
}
