package com.spring.movie.theater.impl;

import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.Ticket;
import com.spring.movie.theater.domain.User;
import com.spring.movie.theater.service.BookingService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;

public class DefaultBookingService implements BookingService{
    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        return 0;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {

    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return null;
    }
}
