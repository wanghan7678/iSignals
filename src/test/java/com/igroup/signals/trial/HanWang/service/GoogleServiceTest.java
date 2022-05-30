package com.igroup.signals.trial.HanWang.service;

import com.igroup.signals.trial.HanWang.model.NewsLink;
import org.testng.annotations.Test;


import static org.testng.Assert.assertNotNull;

public class GoogleServiceTest
{

    @Test
    public void test_googleCustomerSearch() throws Exception
    {
        GoogleSearchService googleSearchService = new GoogleSearchService();

        NewsLink link = googleSearchService.getSearchNews("山东黄金");

        assertNotNull(link);
    }
}
