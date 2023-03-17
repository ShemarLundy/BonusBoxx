package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.*;
import com.ShemarLundy.BonusBoxx.Repository.CustomerRepository;
import com.ShemarLundy.BonusBoxx.Repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void userHelper(User user) {
        String type = user.getUser_type();
        user.setPassword(hashPassword(user.getPassword()));

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

    @Override
    public void createEmployee(User user, Long storeID) {

//        Employee employee = user.getEmployee();
//        employee.setUser(user);
//        user.setEmployee(employee);
//        createUser(user);

        Store store = new Store();
        Employee employee = user.getEmployee();

        store.setID(storeID);
        employee.setUser(user);
        employee.setStore(store);
        user.setEmployee(employee);

        user.setPassword(hashPassword(user.getPassword()));
        createUser(user);
    }

    @Override
    public String deleteUser(Long userID) {
        try{
            Optional<User> user = userRepository.findById(userID);

            if (user.isEmpty()) {
                return "User was not found.";
            }

            else {
                userRepository.deleteById(userID);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "User Deleted";
    }

    @Override
    public User getUser(Long userID) {
        User fetchedUser = userRepository.findById(userID).get();
        return getUserHelper(fetchedUser);
    }

    public User getUserHelper(User fetchedUser){
        String userType = fetchedUser.getUser_type();
        User newUser = new User();

       if (userType.equals("EMPLOYEE")){
           newUser.setFirst_name(fetchedUser.getFirst_name());
           newUser.setLast_name(fetchedUser.getLast_name());
           newUser.setEmail_address(fetchedUser.getEmail_address());
           newUser.setUser_type(fetchedUser.getUser_type());
       } else if (userType.equals("CUSTOMER")) {
           newUser.setFirst_name(fetchedUser.getFirst_name());
           newUser.setLast_name(fetchedUser.getLast_name());
           newUser.setEmail_address(fetchedUser.getEmail_address());
           newUser.setUser_type(fetchedUser.getUser_type());
       }else {
           newUser.setFirst_name(fetchedUser.getFirst_name());
           newUser.setLast_name(fetchedUser.getLast_name());
           newUser.setEmail_address(fetchedUser.getEmail_address());
           newUser.setUser_type(fetchedUser.getUser_type());
       }
       return newUser;
    }

    @Override
    public void updateUser(Long userID, User updatedUser) {
        Optional <User> fetchedUser = userRepository.findById(userID);
        User newUser = new User();
        if (fetchedUser.isPresent()){
            newUser = fetchedUser.get();
            newUser.setFirst_name(updatedUser.getFirst_name());
            newUser.setLast_name(updatedUser.getLast_name());
            newUser.setPassword(updatedUser.getPassword());
            newUser.setEmail_address(updatedUser.getEmail_address());

            userRepository.save(newUser);
        }
    }

    public String hashPassword(String password){
        String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt());
        return hashedPassword;
    }

    @Override
    public void addStoreToCustomer(Long customerID, Long storeID) {
        boolean newToStore = false;
        Optional <Customer> customer = customerRepository.findById(customerID);
        Store newStore = new Store();
        newStore.setID(storeID);

        if (customer.isPresent()){
            Customer shopper = customer.get();
            if (shopper.getStore().isEmpty()){
                List <Store> stores = shopper.getStore();
                stores.add(newStore);
                shopper.setStore(stores);
                customerRepository.save(shopper);
            }else{
                List<Store> storesShopped = shopper.getStore();
                for (int index = 0; index < storesShopped.size(); index++) {
                    if (storesShopped.get(index).getID().equals(storeID)){
                        newToStore = false;
                        break;
                    }else {
                        newToStore = true;
                    }
                }

                if (newToStore){
                    List <Store> stores = shopper.getStore();
                    stores.add(newStore);
                    shopper.setStore(stores);
                    customerRepository.save(shopper);
                }
            }
        }
    }
}
