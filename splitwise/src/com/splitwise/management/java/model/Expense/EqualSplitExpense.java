package com.splitwise.management.java.model.Expense;

import com.splitwise.management.java.model.User;
import com.splitwise.management.java.model.split.EqualSplit;
import com.splitwise.management.java.model.split.Split;

import java.util.List;
import java.util.UUID;

public class EqualSplitExpense extends Expense{
    public EqualSplitExpense(String topic, Integer amount,User paidBy, List<Split> splitAmongs){
        super(topic, amount, paidBy, splitAmongs);
    }
    @Override
    public Boolean validate() {
        for(Split split: getSplitAmongs()){
            if(!(split instanceof EqualSplit))
                return false;
        }
        return true;
    }
}
