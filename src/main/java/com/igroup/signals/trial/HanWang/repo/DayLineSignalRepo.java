package com.igroup.signals.trial.HanWang.repo;

import com.igroup.signals.trial.HanWang.model.Signals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DayLineSignalRepo extends JpaRepository<Signals, Long>
{

    //@Query(value = "SELECT s FROM Signals s JOIN s.typeCode where s.tsCode = :tsCode and s.tradeDate in (select max(tradeDate) from Signals where tsCode=:tsCode)")
    @Query(value = "SELECT s FROM Signals s JOIN s.signalType t where s.tsCode = :tsCode and s.tradeDate in (SELECT max(tradeDate) FROM Signals where tsCode=:tsCode)")
    List<Signals> findSignalsByCodeLatestDay(String tsCode);


}
