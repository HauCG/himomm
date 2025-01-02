package com.example.customerman.service.province;

import com.example.customerman.model.Customer;
import com.example.customerman.model.Province;
import com.example.customerman.dto.ProvinceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProvinceService {
    Page<ProvinceDto> findAll(Pageable pageable);
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    Province save(Province province);

    void remove(Long provinceId);
    
    // Thêm methods mới để làm việc với DTO
    List<ProvinceDto> findAllProvinceDto();
    
    int countCustomersByProvinceId(Long provinceId);
    
    List<Customer> findCustomersByProvinceId(Long provinceId);
}
