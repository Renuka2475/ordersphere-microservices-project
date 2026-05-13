package com.order.paymentService.service;

import com.order.paymentService.dto.PaymentRequest;
import com.order.paymentService.dto.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{


    public PaymentResponse process(PaymentRequest req){
        PaymentResponse resp = new PaymentResponse();
        if(req.getAmount()>0){
            resp.setUserId(req.getUserid());
            resp.setStatus("Success");
            resp.setTransactionId(UUID.randomUUID().toString());

            return resp;
        }
        resp.setUserId(req.getUserid());
        resp.setStatus("Failure");
        return resp;
    }
}
