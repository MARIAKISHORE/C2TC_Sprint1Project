package com.devmart.customerorbitservice;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerOrbitService {

    private final CustomerOrbitRepository repository;

    public CustomerOrbitService(CustomerOrbitRepository repository) {
        this.repository = repository;
    }

    public CustomerProfileEntity saveCustomer(CustomerProfileEntity customer) {
        return repository.save(customer);
    }

    public List<CustomerProfileEntity> getAllCustomers() {
        return repository.findAll();
    }
}
