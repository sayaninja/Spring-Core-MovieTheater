package com.spring.movie.theater.service.impl;

import com.spring.movie.theater.dao.BookingDao;
import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.Ticket;
import com.spring.movie.theater.domain.User;
import com.spring.movie.theater.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;

public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        return 0;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        bookingDao.bookTickets(tickets);
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return bookingDao.getPurchasedTicketsForEvent(event, dateTime);
    }
}
