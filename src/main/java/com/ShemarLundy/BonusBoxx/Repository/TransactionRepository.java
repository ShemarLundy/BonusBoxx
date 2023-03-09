package com.ShemarLundy.BonusBoxx.Repository;

import com.ShemarLundy.BonusBoxx.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
