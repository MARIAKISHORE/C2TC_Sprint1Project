package com.devmart.customerorbitservice;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerOrbitController {

    private final CustomerOrbitService service;

    public CustomerOrbitController(CustomerOrbitService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerProfileEntity createCustomer(@RequestBody CustomerProfileEntity customer) {
        return service.saveCustomer(customer);
    }

    @GetMapping
    public List<CustomerProfileEntity> getCustomers() {
        return service.getAllCustomers();
    }
}

