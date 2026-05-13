package com.order.placeNewOrder.service;

import com.order.placeNewOrder.clients.NotificationClient;
import com.order.placeNewOrder.clients.OrderBookClient;
import com.order.placeNewOrder.clients.PaymentClient;
import com.order.placeNewOrder.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceOrderService {

    private static final Logger log = LoggerFactory.getLogger(PlaceOrderService.class);

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private OrderBookClient orderBookClient;

    @Autowired
    private NotificationClient notificationClient;




    public NotificationResponse placeNeworder(OrderBookRequest orderBookRequest){

        /* Rest Template working style */



        /* PaymentRequest payment = new PaymentRequest();
        payment.setOrderId(orderBookRequest.getOrderId());
        payment.setEmail(orderBookRequest.getEmail());
        payment.setAmount(orderBookRequest.getPrice());

        ResponseEntity<PaymentResponse> paymentResponse = restTemplate.postForEntity(
                "http://localhost:8083/payment-service",
                payment,
                PaymentResponse.class);

        restTemplate.postForEntity(
                "http://localhost:8081/api/orders",
                orderBookRequest,
                String.class);

        NotificationResponse notify = new NotificationResponse();
        notify.setEmail(orderBookRequest.getEmail());
        notify.setMsg("Order Placed successfully "+orderBookRequest.getOrderId());

        ResponseEntity<String> notificationService = restTemplate.postForEntity(
                "http://localhost:8084/api/notification-Service",
                notify,
                String.class);

        return "Order placed Successfully"; */

        /* Rest Template working style */

//        Feign Client
//        Payment
        log.info("Before payment Request {}", orderBookRequest.getEmail());
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(orderBookRequest.getPrice());
//        paymentRequest.setOrderId(orderBookRequest.getOrderId());
        paymentRequest.setEmail(orderBookRequest.getEmail());
        PaymentResponse paymentResponse = paymentClient.processPayment(paymentRequest);
        log.info("After payment Request :: {} {} ::",orderBookRequest.getEmail(), orderBookRequest.getPrice());

//        OrderBook
        OrderBookRequest orderBook = new OrderBookRequest();
        orderBook.setOrderId(orderBookRequest.getOrderId());
        orderBook.setFoodItem(orderBookRequest.getFoodItem());
        orderBook.setEmail(orderBookRequest.getEmail());
        orderBook.setPrice(orderBookRequest.getPrice());
        orderBook.setQty(orderBookRequest.getQty());
        orderBook.setLocation(orderBookRequest.getLocation());
        OrderBookResponse orderBookResponse = orderBookClient.saveOrder(orderBook);
        log.info("Order saved successfully {} ",orderBookResponse.toString());

//        Notification
        NotificationRequest notifyRequest = new NotificationRequest();
        notifyRequest.setEmail(orderBookRequest.getEmail());
        NotificationResponse notifyResponse = notificationClient.notify(notifyRequest);

        log.info("Notification sent {} ",notifyResponse.getEmail());

        return notifyResponse;



    }
}
