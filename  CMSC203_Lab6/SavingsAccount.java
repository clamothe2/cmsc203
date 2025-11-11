package lab6;

/**
 * Savings account class that extends BankAccount
 * Allows multiple savings accounts under one account number
 * Includes interest rate calculation
 */
public class SavingsAccount extends BankAccount {
    
    // Instance variable for annual interest rate (2.5%)
    private double rate = 0.025;
    
    // Instance variable to track which savings account this is
    private int savingsNumber = 0;
    
    // Instance variable that hides superclass accountNumber
    private String accountNumber;
    
    /**
     * Constructor that takes name and initial balance
     * @param name the owner of the account
     * @param balance the initial balance
     */
    public SavingsAccount(String name, double balance) {
        // Call superclass constructor
        super(name, balance);
        
        // Build account number: superclass accountNumber + "-" + savingsNumber
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
    
    /**
     * Copy constructor that creates another savings account for same person
     * @param oldAccount the original savings account
     * @param balance the initial balance for new account
     */
    public SavingsAccount(SavingsAccount oldAccount, double balance) {
        // Call superclass copy constructor
        super(oldAccount, balance);
        
        // Set savingsNumber to one more than original account
        savingsNumber = oldAccount.savingsNumber + 1;
        
        // Build account number with new savingsNumber
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
    
    /**
     * Calculates one month's interest and deposits it
     */
    public void postInterest() {
        // Calculate monthly interest: (rate / 12) * balance
        double monthlyInterest = (rate / 12) * getBalance();
        
        // Deposit the interest
        deposit(monthlyInterest);
    }
    
    /**
     * Overrides getAccountNumber to return this class's accountNumber
     * @return the account number
     */
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}