package com.igroup.signals.trial.HanWang.service;


import com.igroup.signals.trial.HanWang.model.ExchangeCalendar;
import com.igroup.signals.trial.HanWang.repo.ExchangeCalendarRepo;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RealTimeServiceTest {

    @Test
    public void test_isTradeTime()
    {
        ExchangeCalendarRepo exchangeCalendarRepoMock = mock(ExchangeCalendarRepo.class);
        RealTimeService guguService = new RealTimeService(exchangeCalendarRepoMock);
        ExchangeCalendar exchangeCalendar = new ExchangeCalendar();
        exchangeCalendar.setOpen(true);

        when(exchangeCalendarRepoMock.findByDate(any())).thenReturn(exchangeCalendar);

        LocalDateTime localDateTime = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

        assertFalse(guguService.isTradingTime(zonedDateTime));

        localDateTime = LocalDateTime.of(2019, 9, 15, 9, 16, 17);
        zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());

        assertTrue(guguService.isTradingTime(zonedDateTime));

    }
}
