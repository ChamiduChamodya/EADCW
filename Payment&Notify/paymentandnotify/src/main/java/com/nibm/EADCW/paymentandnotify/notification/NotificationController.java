package com.nibm.EADCW.paymentandnotify.notification;

import com.nibm.EADCW.paymentandnotify.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/notification/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/notification/{email}")
    public List<Notification> getNotificationByEmail(@PathVariable String email) {
        try {
            List<Notification> notification = notificationRepository.findNotificationByEmail(email);
            if (!notification.isEmpty()) {
                return notification;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(path = "/notification")
    public String createNotification(@RequestBody Notification notification) {
        try {
            notificationRepository.save(notification);
            return "successful";
        } catch (Exception e) {
            return "unsuccessful";
        }
    }
}
