package com.devmart.retailnestservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailNestRepository extends JpaRepository<RetailShopEntity, Long> {
}
