package com.example.customerman.service.province;

import com.example.customerman.model.Customer;
import com.example.customerman.model.Province;
import com.example.customerman.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    Province save(Province province);

    void remove(Long provinceId);
}


