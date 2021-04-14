package team1spring2021cmpe202.AccountDAL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import team1spring2021cmpe202.MySQLConnector.MySQLConnector;

public class AccountUpdate {
	static PreparedStatement preparedStatement = null;
	
	public static int updateAccountBalance (String accountNumber, float accountBalance, MySQLConnector databaseConnector) {
		try {
			String updateQueryStatement = ""; 
			//TODO write query statement with "?" to be filled in
			//update the account with the new accountBalance

			preparedStatement = databaseConnector.cmpe202BankingConnection.prepareStatement(updateQueryStatement);
			
			preparedStatement.setString(1,  accountNumber);
			preparedStatement.setFloat(1,  accountBalance);
			
			preparedStatement.executeUpdate();
			
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 1;
		
	}
}
