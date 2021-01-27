package com.hervey.eventApp.service;

import com.hervey.eventApp.model.Event;
import com.hervey.eventApp.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public Event saveOrUpdate(Event event){
        return eventRepo.save(event);
    }

    public Event findEventById(long eventId){
        return eventRepo.findById(eventId);
    }

    public Iterable<Event> findAllEvent(){
        return eventRepo.findAll();
    }

    public void deleteEventById(long id){
        Event event = findEventById(id);
        eventRepo.delete(event);
    }
}
