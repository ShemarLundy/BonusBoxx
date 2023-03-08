package com.ShemarLundy.BonusBoxx.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class StoreAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(mappedBy = "storeAdmin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Store store;
    @OneToMany(mappedBy = "storeAdmin")
    private List<Notification> notifications;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
