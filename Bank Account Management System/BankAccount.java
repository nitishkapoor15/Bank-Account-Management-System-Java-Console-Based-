// BankAccount.java – Represents one account

public class BankAccount{


    //  variables to store data
private String name;
private String accountNumber;
private double balance;


//  constructor to intialize object
public BankAccount(String name, String accountNumber, double balance) {
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
}


// method to deposite Money

public void deposite(double amount){
balance +=  amount;

}


//  method to withdraw Money
public boolean withdraw(double amount){
    if(amount<=balance){
        balance -= amount;
        return true;

    }else{
        return false;

    }
}
//  getter method to get balance
public double getBalance() {
    return balance;
}


//  getter method to get AccountNumber
public String getAccountNumber() {
    return accountNumber;
}

// This method returns a string representation of the BankAccount object
@Override
public String toString() {
    return "BankAccount [name=" + name + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
}








}
