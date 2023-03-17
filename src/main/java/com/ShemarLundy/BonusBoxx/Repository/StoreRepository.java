package com.ShemarLundy.BonusBoxx.Repository;

import com.ShemarLundy.BonusBoxx.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("SELECT store FROM Store store WHERE store.storeAdmin.id = :adminID")
    Optional<Store> findByOwnerId(@Param("adminID") Long adminID);
}
