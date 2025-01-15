package com.example.customerman.controller.restful;

import com.example.customerman.dto.ProvinceDto;
import com.example.customerman.model.Customer;
import com.example.customerman.service.customer.ICustomerService;
import com.example.customerman.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JqueryRestController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    // View mapping - không cần /api prefix cho view
    @GetMapping("/jquery-test")
    public String showJqueryPage() {
        return "jqueryAjax/testJquery";
    }

    // REST endpoints
    @RestController
    @RequestMapping("/api")
    public class ApiController {
        
        @GetMapping("/customers")
        public ResponseEntity<Page<Customer>> getCustomers(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "") String search) {
            Page<Customer> customers;
            if (search != null && !search.isEmpty()) {
                customers = customerService.findByNameContaining(search, PageRequest.of(page, 4));
            } else {
                customers = customerService.findAll(PageRequest.of(page, 4));
            }
            return ResponseEntity.ok(customers);
        }

        @GetMapping("/customers/{id}")
        public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
            Optional<Customer> customer = customerService.findById(id);
            if (customer.isPresent()) {
                return ResponseEntity.ok(customer.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/restCreateCustomers")
        public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
            try {
                Customer savedCustomer = customerService.save(customer);
                return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping("/customers/update")
        public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
            try {
                // Kiểm tra xem customer có tồn tại không
                Optional<Customer> existingCustomer = customerService.findById(customer.getCustomerId());
                if (!existingCustomer.isPresent()) {
                    return ResponseEntity.notFound().build();
                }
                
                // Cập nhật thông tin customer
                Customer updatedCustomer = customerService.save(customer);
                return ResponseEntity.ok(updatedCustomer);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @DeleteMapping("/customers/{id}")
        public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
            try {
                // Kiểm tra xem customer có tồn tại không
                Optional<Customer> customer = customerService.findById(id);
                if (!customer.isPresent()) {
                    return ResponseEntity.notFound().build();
                }
                
                // Xóa customer
                customerService.remove(id);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @GetMapping("/provinces")
        public List<ProvinceDto> getAllProvinces() {
            return provinceService.findAllProvinceDto();
        }
    }
}
