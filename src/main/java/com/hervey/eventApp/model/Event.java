package com.hervey.eventApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long eventId;

    @NotBlank(message = "can't be empty")
    @Column(name = "event_name")
    private String name;

    @NotBlank(message = "can't be empty")
    private String organiserName;

    @NotBlank(message = "can't be empty")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate eventDate;

    private String duration;

//    @OneToMany(mappedBy = "event")
//    private List<Subscription> subscriptions = new ArrayList<>();

    public Event() {
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

//    public List<Subscription> getSubscriptions() {
//        return subscriptions;
//    }
//
//    public void setSubscriptions(List<Subscription> subscriptions) {
//        this.subscriptions = subscriptions;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganiserName() {
        return organiserName;
    }

    public void setOrganiserName(String organiserName) {
        this.organiserName = organiserName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}

