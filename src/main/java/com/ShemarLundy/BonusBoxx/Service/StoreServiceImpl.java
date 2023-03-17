package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.Store;
import com.ShemarLundy.BonusBoxx.Model.StoreAdmin;
import com.ShemarLundy.BonusBoxx.Model.User;
import com.ShemarLundy.BonusBoxx.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    StoreRepository storeRepository;

    @Override
    public void createStore(Store store, Long adminID) {
        StoreAdmin store_admin = new StoreAdmin();
        store_admin.setID(adminID);
        store.setStoreAdmin(store_admin);
        storeRepository.save(store);
    }

    @Override
    public void updateStore(Store updatedStore, Long storeID) {
        Optional <Store> fetchedStore = storeRepository.findById(storeID);
        Store newStore;
        if (fetchedStore.isPresent()){
            newStore = fetchedStore.get();
            newStore.setStore_name(updatedStore.getStore_name());
            newStore.setIs_online(updatedStore.getIs_online());

            storeRepository.save(newStore);
        }
    }

    @Override
    public void deleteStore(Long storeID) {
        Optional <Store> storeToDelete = storeRepository.findById(storeID);
        if (storeToDelete.isPresent()){
            storeRepository.deleteById(storeID);
        }
    }

    @Override
    public Store getStoreDetails(Long adminID) {
        Optional<Store> storeOptional = storeRepository.findByOwnerId(adminID);
        return getStoreHelper(storeOptional.get());
    }

    private Store getStoreHelper(Store store) {
        Store myStore = new Store();
        myStore.setStore_name(store.getStore_name());
        myStore.setStore_category(store.getStore_category());
        myStore.setIs_online(store.getIs_online());

        return myStore;
    }
}
