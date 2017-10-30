package com.spring.movie.theater.dao.local;

import com.spring.movie.theater.dao.AuditoriumDao;
import com.spring.movie.theater.domain.Auditorium;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AuditoriumDaoImpl implements AuditoriumDao {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Long, Auditorium> auditoriums = new HashMap<>();

    @Override
    public Auditorium save(Auditorium auditorium) {
        if (null == auditorium.getId()) {
            auditorium.setId((long) AUTO_ID.getAndIncrement());
        }
        auditoriums.put(auditorium.getId(), auditorium);
        return auditorium;
    }

    @Override
    public void remove(Auditorium auditorium) {
        auditoriums.remove(auditorium.getId());
    }

    @Override
    public Collection<Auditorium> getAll() {
        return auditoriums.values();
    }

    @Override
    public Auditorium getById(Long id) {
        return auditoriums.get(id);
    }

    @Override
    public Auditorium getByName(String name) {
        for (Auditorium auditorium: auditoriums.values()) {
            if (auditorium.getName().equals(name)) {
                return auditorium;
            }
        }
        return null;
    }
}
