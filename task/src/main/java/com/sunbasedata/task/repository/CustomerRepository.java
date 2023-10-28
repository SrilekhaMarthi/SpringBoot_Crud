package com.sunbasedata.task.repository;

import com.sunbasedata.task.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
