package com.spring.movie.theater.dao.local;

import com.spring.movie.theater.dao.EventDao;
import com.spring.movie.theater.domain.Event;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class EventDaoImpl implements EventDao {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Long, Event> events = new HashMap<>();

    @Override
    public Event getByName(String name) {
        for (Event event: events.values()) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public Set<Event> getForDateRange(LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public Set<Event> getNextEvents(LocalDateTime to) {
        return null;
    }

    @Override
    public Event save(Event event) {
        if (null == event.getId()) {
            event.setId((long) AUTO_ID.getAndIncrement());
        }
        events.put(event.getId(), event);
        return event;
    }

    @Override
    public void remove(Event event) {
        events.remove(event.getId());
    }

    @Override
    public Collection<Event> getAll() {
        return events.values();
    }

    @Override
    public Event getById(Long id) {
        return events.get(id);
    }
}
