package com.order.paymentService.service;

import com.order.paymentService.dto.PaymentRequest;
import com.order.paymentService.dto.PaymentResponse;

public interface PaymentService {

    public PaymentResponse process(PaymentRequest req);
}
