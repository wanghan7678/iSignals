package com.igroup.signals.trial.HanWang.service;

import com.igroup.signals.trial.HanWang.model.Signals;
import com.igroup.signals.trial.HanWang.repo.DayLineSignalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalService {

    private final DayLineSignalRepo dayLineSignalRepo;

    @Autowired
    public SignalService(DayLineSignalRepo dayLineSignalRepo){this.dayLineSignalRepo = dayLineSignalRepo;}



    public List<Signals> findSignalsByCodeLastDay(String tsCode)
    {
        return dayLineSignalRepo.findSignalsByCodeLatestDay(tsCode);
    }
}
