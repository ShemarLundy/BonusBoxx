package com.ShemarLundy.BonusBoxx.Repository;

import com.ShemarLundy.BonusBoxx.Model.Notification;
import com.ShemarLundy.BonusBoxx.Model.UserNotifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotifications, Long> {
    @Modifying
    @Query("DELETE FROM UserNotifications n WHERE n.customer.ID = :customerID AND n.notification.ID = :notificationID")
    void deleteNotificationFromInbox(@Param("customerID") Long customerID, @Param("notificationID") Long notificationID);

    @Modifying
    @Query("DELETE FROM UserNotifications n WHERE n.customer.id = :customerID AND n.notification.ID IN :notificationID")
    void batchDeleteFromInbox(@Param("customerID") Long customerID, @Param("notificationID") List<Long> notificationIDs);

    @Query("SELECT u FROM UserNotifications u INNER JOIN Notification n ON u.notification.ID = n.ID " +
            "WHERE u.customer.ID = :customerID")
    List<UserNotifications> fetchInbox(@Param("customerID") Long customerID);
    @Modifying
    @Query("UPDATE UserNotifications u SET u.was_read = true WHERE u.notification.ID = :notificationID " +
            "AND u.customer.ID = :customerID")
    void markAsRead(Long customerID, Long notificationID);
}
