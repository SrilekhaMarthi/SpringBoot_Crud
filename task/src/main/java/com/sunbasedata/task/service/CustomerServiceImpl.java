package com.sunbasedata.task.service;

import com.sunbasedata.task.dto.CustomerDto;
import com.sunbasedata.task.entity.Customer;
import com.sunbasedata.task.exception.ResourceNotFoundException;
import com.sunbasedata.task.mapper.CustomerMapper;
import com.sunbasedata.task.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public CustomerDto getCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Customer doest not exist with given id: "+id));
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> CustomerMapper.mapToCustomerDto(customer))
                .collect(Collectors.toList());

    }

    @Override
    public CustomerDto updateEmployee(UUID id, CustomerDto updatedCustomer) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Customer does not exist with the given id: "+id));

        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setStreet(updatedCustomer.getStreet());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setCity(updatedCustomer.getCity());
        customer.setState(updatedCustomer.getState());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setPhone(updatedCustomer.getPhone());

        Customer updatedCustomerObject = customerRepository.save(customer);

        return CustomerMapper.mapToCustomerDto(updatedCustomerObject);
    }

    @Override
    public void deleteEmployee(UUID customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()->new ResourceNotFoundException("Customer does not exist with the given id: "+customerId));

        customerRepository.deleteById(customerId);
    }


}
