package com.splitwise.management.java;

import com.splitwise.management.java.model.Expense.Expense;
import com.splitwise.management.java.model.Expense.PercentageSplitExpense;
import com.splitwise.management.java.model.User;
import com.splitwise.management.java.model.split.PercentageSplit;
import com.splitwise.management.java.model.split.Split;
import com.splitwise.management.java.services.ExpenseManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Splitwise {

//    EXPENSE u1 300 3 u1 u2 u3 <expense_type> <share1> <share2> <share3>
    public static void main(String[] args){
        ExpenseManager expenseManager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];
            switch (commandType){
                case "SHOW":
                    User user=new User();
                    expenseManager.showExpense(user);
                    break;
                case "EXPENSE":
                    String expenseType = commands[Integer.parseInt(3 + commands[3])];
                    Integer expenseAmount = Integer.parseInt(commands[2]);
                    List<User> users = new ArrayList<>();
                    for(int i=0;i<Integer.parseInt(commands[3]); i++){
                        User user = new User();
                        users.add(user);
                    }
                    switch (expenseType){
                        case "PERCENTAGE":
                            List<Split> percentageSplits = new ArrayList<>();
                            String topic=new String();User paidBy= new User();
                            for(int i=0; i<Integer.parseInt(commands[3]);i++){
                                int amount = expenseAmount%Integer.parseInt(4 + commands[3] + i)*100;
                                PercentageSplit percentageSplit = new PercentageSplit(users.get(i), amount, Integer.parseInt(4 + commands[3] + i));
                                percentageSplits.add(percentageSplit);
                            }
//                            PercentageSplitExpense percentageSplitExpense = new PercentageSplitExpense(topic, expenseAmount, paidBy, percentageSplits);
                            expenseManager.addExpense(paidBy, expenseAmount, percentageSplits, topic, new PercentageSplitExpense());
                    }
            }
        }
    }
}
