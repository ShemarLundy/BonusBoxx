package com.ShemarLundy.BonusBoxx.Repository;

import com.ShemarLundy.BonusBoxx.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
