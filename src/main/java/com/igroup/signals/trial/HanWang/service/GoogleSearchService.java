package com.igroup.signals.trial.HanWang.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.v1.Customsearch;
import com.google.api.services.customsearch.v1.CustomsearchRequestInitializer;
import com.google.api.services.customsearch.v1.model.Result;
import com.google.api.services.customsearch.v1.model.Search;
import com.igroup.signals.trial.HanWang.model.NewsLink;
import com.igroup.signals.trial.HanWang.model.StockBasic;
import com.igroup.signals.trial.HanWang.repo.StockBasicRepo;
import com.igroup.signals.trial.HanWang.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleSearchService
{
    private final HttpClient httpClient = HttpClient.newBuilder()
            .build();

    private final StockBasicRepo stockBasicRepo;

    @Autowired
    public GoogleSearchService(StockBasicRepo stockBasicRepo) {
        this.stockBasicRepo = stockBasicRepo;
    }

    public List<NewsLink> getSearchNewsByTsCode(String tsCode) throws Exception
    {
        StockBasic stockBasic = stockBasicRepo.findStockBasicByTsCode(tsCode);
        List<NewsLink> newsLinks = new ArrayList<>();
        if (stockBasic != null)
        {
            newsLinks = getSearchNews(stockBasic.getName());
        }
        return newsLinks;
    }


    public List<NewsLink> getSearchNews(String searchQuery) throws Exception
    {
        List<NewsLink> newsLinkList = new ArrayList<>();

        String key = PropertiesUtil.getGoogleSearchKey();
        String cx = PropertiesUtil.getGoogleSearchCx();

        Customsearch cs = new Customsearch.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                .setApplicationName("MyApplication")
                .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer(key))
                .build();
        Customsearch.Cse.List list = cs.cse().list().setCx(cx);
        list.setQ(searchQuery);
        Search result = list.execute();
        if (result.getItems()!=null){
            for (Result ri : result.getItems()) {
                //Get title, link, body etc. from search
                NewsLink newsLink = new NewsLink();
                newsLink.setLink(ri.getLink());
                newsLink.setTitle(ri.getTitle());
                newsLinkList.add(newsLink);
            }
        }
        return newsLinkList;
    }



}
