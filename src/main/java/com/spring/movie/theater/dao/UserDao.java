package com.spring.movie.theater.dao;

import com.spring.movie.theater.domain.User;
import javax.annotation.Nonnull;

public interface UserDao extends BaseDao<User> {
    User getUserByEmail(@Nonnull String email);
}
