package com.igroup.signals.trial.HanWang.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.v1.Customsearch;
import com.google.api.services.customsearch.v1.CustomsearchRequestInitializer;
import com.google.api.services.customsearch.v1.model.Result;
import com.google.api.services.customsearch.v1.model.Search;
import com.igroup.signals.trial.HanWang.model.NewsLink;
import com.igroup.signals.trial.HanWang.util.PropertiesUtil;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoogleSearchService
{
    private final HttpClient httpClient = HttpClient.newBuilder()
            .build();

    public NewsLink getSearchNews(String searchQuery) throws Exception
    {
        NewsLink newsLink = new NewsLink();
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
                newsLink.setLink(ri.getLink());
                newsLink.setTitle(ri.getTitle());
            }
        }
        return newsLink;
    }



}
