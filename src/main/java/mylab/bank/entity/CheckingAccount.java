package mylab.bank.entity;

public class CheckingAccount extends Account {
    private double withdrawalLimit;
    
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }
    
    @Override
    public void withdraw(double amount) throws mylab.bank.exception.InsufficientBalanceException, 
                                              mylab.bank.exception.WithdrawalLimitExceededException {
        if (amount > withdrawalLimit) {
            throw new mylab.bank.exception.WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
        }
        super.withdraw(amount);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
    }
}
