package com.devmart.orderflowservice;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderFlowService {

    private final OrderFlowRepository orderVault;

    public OrderFlowService(OrderFlowRepository orderVault) {
        this.orderVault = orderVault;
    }

    public OrderRecordEntity placeOrder(OrderRecordEntity order) {
        return orderVault.save(order);
    }

    public List<OrderRecordEntity> getAllOrders() {
        return orderVault.findAll();
    }

    public List<OrderRecordEntity> getOrdersByCustomer(Long customerId) {
        return orderVault.findByCustomerId(customerId);
    }

    public List<OrderRecordEntity> getOrdersByShop(Long shopId) {
        return orderVault.findByShopId(shopId);
    }

    public OrderRecordEntity updateStatus(Long orderId, String status) {
    	OrderRecordEntity order = orderVault.findById(orderId).orElseThrow();
        order.setOrderStatus(status);
        return orderVault.save(order);
    }
}
