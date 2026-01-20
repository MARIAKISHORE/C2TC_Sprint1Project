package com.devmart.customerorbitservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrbitRepository extends JpaRepository<CustomerProfileEntity, Long> {
}

