package com.spring.movie.theater.dao;

import com.spring.movie.theater.domain.DomainObject;
import java.util.Collection;

public interface BaseDao <T extends DomainObject> {
    T save(T domainObject);
    void remove(T domainObject);
    Collection<T> getAll();
    T getById (Long id);
}
