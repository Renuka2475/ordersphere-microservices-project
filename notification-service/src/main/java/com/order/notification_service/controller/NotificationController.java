package com.order.notification_service.controller;

import com.order.notification_service.bean.NotificationRequest;
import com.order.notification_service.bean.NotificationResponse;
import com.order.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification-Service")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationResponse> getNotification(@RequestBody NotificationRequest req){
        return ResponseEntity.ok(notificationService.sendNotification(req));
    }

}
