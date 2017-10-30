package com.spring.movie.theater.dao.local;

import com.spring.movie.theater.dao.UserDao;
import com.spring.movie.theater.domain.User;
import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDaoImpl implements UserDao {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Long, User> users = new HashMap<>();

    @Override
    public User getUserByEmail(@Nonnull String email) {
        for (User user: users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User save(User user) {
        if (null == user.getId()) {
            user.setId((long) AUTO_ID.getAndIncrement());
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public void remove(User user) {
        users.remove(user.getId());
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public User getById(Long id) {
        return users.get(id);
    }
}
