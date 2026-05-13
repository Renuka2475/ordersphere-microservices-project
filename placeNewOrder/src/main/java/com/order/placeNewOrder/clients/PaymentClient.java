package com.order.placeNewOrder.clients;

import com.order.placeNewOrder.dto.PaymentRequest;
import com.order.placeNewOrder.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "paymentService")
public interface PaymentClient {

    @PostMapping("/payment-service")
    PaymentResponse processPayment(PaymentRequest req);
}
