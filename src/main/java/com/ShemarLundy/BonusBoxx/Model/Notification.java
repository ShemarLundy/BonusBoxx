package com.ShemarLundy.BonusBoxx.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private LocalDateTime date_sent;
    private String subject;
    private String body;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_admin_id")
    private StoreAdmin storeAdmin;


    public Notification() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDateTime getDate_sent() {
        return date_sent;
    }

    public void setDate_sent(LocalDateTime date_sent) {
        this.date_sent = date_sent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StoreAdmin getStoreAdmin() {
        return storeAdmin;
    }

    public void setStoreAdmin(StoreAdmin storeAdmin) {
        this.storeAdmin = storeAdmin;
    }
}
