package com.spring.movie.theater.service.impl;

import com.spring.movie.theater.dao.AuditoriumDao;
import com.spring.movie.theater.domain.Auditorium;
import com.spring.movie.theater.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumDao auditoriumDao;

    @Override
    public Auditorium save(@Nonnull Auditorium auditorium) {
        return auditoriumDao.save(auditorium);
    }

    @Override
    public void remove(@Nonnull Auditorium auditorium) {
        auditoriumDao.remove(auditorium);
    }

    @Override
    public Auditorium getById(@Nonnull Long id) {
        return auditoriumDao.getById(id);
    }

    @Nonnull
    @Override
    public Collection<Auditorium> getAll() {
        return auditoriumDao.getAll();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumDao.getByName(name);
    }
}
