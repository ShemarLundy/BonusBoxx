package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.Customer;
import com.ShemarLundy.BonusBoxx.Model.Notification;
import com.ShemarLundy.BonusBoxx.Model.UserNotifications;
import com.ShemarLundy.BonusBoxx.Repository.UserNotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserNotificationServiceImpl implements UserNotificationService{
    @Autowired
    UserNotificationRepository userNotificationRepository;
    @Override
    public UserNotifications createUserNotification(Long notificationID) {
        UserNotifications inbox = new UserNotifications();
        Notification notification = new Notification();
        Customer customer = new Customer();

        Long customerID = 1L;
        inbox.setWas_read(false);

        notification.setID(notificationID);
        inbox.setNotification(notification);

        customer.setID(customerID);
        inbox.setCustomer(customer);

        userNotificationRepository.save(inbox);
        return null;
    }

    @Override
    @Transactional
    public void deleteUserNotification(Long customerID, Long notificationID) {
       userNotificationRepository.deleteNotificationFromInbox(customerID,notificationID);
    }

    @Override
    @Transactional
    public void batchDeleteUserNotifications(Long customerID, List<Long> notificationIDs) {
        userNotificationRepository.batchDeleteFromInbox(customerID,notificationIDs);
    }

    @Override
    public List<Notification> getInbox(Long customerID) {
        List<UserNotifications> fetchedNotification = userNotificationRepository.fetchInbox(customerID);

        List<Notification> inbox = new ArrayList<>();

        for (int notification = 0; notification < fetchedNotification.size(); notification++) {
            Notification messageObject = new Notification();
            messageObject.setID(fetchedNotification.get(notification).getNotification().getID());
            messageObject.setBody(fetchedNotification.get(notification).getNotification().getBody());
            messageObject.setSubject(fetchedNotification.get(notification).getNotification().getSubject());
            inbox.add(messageObject);
        }
        return inbox;
    }

    @Override
    @Transactional
    public void updateMessageReadStatus(Long customerID, Long notificationID) {
        userNotificationRepository.markAsRead(customerID,notificationID);
    }
}
