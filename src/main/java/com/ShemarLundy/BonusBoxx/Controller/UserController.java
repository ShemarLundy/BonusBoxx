package com.ShemarLundy.BonusBoxx.Controller;

import com.ShemarLundy.BonusBoxx.Model.User;
import com.ShemarLundy.BonusBoxx.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create/user")
    public String createUser(@RequestBody User user){
        userService.userHelper(user);
        return "New User was added";
    }

    @PostMapping("/create/employee/{storeID}/store")
    public String createEmployee(@RequestBody User employee, @PathVariable Long storeID){
        userService.createEmployee(employee, storeID);
        return "New Employee was added";
    }

    @DeleteMapping("/delete/{userID}/user")
    public String deleteUser(@PathVariable Long userID){
        userService.deleteUser(userID);
        return "User was successfully deleted";
    }

    @DeleteMapping("/delete/{userID}/employee")
    public String deleteEmployee(@PathVariable Long userID){
        userService.deleteUser(userID);
        return "Employee was successfully deleted";
    }

    @GetMapping("/get/{userID}/user")
    public User getUser(@PathVariable Long userID){
        return userService.getUser(userID);
    }

    @PutMapping("/update/{userID}/user")
    public String updateUser(@PathVariable Long userID, @RequestBody User updatedUser){
        userService.updateUser(userID, updatedUser);
        return "User was successfully updated!";
    }

    @PutMapping("update/new/shopper/{userID}/{storeID}/store")
    public String addStoreToCustomer(@PathVariable Long userID, @PathVariable Long storeID){
        userService.addStoreToCustomer(userID, storeID);
        return "Customer was updated with a new store";
    }

}
