package models.entities;

import models.exceptions.ServicesException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void withdraw(Double amount) throws ServicesException {
        if (amount > withdrawLimit){
            throw new ServicesException("Withdraw error: The amount exceeds withdraw limit");
        } else if (amount > balance) {
            throw new ServicesException("Withdraw error: Not enough balance");
        }
        balance -= amount;
    }
}
