package model.service;

public class UserAccountService implements TaxService{

    private Double amount;
    private Double balance;

    public UserAccountService() {
    }

    public UserAccountService(Double balance) {
        this.balance = balance;
    }

    public UserAccountService(Double amount, Double balance) {
        this.amount = amount;
        this.balance = balance;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double deposit(){
        return balance += amount;
    }
}
