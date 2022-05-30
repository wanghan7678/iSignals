package com.igroup.signals.trial.HanWang.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class ExchangeCalendar
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String exchange;
    private ZonedDateTime date;
    private boolean isOpen;

    public Long getId() {
        return id;
    }

    public String getExchange() {
        return exchange;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
