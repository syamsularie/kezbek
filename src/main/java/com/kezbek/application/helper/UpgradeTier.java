package com.kezbek.application.helper;

import com.kezbek.application.entity.TierType;
import org.springframework.stereotype.Component;

@Component("upgrade tier")
public class UpgradeTier {
    public TierType upgrade(TierType currentTier){
        switch (currentTier){
            case BRONZE:
                return TierType.SILVER;
            case SILVER:
                return TierType.GOLD;
            case GOLD:
                return currentTier;
            default:
                return TierType.BRONZE;
        }
    }
}
