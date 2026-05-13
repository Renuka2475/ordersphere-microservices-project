package com.order.orderBook.dao;

import com.order.orderBook.bean.OrderBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderBean , Long> {
}
