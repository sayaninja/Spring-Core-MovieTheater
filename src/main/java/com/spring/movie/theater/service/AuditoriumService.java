package com.spring.movie.theater.service;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.spring.movie.theater.domain.Auditorium;

public interface AuditoriumService extends AbstractDomainObjectService<Auditorium> {

    /**
     * Getting all auditoriums from the system
     * 
     * @return set of all auditoriums
     */
    @Nonnull
    Collection<Auditorium> getAll();

    /**
     * Finding auditorium by name
     * 
     * @param name Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    @Nullable
    Auditorium getByName(@Nonnull String name);

}
