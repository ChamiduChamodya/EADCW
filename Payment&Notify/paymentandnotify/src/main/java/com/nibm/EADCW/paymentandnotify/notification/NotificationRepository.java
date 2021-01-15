package com.nibm.EADCW.paymentandnotify.notification;

import com.nibm.EADCW.paymentandnotify.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query("select n from Notification n where n.email=?1")
    List<Notification> findNotificationByEmail(String email);

}