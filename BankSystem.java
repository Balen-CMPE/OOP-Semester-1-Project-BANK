package bank;

import java.util.Scanner;
import java.util.ArrayList;

public class BankSystem {
    
    private Scanner scanner;
    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;
    private ArrayList<BankAccount> accounts;
    private ATM atm;
    private int customerIdCounter;
    private int employeeIdCounter;
    
    public BankSystem() {
        this.scanner = new Scanner(System.in);
        this.customers = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.atm = new ATM("ATM001", "Sulaymaniyah TIUS Branch");
        this.customerIdCounter = 1;
        this.employeeIdCounter = 1;
    }
    
    public void start() {
        System.out.println("========================================");
        System.out.println("   Welcome to TIUS Bank System");
        System.out.println("========================================\n");
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Register as Customer");
            System.out.println("2. Register as Employee");
            System.out.println("3. Customer Login");
            System.out.println("4. Employee Login");
            System.out.println("5. ATM Services");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    Customer newCustomer = Customer.register(scanner, customers, customerIdCounter);
                    if (newCustomer != null) {
                        customers.add(newCustomer);
                        customerIdCounter++;
                    }
                    break;
                case 2:
                    Employee newEmployee = Employee.register(scanner, customers, employees, employeeIdCounter);
                    if (newEmployee != null) {
                        employees.add(newEmployee);
                        employeeIdCounter++;
                    }
                    break;
                case 3:
                    Customer loggedCustomer = Customer.authenticate(scanner, customers);
                    if (loggedCustomer != null) {
                        loggedCustomer.showCustomerMenu(scanner, accounts);
                    }
                    break;
                case 4:
                    Employee loggedEmployee = Employee.authenticate(scanner, employees);
                    if (loggedEmployee != null) {
                        loggedEmployee.showEmployeeMenu(scanner, customers, accounts);
                    }
                    break;
                case 5:
                    handleATM();
                    break;
                case 6:
                    running = false;
                    System.out.println("\nThank you for using TIUS Bank System!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        
        scanner.close();
    }
    
    private void handleATM() {
        System.out.println("\n--- ATM Services ---");
        System.out.println("Location: " + atm.getLocation());
        
        System.out.print("\nEnter Account Number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        
        BankAccount account = null;
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                account = acc;
                break;
            }
        }
        
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        
        atm.showATMMenu(scanner, account);
    }
}