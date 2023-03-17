package com.ShemarLundy.BonusBoxx.Repository;

import com.ShemarLundy.BonusBoxx.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Optional<Customer> findByUserId(Long userId);

}
