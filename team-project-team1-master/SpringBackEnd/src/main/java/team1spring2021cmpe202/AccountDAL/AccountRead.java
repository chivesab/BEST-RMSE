package team1spring2021cmpe202.AccountDAL;

import java.sql.PreparedStatement;
import team1spring2021cmpe202.MySQLConnector.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRead {
	static PreparedStatement preparedStatement = null;
	
	public static ResultSet readAccountByUsername (String userName, MySQLConnector databaseConnector) {
		try {
			String getQueryStatement = ""; 
			//TODO write query statement with "?" to be filled in
			//Select accounts that correspond to the given username

			preparedStatement = databaseConnector.cmpe202BankingConnection.prepareStatement(getQueryStatement);
			
			preparedStatement.setString(1,  userName);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}