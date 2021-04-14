package team1spring2021cmpe202.AccountDAL;

import java.sql.PreparedStatement;
import team1spring2021cmpe202.MySQLConnector.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountCreate {
	static PreparedStatement preparedStatement = null;
	
	public static ResultSet createAccount (String userName, String accountType, float accountBalance, MySQLConnector databaseConnector) {
		try {
			String createQueryStatement = "";
			//TODO write query statement with "?" to be filled in
			//userName should be used to set the UserID FK

			preparedStatement = databaseConnector.cmpe202BankingConnection.prepareStatement(createQueryStatement);
			
			preparedStatement.setString(1,  userName);
			preparedStatement.setString(2,  accountType);
			preparedStatement.setFloat(3,  accountBalance);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}