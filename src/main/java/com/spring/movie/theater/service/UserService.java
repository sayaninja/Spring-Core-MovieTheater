package com.spring.movie.theater.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.spring.movie.theater.domain.User;

public interface UserService extends AbstractDomainObjectService<User> {

    /**
     * Finding user by email
     *
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    @Nullable User getUserByEmail(@Nonnull String email);

}
