package com.spring.movie.theater.dao.local;

import com.spring.movie.theater.domain.User;
import com.spring.movie.theater.service.UserService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LocalUserDao implements UserService {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private Map<Long, User> userDao;

    public LocalUserDao() {
        this.userDao = new HashMap<>();
    }

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return null;
    }

    @Override
    public User save(@Nonnull User user) {
        long id = (long) AUTO_ID.getAndIncrement();
        user.setId(id);
        userDao.put(id, user);
        return user;
    }

    @Override
    public void remove(@Nonnull User object) {

    }

    @Override
    public User getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return null;
    }
}
