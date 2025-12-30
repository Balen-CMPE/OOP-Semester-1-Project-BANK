

package bank;



import java.util.Date;

public class BankAccount implements bank_interface {
    
    
    private String pinCode;

    private int accountNumber;
    private String transactionId;
    private Date transactionDate;
    private String type;
    private double WithdrawAmount;
    private double DepositAmount;
    private double TransferAmount;
    private double balance;
    
    public BankAccount(int accountNumber, String type, double initialBalance, String pinCode) {
    this.accountNumber = accountNumber;
    this.type = type;
    this.balance = initialBalance;
    this.pinCode = pinCode;  
}
    
    public BankAccount() {
        this.balance = 0.0;
    }
    
    
    
    public boolean Deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.DepositAmount = amount;
            this.transactionDate = new Date();
            this.transactionId = generateTransactionId();
            return true;
        }
        return false;
    }
    
    @Override
    public void withdrawCash() {
        System.out.println("Withdraw operation");
    }
    
    public boolean setWithdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            this.WithdrawAmount = amount;
            this.transactionDate = new Date();
            this.transactionId = generateTransactionId();
            return true;
        }
        return false;
    }
    
    @Override
    public void transfer() {
        System.out.println("Transfer operation");
    }
    
    public boolean setTransfer(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            this.TransferAmount = amount;
            this.transactionDate = new Date();
            this.transactionId = generateTransactionId();
            return true;
        }
        return false;
    }
    
    public boolean transfer(BankAccount targetAccount, double amount) {
        if (this.setTransfer(amount)) {
            targetAccount.Deposit(amount);
            return true;
        }
        return false;
    }
    
    @Override
    public void checkBalance() {
        System.out.println("Balance: " + this.balance);
    }
    
    @Override
    public void loan() {
        System.out.println("Loan operation");
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public Date getDate() {
        return transactionDate;
    }
    
    public double getAmount() {
        return balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public boolean verifyPin(String enteredPin) {
    return this.pinCode.equals(enteredPin);
}
    public String getPinCode() {
    return pinCode;
}
    public void setPinCode(String pinCode) {
    this.pinCode = pinCode;
}
}