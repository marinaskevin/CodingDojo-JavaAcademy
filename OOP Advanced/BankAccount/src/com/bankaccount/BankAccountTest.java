package com.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acct1 = new BankAccount();
		BankAccount acct2 = new BankAccount();
		acct1.getBalances();
		acct1.depositMoney(100, "Checking");
		acct1.depositMoney(500, "Savings");
		acct1.getBalances();
		acct2.getBalances();
		acct2.depositMoney(200, "Checking");
		acct2.depositMoney(700, "Savings");
		acct2.getBalances();
		acct1.withdrawMoney(50, "Checking");
		acct1.getBalances();
		BankAccount.getTotalBankMoney();
	}

}
