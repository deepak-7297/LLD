package com.splitwise.management.java.model.split;

import com.splitwise.management.java.model.User;

import java.util.function.DoubleUnaryOperator;


public abstract class Split {
    private User user;
    private Integer amount;

    public Split(User user, Integer amount){
        this.user=user;
        this.amount=amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
