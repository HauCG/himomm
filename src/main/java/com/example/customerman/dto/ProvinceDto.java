package com.example.customerman.dto;

public class ProvinceDto {
    private Long provinceDtoId;
    private String provinceDtoName;
    private int totalCustomers;

    public ProvinceDto() {
    }

    public ProvinceDto(Long provinceDtoId, String provinceDtoName, int totalCustomers) {
        this.provinceDtoId = provinceDtoId;
        this.provinceDtoName = provinceDtoName;
        this.totalCustomers = totalCustomers;
    }

    public Long getProvinceDtoId() {
        return provinceDtoId;
    }

    public void setProvinceDtoId(Long provinceDtoId) {
        this.provinceDtoId = provinceDtoId;
    }

    public String getProvinceDtoName() {
        return provinceDtoName;
    }

    public void setProvinceDtoName(String provinceDtoName) {
        this.provinceDtoName = provinceDtoName;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }
}
