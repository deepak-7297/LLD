package com.splitwise.management.java.services;

import com.splitwise.management.java.model.User;
import com.splitwise.management.java.model.split.Split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private Map<User, Map<User, Integer>> balanceSheet;

    public ExpenseManager(){
        balanceSheet = new HashMap<User, Map<User, Integer>>();
    }

    public void addExpense(User user, Integer expenseAmount, List<Split> splitAmongs, String topic){

    }

    public void settleExpense(User user, User owedUser, Integer settledAmount){}

    public Map<User, Integer> showExpense(User user){
        if(balanceSheet.containsKey(user)){
            return balanceSheet.get(user);
        }
        return null;
    }
}
