package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.Customer;
import com.ShemarLundy.BonusBoxx.Model.Employee;
import com.ShemarLundy.BonusBoxx.Model.StoreAdmin;
import com.ShemarLundy.BonusBoxx.Model.User;
import com.ShemarLundy.BonusBoxx.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void userHelper(User user) {
        String type = user.getUser_type();
        if (type.equals("EMPLOYEE")){
            Employee employee = user.getEmployee();
            employee.setUser(user);
            user.setEmployee(employee);
            createUser(user);
        } else if (type.equals("CUSTOMER")) {
            Customer customer = user.getCustomer();
            customer.setUser(user);
            user.setCustomer(customer);
            createUser(user);
        }else {
            StoreAdmin storeAdmin = user.getStoreAdmin();
            storeAdmin.setUser(user);
            user.setStoreAdmin(storeAdmin);
            createUser(user);
        }
    }
}
