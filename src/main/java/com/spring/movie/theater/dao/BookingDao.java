package com.spring.movie.theater.dao;

import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.Ticket;
import java.time.LocalDateTime;
import java.util.Set;

public interface BookingDao {
    void bookTickets(Set<Ticket> tickets);
    Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);
}
