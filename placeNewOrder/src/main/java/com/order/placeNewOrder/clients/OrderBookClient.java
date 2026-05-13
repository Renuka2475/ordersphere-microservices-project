package com.order.placeNewOrder.clients;

import com.order.placeNewOrder.dto.OrderBookRequest;
import com.order.placeNewOrder.dto.OrderBookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("orderService")
public interface OrderBookClient {

    @PostMapping("/api/orders")
    OrderBookResponse saveOrder(OrderBookRequest req);
}
