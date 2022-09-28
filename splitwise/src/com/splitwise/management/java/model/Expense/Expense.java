package com.splitwise.management.java.model.Expense;

import com.splitwise.management.java.model.User;
import com.splitwise.management.java.model.split.Split;

import java.util.List;
import java.util.UUID;

public abstract class Expense {
    private UUID id;
    private String topic;
    private Integer amount;
    private User paidBy;
    private List<Split> splitAmongs;
    private ExpenseState expenseState;

    public Expense(String topic, Integer amount,User paidBy, List<Split> splitAmongs){
        this.id = UUID.randomUUID();
        this.topic=topic;
        this.amount=amount;
        this.paidBy = paidBy;
        this.splitAmongs = splitAmongs;
        this.expenseState = ExpenseState.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplitAmongs() {
        return splitAmongs;
    }

    public void setSplitAmongs(List<Split> splitAmongs) {
        this.splitAmongs = splitAmongs;
    }

    public ExpenseState getExpenseState() {
        return expenseState;
    }

    public void setExpenseState(ExpenseState expenseState) {
        this.expenseState = expenseState;
    }

    public abstract Boolean validate();
}
