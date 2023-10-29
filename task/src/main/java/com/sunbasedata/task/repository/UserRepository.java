package com.sunbasedata.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbasedata.task.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>  {
    Optional<User> findByEmail(String email);

}
