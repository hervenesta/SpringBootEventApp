package com.hervey.eventApp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subs_id")
    private long subsId;

    @Column(name = "user_id")
//    @JoinColumn(name = "user_id")
    private long userId;
    @Column(name = "event_id")
//    @JoinColumn(name = "event_id")
    private long eventId;

    private LocalDate subscriptionDate;
    private long eventAge;

//    @ManyToOne
//    @JsonIgnore
//    private User user;
//
//    @ManyToOne
//    @JsonIgnore
//    private Event event;

    public Subscription() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public long getEventAge() {
        return eventAge;
    }

    public void setEventAge(long eventAge) {
        this.eventAge = eventAge;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }
}
