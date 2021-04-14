package team1spring2021cmpe202.SessionKeyManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import team1spring2021cmpe202.MySQLConnector.MySQLConnector;

public class SessionKeyRead {
	static PreparedStatement preparedStatement = null;
	
	public static ResultSet readSessionKeyByKeyValueAndUsername (String sessionKey, String userName, MySQLConnector databaseConnector) {
		try {
			String getQueryStatement = "SELECT SessionKeyID, TimeCreated, Owner FROM SessionKeys "
					+ "WHERE SessionKeys.SessionKeyID = BINARY ? "
					+ "AND SessionKeys.Owner = BINARY ?"; 
			//TODO write query statement with "?" to be filled in
			//Select accounts that correspond to the given username

			preparedStatement = databaseConnector.cmpe202BankingConnection.prepareStatement(getQueryStatement);
			
			preparedStatement.setString(1, sessionKey);
			preparedStatement.setString(2, userName);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static ResultSet readLatestSessionKeyByUsername (String userName, MySQLConnector databaseConnector) {
		try {
			String createQueryStatement = ""; 
			//TODO write query statement with "?" to be filled in
			//read most recent session key entry with the given value

			preparedStatement = databaseConnector.cmpe202BankingConnection.prepareStatement(createQueryStatement);
			
			preparedStatement.setString(1, userName);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
