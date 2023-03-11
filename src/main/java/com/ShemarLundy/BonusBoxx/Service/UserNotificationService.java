package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.Notification;
import com.ShemarLundy.BonusBoxx.Model.UserNotifications;

import java.util.List;

public interface UserNotificationService {
    UserNotifications createUserNotification(Long NotificationID);
    void deleteUserNotification(Long customerID, Long notificationID);
    void batchDeleteUserNotifications(Long customerID, List<Long> notificationIDs);
    List<Notification> getInbox(Long customerID);
    void updateMessageReadStatus(Long customerID, Long notificationID);

}
