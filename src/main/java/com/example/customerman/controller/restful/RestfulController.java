package com.example.customerman.controller.restful;

import com.example.customerman.model.Customer;
import com.example.customerman.service.customer.ICustomerService;
import com.example.customerman.testting.ModelCounterOpenedTimePage.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class RestfulController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Page<Customer>> listCustomersByRestful(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @ModelAttribute("count") Count count
    )
    {

//<!--location file html trả về /jqueryAjax/testJquery-->

        count.increment();
        System.out.println("Số lần trang được hiển thị với SessionAttributes: " + count.getCount());

        Page<Customer> customers;
        if (search != null && !search.isEmpty()) {
            customers = customerService.findByNameContaining(search, PageRequest.of(page, 4));
        } else {
            customers = customerService.findAll(PageRequest.of(page, 4));
        }

        return ResponseEntity.ok(customers);
    }



    @GetMapping("/findByIdRestful/{id}")
    public Optional<Customer> findByIdRestful(@PathVariable Long id) {
        return customerService.findById(id);
    }
}
