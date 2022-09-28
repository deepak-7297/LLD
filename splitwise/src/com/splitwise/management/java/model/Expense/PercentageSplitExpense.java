package com.splitwise.management.java.model.Expense;

import com.splitwise.management.java.model.User;
import com.splitwise.management.java.model.split.EqualSplit;
import com.splitwise.management.java.model.split.PercentageSplit;
import com.splitwise.management.java.model.split.Split;

import java.util.List;

public class PercentageSplitExpense extends Expense{
    public PercentageSplitExpense(String topic, Integer amount, User paidBy, List<Split> splitAmongs){
        super(topic, amount, paidBy, splitAmongs);
    }
    @Override
    public Boolean validate() {
        int totPercentage=0;
        for(Split split: getSplitAmongs()){
            if(!(split instanceof PercentageSplit))
                return false;

            int percentage = ((PercentageSplit) split).getPercentage();
            totPercentage+=percentage;
        }
        return totPercentage==100;
    }
}
