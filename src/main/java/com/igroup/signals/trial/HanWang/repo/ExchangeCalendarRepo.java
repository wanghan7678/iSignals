package com.igroup.signals.trial.HanWang.repo;

import com.igroup.signals.trial.HanWang.model.ExchangeCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;

public interface ExchangeCalendarRepo extends JpaRepository<ExchangeCalendar, Long>
{
    ExchangeCalendar findByDate(ZonedDateTime time);
}
