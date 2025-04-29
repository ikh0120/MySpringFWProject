package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.*;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;
    
    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1000;  // Starting account number
    }
    
    public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingAccount account = new SavingAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.println("저축 계좌가 생성되었습니다: " + account);
        return accountNumber;
    }
    
    public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + account);
        return accountNumber;
    }
    
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }
    
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }
    
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, 
                                                                    InsufficientBalanceException, 
                                                                    WithdrawalLimitExceededException {
        Account account = findAccount(accountNumber);
        if (account instanceof CheckingAccount) {
            ((CheckingAccount) account).withdraw(amount);
        } else {
            account.withdraw(amount);
        }
    }
    
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        
        System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
    }
    
    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account account : accounts) {
            System.out.println(account);
        }
        System.out.println("===================");
    }
}