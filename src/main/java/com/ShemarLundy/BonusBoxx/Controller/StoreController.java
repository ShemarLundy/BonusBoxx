package com.ShemarLundy.BonusBoxx.Controller;

import com.ShemarLundy.BonusBoxx.Model.Store;
import com.ShemarLundy.BonusBoxx.Model.User;
import com.ShemarLundy.BonusBoxx.Service.StoreService;
import com.ShemarLundy.BonusBoxx.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService storeService;
    @Autowired
    private UserService userService;
    @PostMapping("/create/store/{adminID}")
    public String createStore(@RequestBody Store store, @PathVariable Long adminID){
        storeService.createStore(store, adminID);
        return "Store was successfully created.";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@RequestBody User employee){
        UserController createUser = new UserController();
        createUser.createUser(employee);
        return "employee was created";
    }

    @PutMapping("/update/{storeID}/store")
    public String updateStore(@RequestBody Store store, @PathVariable Long storeID){
        storeService.updateStore(store, storeID);
        return "store successfully updated";
    }

    @DeleteMapping("/delete/{storeID}/store")
    public String deleteStore(@PathVariable Long storeID){
        storeService.deleteStore(storeID);
        return "store was successfully deleted";
    }

    @GetMapping("/get/{adminID}/store")
    public Store getStoreDetails(@PathVariable Long adminID){
        return storeService.getStoreDetails(adminID);
    }
}
