package com.example.customerman.controller;

import com.example.customerman.dto.ProvinceDto;
import com.example.customerman.model.Province;
import com.example.customerman.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("")
    public ModelAndView listProvinces(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("/province/list");
        Page<ProvinceDto> provinces = provinceService.findAll(PageRequest.of(page, 10));
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
    public String saveProvince(@ModelAttribute("province") Province province, RedirectAttributes redirect) {
        provinceService.save(province);
        redirect.addFlashAttribute("message", "New province created successfully");
        return "redirect:/provinces";
    }

    @GetMapping("/delete/{id}")
    public String deleteProvince(@PathVariable Long id, RedirectAttributes redirect) {
        provinceService.remove(id);
        redirect.addFlashAttribute("message", "Province deleted successfully");
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
