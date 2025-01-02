package com.example.customerman.service.province;

import com.example.customerman.dto.ProvinceDto;
import com.example.customerman.model.Customer;
import com.example.customerman.model.Province;
import com.example.customerman.repository.ICustomerRepository;
import com.example.customerman.repository.IProvinceRepository;
import com.example.customerman.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Province Service
 */
@Service
@Transactional
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<ProvinceDto> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable)
                .map(province -> new ProvinceDto(
                        province.getProvinceId(),
                        province.getProvinceName(),
                        countCustomersByProvinceId(province.getProvinceId())
                ));
    }

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public Province save(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.updateCustomersProvince(id);
        provinceRepository.deleteProvinceById(id);
    }

    @Override
    public List<ProvinceDto> findAllProvinceDto() {
        Iterable<Province> provinces = findAll();
        return StreamSupport.stream(provinces.spliterator(), false)
                .map(province -> new ProvinceDto(
                        province.getProvinceId(),
                        province.getProvinceName(),
                        countCustomersByProvinceId(province.getProvinceId())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public int countCustomersByProvinceId(Long provinceId) {
        return customerRepository.countByProvinceProvinceId(provinceId);
    }

    @Override
    public List<Customer> findCustomersByProvinceId(Long provinceId) {
        return customerRepository.findByProvinceProvinceId(provinceId);
    }
}
