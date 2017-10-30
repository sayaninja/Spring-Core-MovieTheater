package com.spring.movie.theater.impl;

import com.spring.movie.theater.domain.Auditorium;
import com.spring.movie.theater.service.AuditoriumService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class DefaultAuditoriumService implements AuditoriumService {
    private Set<Auditorium> auditoriums;

    public void setAuditoriums(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriums;
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        for (Auditorium auditorium: auditoriums) {
            if (auditorium.getName().equals(name)) {
                return auditorium;
            }
        }
        return null;
    }
}
