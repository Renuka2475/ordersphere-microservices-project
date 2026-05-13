package com.order.placeNewOrder.clients;

import com.order.placeNewOrder.dto.NotificationRequest;
import com.order.placeNewOrder.dto.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification-service")
public interface NotificationClient {

    @PostMapping("/api/notification-Service")
    NotificationResponse notify(NotificationRequest req);

}
