package com.hervey.eventApp.repository;

import com.hervey.eventApp.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepo extends CrudRepository<Event, Long> {
    Event findById(long id);
    List<Event> findAll();
}
