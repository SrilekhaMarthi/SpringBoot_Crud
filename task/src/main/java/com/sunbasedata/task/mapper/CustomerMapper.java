package com.sunbasedata.task.mapper;

import com.sunbasedata.task.dto.CustomerDto;
import com.sunbasedata.task.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getAddress(),
                customer.getCity(),
                customer.getState(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getStreet(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getState(),
                customerDto.getEmail(),
                customerDto.getPhone()
        );
    }
}
