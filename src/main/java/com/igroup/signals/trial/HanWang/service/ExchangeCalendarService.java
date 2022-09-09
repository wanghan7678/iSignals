package com.igroup.signals.trial.HanWang.service;

import com.igroup.signals.trial.HanWang.repo.ExchangeCalendarRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExchangeCalendarService {

    private final ExchangeCalendarRepo exchangeCalendarRepo;


    public ExchangeCalendarService(ExchangeCalendarRepo exchangeCalendarRepo) {
        this.exchangeCalendarRepo = exchangeCalendarRepo;
    }

    public LocalDate getLatestDate()
    {
        LocalDate today = LocalDate.now();
        return exchangeCalendarRepo.findLastTradeDate(today);
    }
}
