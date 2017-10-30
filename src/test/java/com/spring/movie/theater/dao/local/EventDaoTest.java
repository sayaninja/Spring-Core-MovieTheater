package com.spring.movie.theater.dao.local;

import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.EventRating;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

// TODO: test unahppy cases
public class EventDaoTest {

    EventDaoImpl eventDao;
    String name = "SuperBowl";
    double basePrice = 1.0;
    EventRating rating = EventRating.HIGH;

    Event testEvent = Event.builder()
            .name(name)
            .basePrice(basePrice)
            .rating(rating)
            .airDates(new TreeSet<>())
            .build();

    @Before
    public void setUp() {
        eventDao = new EventDaoImpl();
    }

    @Test
    public void testGetForDateRange() {
    }

    @Test
    public void testGetNextEvents() {
    }

    @Test
    public void testSave() {
        eventDao.save(testEvent);
        Event event = eventDao.getByName(name);
        assertEquals(basePrice, event.getBasePrice(), 0.0);
        assertEquals(rating, event.getRating());
        eventDao.remove(event);
    }

    @Test
    public void testRemove() {
        eventDao.save(testEvent);
        assertNotNull(eventDao.getByName(name));
        eventDao.remove(testEvent);
        assertNull(eventDao.getById(testEvent.getId()));
    }

    @Test
    public void testGetById() {
        testEvent.setId(123L);
        eventDao.save(testEvent);
        Event event = eventDao.getById(123L);
        assertEquals(name, event.getName());
        eventDao.remove(event);
    }

    @Test
    public void getAll() {
        testEvent.setId(111L);
        eventDao.save(testEvent);
        testEvent.setId(222L);
        eventDao.save(testEvent);
        testEvent.setId(333L);
        eventDao.save(testEvent);
        assertEquals(3, eventDao.getAll().size());
    }
}