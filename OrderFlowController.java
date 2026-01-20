package com.devmart.orderflowservice;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderFlowController {

    private final OrderFlowService logic;

    public OrderFlowController(OrderFlowService logic) {
        this.logic = logic;
    }

    @PostMapping
    public OrderRecordEntity createOrder(@RequestBody OrderRecordEntity order) {
        return logic.placeOrder(order);
    }

    @GetMapping
    public List<OrderRecordEntity> getAllOrders() {
        return logic.getAllOrders();
    }

    @GetMapping("/customer/{customerId}")
    public List<OrderRecordEntity> getCustomerOrders(@PathVariable Long customerId) {
        return logic.getOrdersByCustomer(customerId);
    }

    @GetMapping("/shop/{shopId}")
    public List<OrderRecordEntity> getShopOrders(@PathVariable Long shopId) {
        return logic.getOrdersByShop(shopId);
    }

    @PutMapping("/{orderId}/status/{status}")
    public OrderRecordEntity updateOrderStatus(@PathVariable Long orderId,
                                         @PathVariable String status) {
        return logic.updateStatus(orderId, status);
    }
}
