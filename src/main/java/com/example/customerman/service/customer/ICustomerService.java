package com.example.customerman.service.customer;

import com.example.customerman.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    
    Page<Customer> findAll(Pageable pageable);
    
    Optional<Customer> findById(Long id);
    
    Customer save(Customer customer);
    
    void remove(Long id);
    
    Page<Customer> findByNameContaining(String name, Pageable pageable);
}
