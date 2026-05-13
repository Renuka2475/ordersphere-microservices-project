package com.order.orderBook.service;

import com.order.orderBook.bean.OrderBean;
import com.order.orderBook.dao.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderBean getOrderDetail(Long orderId) {

        Optional<OrderBean> result = orderRepository.findById(orderId);
        if(result.isPresent()){
            OrderBean orderBean = result.get();
        }
        else{
            throw new RuntimeException("The given id is not present"+orderId);
        }

        return result.get();


    }

    @Override
    public Page<OrderBean> getAllOrderDetails( int page, int size) {
                return orderRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public OrderBean newOrderCreation(OrderBean order) {
        return orderRepository.save(order);
    }

    @Override
    public String cancelledOrder(Long orderid) {
        orderRepository.deleteById(orderid);
        return "deleted";
    }
}
