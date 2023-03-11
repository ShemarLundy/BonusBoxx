package com.ShemarLundy.BonusBoxx.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String store_name;
    private String store_category;
    private Boolean is_online;
    @OneToMany(mappedBy = "store")
    private List<Employee> employees;
    @OneToMany(mappedBy = "store")
    private List<Customer> customers;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_admin_id")
    private StoreAdmin storeAdmin;
    @OneToMany(mappedBy = "store")
    private List<Reward> rewards;
    @OneToMany(mappedBy = "store")
    private List<Coupon> coupons;
    @OneToMany(mappedBy = "store")
    private List<Transaction> transaction;

    public Store() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_category() {
        return store_category;
    }

    public void setStore_category(String store_category) {
        this.store_category = store_category;
    }

    public Boolean getIs_online() {
        return is_online;
    }

    public void setIs_online(Boolean is_online) {
        this.is_online = is_online;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public StoreAdmin getStoreAdmin() {
        return storeAdmin;
    }

    public void setStoreAdmin(StoreAdmin storeAdmin) {
        this.storeAdmin = storeAdmin;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
