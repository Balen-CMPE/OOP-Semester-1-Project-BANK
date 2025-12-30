

package bank;



import java.util.Scanner;

public class ATM implements ATM_interface {
    
    private String atmId;
    private String location;
    
    public ATM() {
    }
    
    public ATM(String atmId, String location) {
        this.atmId = atmId;
        this.location = location;
    }
    
    @Override
    public void withdrawCash() {
        System.out.println("Withdraw cash operation");
    }
    
    public void withdrawCash(BankAccount account, double amount) {
        if (account != null && account.setWithdraw(amount)) {
            System.out.println("Withdrawal successful: " + amount);
            System.out.println("Remaining balance: " + account.getBalance());
        } else {
            System.out.println("Withdrawal failed");
        }
    }
    
    @Override
    public void checkBalance() {
        System.out.println("Check balance operation");
    }
    
    public void checkBalance(BankAccount account) {
        if (account != null) {
            System.out.println("Current balance: " + account.getBalance());
        }
    }
    
    
    
    public boolean deposit(BankAccount account, double amount) {
        if (account != null && account.Deposit(amount)) {
            System.out.println("Deposit successful: " + amount);
            System.out.println("New balance: " + account.getBalance());
            return true;
        } else {
            System.out.println("Deposit failed");
            return false;
        }
    }
    
    public void showATMMenu(Scanner scanner, BankAccount account) {
    System.out.print("Enter PIN code: ");
    String enteredPin = scanner.nextLine();
    
    int attempts = 0;
    while (!account.verifyPin(enteredPin) && attempts < 2) {
        attempts++;
        System.out.println("Incorrect PIN. " + (3 - attempts) + " attempts remaining.");
        System.out.print("Enter PIN code: ");
        enteredPin = scanner.nextLine();
    }
    
    if (!account.verifyPin(enteredPin)) {
        System.out.println("Too many incorrect attempts. Access denied.");
        return;
    }
    
    boolean usingATM = true;
    
    while (usingATM) {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Exit ATM");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                checkBalance(account);
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                scanner.nextLine();
                withdrawCash(account, withdrawAmount);
                break;
            case 3:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                scanner.nextLine();
                deposit(account, depositAmount);
                break;
            case 4:
                usingATM = false;
                System.out.println("Thank you for using our ATM.");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
    
    public String getAtmId() {
        return atmId;
    }
    
    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void transfer() {
        throw new UnsupportedOperationException("Not supported yet."); }

    @Override
    public boolean Deposit(double amount) {
        throw new UnsupportedOperationException("Not supported yet.");}

    

    @Override
    public void loan() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}