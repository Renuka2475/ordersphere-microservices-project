package com.order.orderBook.controller;

import com.order.orderBook.bean.OrderBean;
import com.order.orderBook.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/orders")
public class OrderServiceController {

    private OrderService orderService;
    public OrderServiceController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<OrderBean> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getOrderDetail(id));
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Page<List<OrderBean>>>getAllOrders(){
//        return ResponseEntity.ok(orderService.getAllOrderDetails(@RequestParam int page, @RequestParam int size));
//    }

    @GetMapping
    public ResponseEntity<Page<OrderBean>> getAll(
            @RequestParam int page,
            @RequestParam int size) {
        return ResponseEntity.ok(orderService.getAllOrderDetails(page, size));
    }

    @PostMapping
    public ResponseEntity<OrderBean> saveNewOrder(@RequestBody OrderBean orderBean) {
        OrderBean savedOrder = orderService.newOrderCreation(orderBean);

        URI location = URI.create("api/orders" + savedOrder.getOrderId());

        return ResponseEntity.created(location).body(savedOrder);
    }

    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletOrderByID(@PathVariable Long id){
        orderService.cancelledOrder(id);
        return "Order Deleted Successfully";
    }


}
