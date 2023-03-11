package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.Employee;
import com.ShemarLundy.BonusBoxx.Model.Notification;
import com.ShemarLundy.BonusBoxx.Model.StoreAdmin;
import com.ShemarLundy.BonusBoxx.Model.UserNotifications;
import com.ShemarLundy.BonusBoxx.Repository.NotificationRepository;
import com.ShemarLundy.BonusBoxx.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserNotificationService userNotificationService;
    @Override
    public Notification createNotification(Notification notification, Long adminID) {
        StoreAdmin storeAdmin = userRepository.findById(adminID).orElseThrow().getStoreAdmin();
        notification.setStoreAdmin(storeAdmin);
        notificationRepository.save(notification);
        if (notification.getStatus().equals("SENT")){
            userNotificationService.createUserNotification(notification.getID());
        }
        return notification;
    }
}
