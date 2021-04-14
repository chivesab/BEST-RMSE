package team1spring2021cmpe202.AccountDAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import team1spring2021cmpe202.MySQLConnector.MySQLConnector;

public class AccountDelete {
	static PreparedStatement preparedStatement = null;
	
	public static int deleteAccountByAccountNumber (String accountNumber, MySQLConnector databaseConnector) {
		try {
			String getQueryStatement = ""; 
			//TODO write query statement with "?" to be filled in
			//delete the account with that account number

			preparedStatement = databaseConnector.cmpe202BankingConnection.prepareStatement(getQueryStatement);
			
			preparedStatement.setString(1,  accountNumber);
			
			preparedStatement.executeUpdate();
			
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 1;
		
	}
}
