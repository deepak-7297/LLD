package com.splitwise.management.java.model.split;

import com.splitwise.management.java.model.User;

public class PercentageSplit extends Split{
    private Integer percentage;

    public PercentageSplit(User user, Integer amount, int percentage){
        super(user, amount);
        this.percentage=percentage;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
