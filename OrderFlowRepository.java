package com.devmart.orderflowservice;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderFlowRepository extends JpaRepository<OrderRecordEntity, Long> {

    List<OrderRecordEntity> findByCustomerId(Long customerId);
    List<OrderRecordEntity> findByShopId(Long shopId);
}
