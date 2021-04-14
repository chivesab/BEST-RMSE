package team1spring2021cmpe202.TransactionDAL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import team1spring2021cmpe202.MySQLConnector.MySQLConnector;

public class TransactionRead {
	static PreparedStatement preparedStatement = null;
	
	public static ResultSet readTransactionByAccountNumber (String accountNumber, MySQLConnector databaseConnector) {
		try {
			String readQueryStatement = ""; 
			//TODO write query statement with "?" to be filled in
			//return all transactions involving the given account (receiver/sender)

			preparedStatement = databaseConnector.cmpe202BankingConnection.prepareStatement(readQueryStatement);
			
			preparedStatement.setString(1,  accountNumber);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
