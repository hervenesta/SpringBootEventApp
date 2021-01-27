package com.hervey.eventApp.repository;

import com.hervey.eventApp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
