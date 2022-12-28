package com.kezbek.application.helper;

import com.kezbek.application.entity.TierType;
import org.springframework.stereotype.Component;

@Component("count cashback")
public class CountCashback {
    public Double getCashbackTypeA(int totalProduct, Double amount){
        switch (totalProduct){
            case 1:
                if (amount >= 0 && amount < 100000)
                    return 1.2;
                else if (amount >= 100000 && amount < 500000)
                    return 1.75;
                else if (amount >= 500000)
                    return 2.3;
            case 2:
                if (amount >= 500000 && amount < 1000000)
                    return 2.45;
                else if (amount >= 1000000 && amount < 1500000)
                    return 2.75;
                else if (amount >= 1500000)
                    return 2.95;
            default:
               if ((totalProduct >= 3) && (amount > 1500000))
                   return 3.35;
               else
                   return 0.0;
        }
    }
    public Double getCashbackTypeB(TierType tierType, int totalTransaction){
        switch (tierType){
            case BRONZE:
                switch (totalTransaction){
                    case 3: return 15000.0;
                    case 5: return 25000.0;
                    case 7: return 35000.0;
                    default: return 0.0;
                }
            case SILVER:
                switch (totalTransaction){
                    case 3: return 17500.0;
                    case 5: return 28500.0;
                    case 7: return 37500.0;
                    default: return 0.0;
                }
            case GOLD:
                switch (totalTransaction){
                    case 3: return 18000.0;
                    case 5: return 29000.0;
                    case 7: return 38000.0;
                    default: return 0.0;
                }
            default: return 0.0;
        }
    }
}
