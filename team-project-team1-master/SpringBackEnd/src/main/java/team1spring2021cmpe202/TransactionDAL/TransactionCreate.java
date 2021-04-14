package team1spring2021cmpe202.TransactionDAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import team1spring2021cmpe202.MySQLConnector.MySQLConnector;

public class TransactionCreate {
	static PreparedStatement preparedStatement = null;
	
	public static int readAccountByUsername (String sourceAccountID, String targetAccountID, float transactionAmount, boolean recurring, int transactionPeriodInHours, MySQLConnector databaseConnector) {
		try {
			String createQueryStatement = ""; 
			//TODO write query statement with "?" to be filled in
			//create transaction with the given data

			preparedStatement = databaseConnector.cmpe202BankingConnection.prepareStatement(createQueryStatement);
			
			preparedStatement.setString(1,  sourceAccountID);
			preparedStatement.setString(2,  targetAccountID);
			preparedStatement.setFloat(3,  transactionAmount);
			preparedStatement.setBoolean(4,  recurring);
			preparedStatement.setInt(5,  transactionPeriodInHours);
			
			preparedStatement.executeUpdate();
			
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 1;
		
	}
}
