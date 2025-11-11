package lab6;

/**
 * Checking account class that extends BankAccount
 * Includes a fee for check clearing
 */
public class CheckingAccount extends BankAccount {
    
    // Static constant for check clearing fee
    private static final double FEE = 0.15;
    
    /**
     * Constructor that takes name and initial amount
     * @param name the owner of the account
     * @param amount the initial balance
     */
    public CheckingAccount(String name, double amount) {
        // Call superclass constructor
        super(name, amount);
        
        // Set account number with -10 extension for checking accounts
        setAccountNumber(super.getAccountNumber() + "-10");
    }
    
    /**
     * Overrides withdraw method to include check clearing fee
     * @param amount the amount to withdraw
     * @return true if withdrawal successful, false otherwise
     */
    @Override
    public boolean withdraw(double amount) {
        // Add fee to withdrawal amount and call superclass withdraw
        return super.withdraw(amount + FEE);
    }
}