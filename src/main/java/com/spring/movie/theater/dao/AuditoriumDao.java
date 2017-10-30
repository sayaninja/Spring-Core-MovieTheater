package com.spring.movie.theater.dao;

import com.spring.movie.theater.domain.Auditorium;
import java.util.Collection;

public interface AuditoriumDao extends BaseDao<Auditorium> {
    Collection<Auditorium> getAll();
    Auditorium getByName(String name);
}
