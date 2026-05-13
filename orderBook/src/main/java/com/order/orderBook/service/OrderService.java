package com.order.orderBook.service;

import com.order.orderBook.bean.OrderBean;
import org.springframework.data.domain.Page;

public interface OrderService {

    public OrderBean getOrderDetail(Long orderId);
    public Page<OrderBean> getAllOrderDetails(int page, int size );
    public OrderBean newOrderCreation(OrderBean order);
    public String cancelledOrder(Long orderid);
}
