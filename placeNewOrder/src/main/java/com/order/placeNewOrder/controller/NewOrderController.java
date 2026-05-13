package com.order.placeNewOrder.controller;


import com.order.placeNewOrder.dto.NotificationResponse;
import com.order.placeNewOrder.dto.OrderBookRequest;
import com.order.placeNewOrder.service.PlaceOrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newOrder")
public class NewOrderController {

    private static final Logger log =
            LoggerFactory.getLogger(NewOrderController.class);

    @Autowired
    private PlaceOrderService placeOrderService;


    @PostMapping("/place")
    public NotificationResponse placeNewOrder(@Valid @RequestBody OrderBookRequest orderBookRequest1){
        log.info("new Order received:: {}", orderBookRequest1);
       return placeOrderService.placeNeworder(orderBookRequest1);

    }
}
