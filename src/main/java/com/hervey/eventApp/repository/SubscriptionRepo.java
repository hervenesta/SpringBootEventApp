package com.hervey.eventApp.repository;

import com.hervey.eventApp.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepo extends CrudRepository<Subscription, Long> {
    Iterable<Subscription> findAllByUserId(long userId);
    Iterable<Subscription> findAllByEventId(long eventId);
    Subscription findByEventId(long id);
}
