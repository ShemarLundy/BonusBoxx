package com.ShemarLundy.BonusBoxx.Service;

import com.ShemarLundy.BonusBoxx.Model.Reward;
import com.ShemarLundy.BonusBoxx.Repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardServiceImpl implements RewardService{
    @Autowired
    RewardRepository rewardRepository;
    @Override
    public Reward createReward(Reward reward) {
        return rewardRepository.save(reward);
    }
}
