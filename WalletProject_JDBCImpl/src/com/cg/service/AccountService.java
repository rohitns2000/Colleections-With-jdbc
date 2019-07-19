package com.cg.service;

import java.util.Map;

import com.cg.bean.Account;
import com.cg.dao.AccountDAOImpl;
import com.cg.exception.InsufficientFundException;

public class AccountService implements Gst,Transaction{
	AccountDAOImpl dao = new AccountDAOImpl();
	
	public boolean addAccount(Account ob)
	{
		return dao.addAccount(ob);
	}
	
	public Map<Long,Account> getAllAccounts(){
		return dao.getAllAccounts();
	}
	
	public boolean commit(Account o)
	{
		return dao.updateAccount(o);
	}
	
	public Account findAccount(long mobileno)
	{
		return dao.getAccount(mobileno);
	}
	
	public boolean deleteAccount(Long phone) {
		return dao.deleteAccount(phone);
	}

	@Override
	public double withdraw(Account ob, double amount) throws InsufficientFundException {
			// TODO Auto-generated method stub
			double new_balance=ob.getBalance()-amount;
			if(new_balance < 1000)
			{
				new_balance=ob.getBalance();
				//System.out.println("Insufficient Balance");
				//throw new RuntimeException("Insufficient Fund. Cannot Process Withdrawal");
				throw new InsufficientFundException("Insufficient Fund. Cannot Process Withdrawal",new_balance);
			}
			ob.setBalance(new_balance);
			return new_balance;
		
	}

	@Override
	public double deposit(Account ob, double amount) {
		// TODO Auto-generated method stub
		double new_balance= ob.getBalance()+amount;
		ob.setBalance(new_balance);
		return new_balance;
	}

	@Override
	public boolean transferMoney(Account from, Account to, double amount) {
		double new_balance = from.getBalance() - amount; 
		if(new_balance < 1000.00)
		{
			new_balance=from.getBalance();
			System.out.println("Insufficient balance!");
			return false;
		}
		from.setBalance(new_balance);
		to.setBalance(to.getBalance()+amount);
		
		return true;
	}

	@Override
	public double calculateTax(double PCT, double amount) {
		// TODO Auto-generated method stub
		return amount*Gst.PCT_5;
	}
	
	

}
