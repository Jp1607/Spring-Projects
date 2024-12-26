package com.example.contentcalendar.repositories;

import com.example.contentcalendar.model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

public @Repository interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);
}
