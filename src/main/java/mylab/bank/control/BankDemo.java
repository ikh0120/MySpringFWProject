package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        try {
            System.out.println("=== 계좌 생성 ===");
            String savings1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
            String checking1 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
            String savings2 = bank.createSavingsAccount("이영희", 30000.0, 2.0);
            
            System.out.println();
            
            bank.printAllAccounts();
            
            System.out.println();
            
            System.out.println("=== 입금/출금 테스트 ===");
            bank.deposit(savings1, 5000.0);
            bank.withdraw(checking1, 3000.0);
            
            System.out.println();
            
            System.out.println("=== 이자 적용 테스트 ===");
            SavingAccount savingsAccount = (SavingAccount) bank.findAccount(savings1);
            savingsAccount.applyInterest();
            
            System.out.println();
            
            System.out.println("=== 계좌 이체 테스트 ===");
            bank.transfer(savings2, checking1, 5000.0);
            
            System.out.println();
            
            bank.printAllAccounts();
            
            // 예외 테스트
            try {
                bank.withdraw(checking1, 10000.0);  // 출금 한도 초과
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
            try {
                bank.withdraw(checking1, 50000.0);  // 출금 한도 초과 및 잔액 부족
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
            try {
                bank.findAccount("AC9999");  // 존재하지 않는 계좌
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}