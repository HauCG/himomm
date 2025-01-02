package com.example.customerman.model;


import jakarta.persistence.*;


@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long provinceId;
    private String provinceName;


    public Province(Long provinceId, String province) {
        this.provinceId = provinceId;
        this.provinceName = province;
    }
    public Province() {
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
