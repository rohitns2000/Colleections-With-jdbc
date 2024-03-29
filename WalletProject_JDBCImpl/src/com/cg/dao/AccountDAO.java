package com.cg.dao;

import java.sql.SQLException;
import java.util.Map;

import com.cg.bean.Account;

public interface AccountDAO {
	public boolean addAccount(Account ob);
	public boolean updateAccount(Account ob);
	public boolean deleteAccount(Long o);
	public Account getAccount(Long id);
	public Map<Long,Account> getAllAccounts();
	Account getAccount(long mobileno);
}
