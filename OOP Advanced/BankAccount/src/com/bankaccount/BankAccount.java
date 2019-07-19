package com.bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int numberOfAccounts = 0;
	private static double totalBankMoney = 0;
	public BankAccount() {
		accountNumber = randomAccountNumber();
		numberOfAccounts++;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void depositMoney(double amount,String acctType) {
		if(acctType == "Checking") {
			checkingBalance += amount;
			totalBankMoney += amount;
		}
		if(acctType == "Savings") {
			savingsBalance += amount;
			totalBankMoney += amount;
		}
	}
	public void withdrawMoney(double amount,String acctType) {
		if(acctType == "Checking" && checkingBalance >= amount) {
			checkingBalance -= amount;
			totalBankMoney -= amount;
		}
		if(acctType == "Savings" && savingsBalance >= amount) {
			savingsBalance -= amount;
			totalBankMoney -= amount;
		}
	}
	public void getBalances() {
		System.out.println("\nAccount "+accountNumber);
		System.out.printf("Checking: $%,.2f \n",checkingBalance);
		System.out.printf("Savings: $%,.2f \n",savingsBalance);
	}
	public static void getTotalBankMoney() {
		System.out.printf("\nTotal money in "+numberOfAccounts+" bank accounts: $%,.2f",totalBankMoney);
	}
	private String randomAccountNumber() {
		Random rand = new Random();
		long acctNum = 0;
		for(int i=0; i<10; i++) {
			acctNum *= 10;
			acctNum += rand.nextInt(10);
		}
		return String.format("%010d", acctNum);
	}
	
}
