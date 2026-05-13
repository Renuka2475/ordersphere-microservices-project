package com.order.notification_service.service;

import com.order.notification_service.bean.NotificationRequest;
import com.order.notification_service.bean.NotificationResponse;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

//    private NotificationResponse resp;
    public NotificationResponse sendNotification(NotificationRequest req){

        System.out.println("Notification sended::" + req.getEmail());
        NotificationResponse resp = new NotificationResponse();
        resp.setEmail(req.getEmail());
        resp.setMsg("Order Placed Successfully");
        return resp;
    }
}
