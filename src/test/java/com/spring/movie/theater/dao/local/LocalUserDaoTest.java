package com.spring.movie.theater.dao.local;

import com.spring.movie.theater.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// TODO: Test unhappy cases
public class LocalUserDaoTest {

    LocalUserDao userDao;
    String firstName = "John";
    String lastName = "Smith";
    String email = "john@gmail.com";
    User testUser = User.builder()
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .build();

    @Before
    public void setUp() {
        userDao = new LocalUserDao();
    }

    @Test
    public void testSave() {
        userDao.save(testUser);
        User user = userDao.getUserByEmail(email);
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        userDao.remove(user);
    }

    @Test
    public void testRemove() {
        userDao.save(testUser);
        assertNotNull(userDao.getUserByEmail(email));
        userDao.remove(testUser);
        assertNull(userDao.getUserByEmail(email));
    }

    @Test
    public void testGetById() {
        testUser.setId(123L);
        userDao.save(testUser);
        User user = userDao.getById(123L);
        assertEquals(firstName, user.getFirstName());
        userDao.remove(user);
    }

    @Test
    public void testGetAll() {
        testUser.setId(111L);
        userDao.save(testUser);
        testUser.setId(222L);
        userDao.save(testUser);
        testUser.setId(333L);
        userDao.save(testUser);
        assertEquals(3, userDao.getAll().size());
    }
}