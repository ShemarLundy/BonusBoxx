package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.Store;
import com.ShemarLundy.BonusBoxx.Model.User;

public interface StoreService {

    public void createStore(Store store, Long adminID);

    void deleteStore(Long storeID);

    void updateStore(Store updatedStore, Long storeID);

    Store getStoreDetails(Long adminID);
}
