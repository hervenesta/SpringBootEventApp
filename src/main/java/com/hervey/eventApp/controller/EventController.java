package com.hervey.eventApp.controller;

import com.hervey.eventApp.model.Event;
import com.hervey.eventApp.model.Subscription;
import com.hervey.eventApp.service.EventService;
import com.hervey.eventApp.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createEvent(@Valid @RequestBody Event event, BindingResult  result){
        ResponseEntity<?> err = mapValidationErrorService.MapValidation(result);

        if(err != null){
            return err;
        }
        Event event1 = eventService.saveOrUpdate(event);
        return new ResponseEntity<Event>(event1, HttpStatus.CREATED);
    }

    @PostMapping("/subs")
    public  long createSubscription(@Valid @RequestBody Subscription subscription){
        return eventService.saveSubscription(subscription);
    }

    @GetMapping("/{UserId}")
    public List<Event> getEventByUser(@Valid @PathVariable long UserId){
        return eventService.findSubscribedEventByUser(UserId);
    }

    @GetMapping("/all")
    public Iterable<Event> getAllEvent(){
        return eventService.findAllEvent();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@Valid @PathVariable long id){
        eventService.deleteEventById(id);
        return new ResponseEntity<String>("Event Id: "+ id + " has been deleted.", HttpStatus.OK);
    }

    @DeleteMapping("/{userid}/{eventid}")
    public ResponseEntity<?> unsubscribed(@Valid @PathVariable long userid,@Valid @PathVariable long eventid){
        eventService.deleteSubscribedEvent(userid, eventid);
        return new ResponseEntity<String>("unsubscribed  from event id"+ eventid, HttpStatus.OK);
    }

}
