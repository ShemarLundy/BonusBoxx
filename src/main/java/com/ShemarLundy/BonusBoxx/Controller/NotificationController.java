package com.ShemarLundy.BonusBoxx.Controller;

import com.ShemarLundy.BonusBoxx.Model.Notification;
import com.ShemarLundy.BonusBoxx.Model.UserNotifications;
import com.ShemarLundy.BonusBoxx.Service.NotificationService;
import com.ShemarLundy.BonusBoxx.Service.UserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    UserNotificationService userNotificationService;

    @PostMapping("/create/{adminID}")
    public String createNotification(@RequestBody Notification notification, @PathVariable Long adminID){
        notificationService.createNotification(notification, adminID);
        return "Notification was successfully created";
    }

    @DeleteMapping("/delete/{customerID}/{notificationID}")
    public String deleteNotification(@PathVariable Long customerID, @PathVariable Long notificationID){
        userNotificationService.deleteUserNotification(customerID, notificationID);
        return "notification was successfully deleted";
    }

    @DeleteMapping("batch/delete/{customerID}")
    public String batchDeleteNotifications(@PathVariable Long customerID, @RequestParam List<Long> notificationIDs){
        userNotificationService.batchDeleteUserNotifications(customerID, notificationIDs);
        return "All selected notifications where deleted";
    }

    @GetMapping("/inbox/{customerID}")
    public List<Notification> getUserInbox(@PathVariable Long customerID){
        return userNotificationService.getInbox(customerID);
    }

    @PostMapping("/read/{customerID}/{notificationID}")
    public String markAsRead(@PathVariable Long customerID, @PathVariable Long notificationID){
        userNotificationService.updateMessageReadStatus(customerID,notificationID);
        return "message was marked as read";
    }
}
