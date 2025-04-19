// `Bank.java` – Handles operations on all accounts (add, search, list, etc.)

import java.util.ArrayList;
import java.util.Scanner;

public class Bank{


// store object in arraylist
ArrayList<BankAccount> accounts = new ArrayList<>();

//  Create a new bank account  

public void createAccount(Scanner sc){

    String name;
    
    // ✅ Keep asking until valid name is entered
    while (true) {
        System.out.print("Enter your name: ");
        name = sc.nextLine();


        // Regular expression to allow only alphabets and spaces
        if (name.matches("^[a-zA-Z\\s]+$")) {
            break;
        } else {
            System.out.println("❌ Invalid name! Please enter letters and spaces only.");
        }
    }


    // Regular expression to allow only  numbers 0-9
    String accountNumber;

    while (true) {
        System.out.print("Enter a Unique Account Number: ");
        accountNumber = sc.nextLine();
    
        // Simple regex to allow only digits
        if (!accountNumber.matches("\\d+")) {
            System.out.println("❌ Invalid! Please enter numbers only.");
            continue;
        }
    
        // Check if account number already exists
        boolean duplicate = false;
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                System.out.println("⚠️ Account number already exists.");
                duplicate = true;
                break;
            }
        }
    
        if (!duplicate) {
            break; // Valid and unique
        }
    }
    

    // regular expression

    double balance = 0;

    while (true) {
        System.out.print("Enter Initial Deposit (Min ₹500): ");
        String input = sc.nextLine();
    
        // Check if input is only digits (optional decimal allowed)
        if (input.matches("\\d+(\\.\\d+)?")) {
            balance = Double.parseDouble(input);
            if (balance >= 500) {
                accounts.add(new BankAccount(name, accountNumber, balance));
                System.out.println("✅ Account created successfully!");
                break;
            } else {
                System.out.println("❌ Minimum ₹500 is required to open an account.");
            }
        } else {
            System.out.println("❌ Invalid input! Please enter a valid numeric amount.");
        }
    }
}
//  check the user type right account or not 

public BankAccount findAccount(String accNo) {
    for (BankAccount acc : accounts) {
        if (acc.getAccountNumber().equals(accNo)) {
            return acc;
        }
    }
    return null;
}


//  method logic to deposit money
public void deposit(Scanner sc){

    System.out.print("Enter Account Number :  ");
  String accNo = sc.nextLine();

BankAccount acc = findAccount(accNo);

if(acc!=null){
    System.out.print("Enter deposite amount : ");
    double amount = sc.nextDouble();
    acc.deposite(amount);
    System.out.println("Amount Deposited Successfully! ");
}
else{
    System.out.println("Account Not Found.");
}
}

//  method to widtdraw AMOUNT

public void withdraw(Scanner sc){
    System.out.print("Enter Account Number :  ");
    String accNo = sc.nextLine();
  
  BankAccount acc = findAccount(accNo);
  
  if(acc!=null){
    System.out.print("Enter Amount to Withdraw: ");
    double amount = sc.nextDouble();
  if(acc.withdraw(amount)){
    System.out.println("Amount withdraw Successfully! ");
  }
  else {
    System.out.println("Insufficient Balance.");
}
} else {
System.out.println("Account Not Found.");
}
}

//  method to check Balance

public void checkBalance(Scanner sc){
    System.out.print("Enter Account Number :  ");
    String accNo = sc.nextLine();
  
  BankAccount acc = findAccount(accNo);
  
  if(acc!=null){
    System.out.println("💰Current Balance: ₹" + acc.getBalance());
} else {
    System.out.println(" Account Not Found.");
}

}


//  show user details
public void showDetails(Scanner sc) {
    System.out.print("Enter Account Number: ");
    String accNo = sc.nextLine();
    BankAccount acc = findAccount(accNo);
    if (acc != null) {
        System.out.println(" Account Details:\n" + acc);
    } else {
        System.out.println(" Account Not Found.");
    }
}




}








