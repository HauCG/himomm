package com.example.customerman.controller;

import com.example.customerman.model.Customer;
import com.example.customerman.service.customer.ICustomerService;
import com.example.customerman.service.province.IProvinceService;
import com.example.customerman.testting.ModelCounterOpenedTimePage.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
@SessionAttributes("account")
public class MainController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("count")
    public Count setUpCount() {
        return new Count(0);
    }


    @GetMapping("/createForm")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces", provinceService.findAll());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }




    @GetMapping("")
    public ModelAndView listCustomers(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                    @RequestParam(name = "search", required = false, defaultValue = "") String search,
     @ModelAttribute("count") Count count

    ) throws RuntimeException {

        count.increment();
        System.out.println("Số lần trang được hiển thị với SessionAttributes a là " + count.getCount());

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        Page<Customer> customers;
        if (search != null && !search.isEmpty()) {
            customers = customerService.findByNameContaining(search, PageRequest.of(page, 4));
            modelAndView.addObject("search", search);
        } else {
            customers = customerService.findAll(PageRequest.of(page, 4));
        }
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/showUpdate/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/update");
            modelAndView.addObject("customer", customer.get());
            modelAndView.addObject("provinces", provinceService.findAll());
            return modelAndView;
        }
        return new ModelAndView("redirect:/customers");
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/update");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("provinces", provinceService.findAll());
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/showDelete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.remove(customerId);
        return "redirect:/customers";
    }

    @GetMapping("/details/{id}")
    public String showCustomerDetails(@PathVariable long id, Model model) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()) {
            RestTemplate restTemplate = new RestTemplate();
            Customer customer = restTemplate.getForObject("http://localhost:8080/customer/findByIdRestful" + id, Customer.class);
            model.addAttribute("customer", customer);

            model.addAttribute("customer", customerOptional.get());
            return "customer/details";
        }
        return "redirect:/customers";
    }

//    @PostMapping("/customers/search")
//    public String searchCustomers(@RequestParam(required = false) String customerName,
//                                  @RequestParam(required = false) Long province,
//                                  Model model) {
//        List<Customer> customers;
//
//        // Kiểm tra trường hợp không có tham số nào
//        if (customerName == null && province == null) {
//            return "redirect:/customers"; // Trở về trang danh sách khách hàng
//        }
//
//        // Kiểm tra trường hợp có cả hai tham số
//        if (customerName != null && province != null) {
//            customers = customerService.searchCustomersByNameAndProvince(customerName, province);
//        }
//        // Kiểm tra trường hợp chỉ có tỉnh
//        else if (province != null) {
//            customers = customerService.searchCustomersByProvince(province);
//        }
//        // Kiểm tra trường hợp chỉ có tên
//        else {
//            customers = customerService.searchCustomersByCustomerName(customerName);
//        }
//
//        // Thêm danh sách khách hàng vào model để hiển thị trên trang
//        model.addAttribute("customers", customers);
////        model.addAttribute("param", new SearchParams(name, province)); // Giữ lại các tham số tìm kiếm
//
//        // Trả về view hiển thị danh sách khách hàng
//        return "redirect:/customers"; // Thay đổi tên view nếu cần
//    }
}
