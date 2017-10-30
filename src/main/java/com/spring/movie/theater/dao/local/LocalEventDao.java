package com.spring.movie.theater.dao.local;

import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.service.EventService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class LocalEventDao implements EventService {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private Map<Long, Event> eventMap;

    public LocalEventDao() {
        this.eventMap = new HashMap<>();
    }

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        for (Event event: eventMap.values()) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }

    @Nonnull
    @Override
    public Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to) {
        return null;
    }

    @Nonnull
    @Override
    public Set<Event> getNextEvents(@Nonnull LocalDateTime to) {
        return null;
    }

    @Override
    public Event save(@Nonnull Event event) {
        if (null == event.getId()) {
            event.setId((long) AUTO_ID.getAndIncrement());
        }
        eventMap.put(event.getId(), event);
        return event;
    }

    @Override
    public void remove(@Nonnull Event event) {
        eventMap.remove(event.getId());
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return eventMap.get(id);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return eventMap.values();
    }
}
