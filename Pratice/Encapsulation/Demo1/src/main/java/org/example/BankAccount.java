package org.example;

public class BankAccount {
    // Use the keyword (private) access modifier to restrict access attributes form this bank account class from another class.
    private String accountNumber;
    private String ownerName;
    private  double balance;

    public BankAccount(){}

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }


    // Use the keyword public from the method getter and setter to ensure that all attributes of this class
    //just can be accessed from the methods when another class want to use. This is covering encapsulation in OOP concept
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0) this.balance += amount;
        System.out.println("Deposit successfully with the amount: " + amount);
        System.out.println("Account Balance: " + this.balance);
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= this.balance) this.balance -= amount;
        System.out.println("Withdraw successfully with the amount: " + amount);
        System.out.println("Account Balance: " + this.balance);
    }

    public void showBanAccountInfo(){
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Owner Number: " + this.ownerName);
        System.out.println("Account Balance: " + this.balance);
    }
}
