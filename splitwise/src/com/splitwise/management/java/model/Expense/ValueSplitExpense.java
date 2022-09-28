package com.splitwise.management.java.model.Expense;

import com.splitwise.management.java.model.User;
import com.splitwise.management.java.model.split.PercentageSplit;
import com.splitwise.management.java.model.split.Split;
import com.splitwise.management.java.model.split.ValueSplit;

import java.util.List;

public class ValueSplitExpense extends Expense{
    public ValueSplitExpense(String topic, Integer amount, User paidBy, List<Split> splitAmongs){
        super(topic, amount, paidBy, splitAmongs);
    }
    @Override
    public Boolean validate() {
        int totValue=0;
        for(Split split: getSplitAmongs()){
            if(!(split instanceof ValueSplit))
                return false;

            int value = split.getAmount();
            totValue+=value;
        }
        return totValue==getAmount();
    }
}
