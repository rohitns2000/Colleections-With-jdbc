package com.cg.dao;
import java.sql.*;
import java.util.Map;

import com.cg.bean.Account;
public class AccountDAOImpl implements AccountDAO{

	@Override
	public boolean addAccount(Account ob) {
		Connection con=null;
		PreparedStatement selectSt = null;
		PreparedStatement updateSt = null;

	      try {
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String user="hr";
				String pass="hr";
				
				con = DriverManager.getConnection(url, user, pass);
				System.out.println("Connected Successfully!");
				con.setAutoCommit(false);
				int id = ob.getAid();
				selectSt = con.prepareStatement("Select * from account where aid =?");
				selectSt.setInt(1,ob.getAid());
				ResultSet rs = selectSt.executeQuery();
				while(rs.next())
				{
					if(id == rs.getInt("aid"))
					{System.out.println("Empoyee Already Exists!");}
				}
				updateSt = con.prepareStatement("insert into account values (?,?,?,?)");
				updateSt.setInt(1, ob.getAid());
				updateSt.setLong(2, ob.getMobile());
				updateSt.setString(3, ob.getAccountholder());
				updateSt.setDouble(4, ob.getBalance());
				int a = updateSt.executeUpdate();
				if(a!=1)
				{
					System.err.println("Empoyee not Added!!!");
					}
				}
	      catch(SQLException e)
	      {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(e.getMessage()+" "+e.getErrorCode()+" "+e.getSQLState());
				e.printStackTrace();
	      }
	    finally {
	      try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	      
		return true;
	}

	@Override
	public boolean updateAccount(Account ob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(Long phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account getAccount(long mobileno){

	return null;
      
      
	}

	@Override
	public Map<Long, Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
