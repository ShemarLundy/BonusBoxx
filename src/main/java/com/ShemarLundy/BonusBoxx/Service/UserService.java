package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.User;

public interface UserService {

    public User createUser(User user);

    public void userHelper(User user);

    public String deleteUser(Long userID);

    public User getUser(Long userID);

    public void updateUser(Long userID, User updatedUser);

    void createEmployee(User employee, Long storeID);

    void addStoreToCustomer(Long userID, Long storeID);


}
