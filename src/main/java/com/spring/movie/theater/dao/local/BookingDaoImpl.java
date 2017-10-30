package com.spring.movie.theater.dao.local;

import com.spring.movie.theater.dao.BookingDao;
import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.Ticket;
import com.spring.movie.theater.domain.User;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingDaoImpl implements BookingDao {

    private static Map<Event, Set<Ticket>> bookedTickets = new HashMap<>();

    @Override
    public void bookTickets(Set<Ticket> tickets) {
        Map<Event, List<Ticket>> newBookedTickets = tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getEvent));
        for (Event event: newBookedTickets.keySet()) {
            Set<Ticket> alreadyBooked = bookedTickets.get(event);
            if (alreadyBooked.isEmpty()) {
                bookedTickets.put(event, new HashSet<>(newBookedTickets.get(event)));
            } else {
                alreadyBooked.addAll(newBookedTickets.get(event));
            }
        }
    }

    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return bookedTickets.get(event);
    }
}
