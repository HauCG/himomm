package com.example.customerman.controller;

import com.example.customerman.dto.ProvinceDto;
import com.example.customerman.model.Province;
import com.example.customerman.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("")
    public ModelAndView listProvinces() {
        List<ProvinceDto> provinces = provinceService.findAllProvinceDto();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveProvince(Province province) {
        provinceService.save(province);
        return "redirect:/provinces";
    }

    @GetMapping("/delete/{id}")
    public String deleteProvince(@PathVariable Long id) {
        provinceService.remove(id);
        return "redirect:/provinces";
    }

    @GetMapping("/{id}/customers")
    public ModelAndView listCustomers(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/province/customers");
        modelAndView.addObject("customers", provinceService.findCustomersByProvinceId(id));
        modelAndView.addObject("provinceName", provinceService.findById(id).get().getProvinceName());
        return modelAndView;
    }
}
