package com.sunbasedata.task.service;

import com.sunbasedata.task.dto.CustomerDto;
import com.sunbasedata.task.entity.Customer;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(UUID id);

    List<CustomerDto> getAllCustomers();

    CustomerDto updateEmployee(UUID id, CustomerDto updatedCustomer);

    void deleteEmployee(UUID customerId);
}
