package com.example.customerman.repository;

import com.example.customerman.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long> {
    @Query(value = "SELECT COUNT(c.customer_id) FROM customers c WHERE c.province_id = :provinceId", nativeQuery = true)
    int countCustomersByProvinceId(@Param("provinceId") Long provinceId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE customers SET province_id = NULL WHERE province_id = :provinceId", nativeQuery = true)
    void updateCustomersProvince(@Param("provinceId") Long provinceId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM province WHERE province_id = :provinceId", nativeQuery = true)
    void deleteProvinceById(@Param("provinceId") Long provinceId);
}
