package com.it.app.repository;

import com.it.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u")
    Optional<User> findByName(String name);

    @Query("SELECT count(u.id) FROM User u")
    List<User> findCountOfUsers();

}
