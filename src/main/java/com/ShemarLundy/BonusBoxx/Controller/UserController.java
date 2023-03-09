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

    @PostMapping("/create")
    public String createUser(@RequestBody User user){
        userService.userHelper(user);
        return "New User was added";
    }

    @DeleteMapping("/delete/{userID}")
    public String deleteUser(@PathVariable Long userID){
        userService.deleteUser(userID);
        return "User was successfully deleted";
    }

    @GetMapping("/get/{userID}")
    public User getUser(@PathVariable Long userID){
        return userService.getUser(userID);
    }

    @PostMapping("/update/{userID}")
    public String updateUser(@PathVariable Long userID, @RequestBody User updatedUser){
        userService.updateUser(userID, updatedUser);
        return "User was successfully updated!";
    }

}
