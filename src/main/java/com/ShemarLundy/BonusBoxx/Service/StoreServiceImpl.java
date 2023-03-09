package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.Store;
import com.ShemarLundy.BonusBoxx.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    StoreRepository storeRepository;
    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }
}
