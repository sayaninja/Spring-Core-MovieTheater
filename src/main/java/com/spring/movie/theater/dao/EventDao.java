package com.spring.movie.theater.dao;

import com.spring.movie.theater.domain.Event;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public interface EventDao extends BaseDao<Event> {
    Event getByName(String name);
    Set<Event> getForDateRange(LocalDate from, LocalDate to);
    Set<Event> getNextEvents(LocalDateTime to);
}
