package com.hervey.eventApp.service;

import com.hervey.eventApp.model.Event;
import com.hervey.eventApp.model.Subscription;
import com.hervey.eventApp.repository.EventRepo;
import com.hervey.eventApp.repository.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    public Event saveOrUpdate(Event event){
        return eventRepo.save(event);
    }

    public long saveSubscription(Subscription subscription){
        long eventId = subscription.getEventId();
        Event event = new Event();
        event = eventRepo.findById(eventId);
        LocalDate now = LocalDate.now();
        long eventAge = now.until(event.getEventDate(), ChronoUnit.DAYS);
        subscription.setEventAge(eventAge);
        subscription.setSubscriptionDate(now);
        subscriptionRepo.save(subscription);
        return eventAge;
    }

    public Event findEventById(long eventId){
        return eventRepo.findById(eventId);
    }

    public Iterable<Event> findAllEvent(){
        return eventRepo.findAll();
    }

    public List<Event> findSubscribedEventByUser(long userId){
        Iterable<Subscription> subsArray = subscriptionRepo.findAllByUserId(userId);
        List<Event> arrayEvent = new ArrayList<>();
        subsArray.forEach(s -> arrayEvent.add( eventRepo.findById(s.getEventId())));
        return arrayEvent;
    }

    public void deleteEventById(long id){
        Event event = findEventById(id);
        eventRepo.delete(event);
        Iterable<Subscription> subs = subscriptionRepo.findAllByEventId(id);
        subs.forEach(s -> subscriptionRepo.delete(s));
    }

    public void deleteSubscribedEvent(long userid, long eventId){
        Iterable<Subscription> subs = subscriptionRepo.findAllByUserId(userid);
        for(Subscription s: subs){
            if(s.getEventId() == eventId){
                subscriptionRepo.delete(s);
            }
        }
    }
}
