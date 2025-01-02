package com.example.customerman.repository;

import com.example.customerman.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByCustomerNameContaining(String name, Pageable pageable);
    int countByProvinceProvinceId(Long provinceId);
    List<Customer> findByProvinceProvinceId(Long provinceId);
}
