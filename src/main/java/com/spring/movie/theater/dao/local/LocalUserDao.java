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
    private Map<Long, User> userMap;

    public LocalUserDao() {
        this.userMap = new HashMap<>();
    }

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        for (User user: userMap.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User save(@Nonnull User user) {
        if (null == user.getId()) {
            user.setId((long) AUTO_ID.getAndIncrement());
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public void remove(@Nonnull User user) {
        userMap.remove(user.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userMap.get(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userMap.values();
    }
}
