import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // bank object
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

while(true){


    //  show menu

System.out.println("\n-------------Bank Account Management System --------------------");
System.out.println("1. Create A New Bank Account ");
System.out.println("2. Deposite Money");
System.out.println("3. Withdraw Money");
System.out.println("4. View Account Balance");
System.out.println("5. Display Full Account Details");
System.out.println("6. Exit..");
System.out.println("Enter a choice ");
try {

    // if user type the wrong input
    

int choice = sc.nextInt();
sc.nextLine();


switch (choice) {
    case 1: bank.createAccount(sc); break;
    case 2: bank.deposit(sc); break;
    case 3: bank.withdraw(sc); break;
    case 4: bank.checkBalance(sc); break;
    case 5: bank.showDetails(sc); break;
    case 6:System.out.println("👋 Thank you for using our banking system.");
            return;

    default:   System.out.println("⚠️ Invalid choice. Try again.");
     
}


} catch (InputMismatchException e) {
    System.out.println("⚠️ Please enter a valid number.");
    sc.nextLine(); // Clear buffer
}


}

    }
}
