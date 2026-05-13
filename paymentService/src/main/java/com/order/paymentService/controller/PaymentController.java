package com.order.paymentService.controller;

import com.order.paymentService.dto.PaymentRequest;
import com.order.paymentService.dto.PaymentResponse;
import com.order.paymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment-service")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest req){
        PaymentResponse resp = paymentService.process(req);
        return ResponseEntity.ok(resp);

    }

}
