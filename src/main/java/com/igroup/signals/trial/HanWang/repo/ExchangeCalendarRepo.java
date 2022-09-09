package com.igroup.signals.trial.HanWang.repo;

import com.igroup.signals.trial.HanWang.model.ExchangeCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public interface ExchangeCalendarRepo extends JpaRepository<ExchangeCalendar, Long>
{
    ExchangeCalendar findByDate(ZonedDateTime time);

    @Query(value = "SELECT max(e.date) FROM ExchangeCalendar e WHERE e.isOpen = 1 and e.date <= :inputDate")
    LocalDate findLastTradeDate(LocalDate inputDate);
}
