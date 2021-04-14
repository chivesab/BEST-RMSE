package team1spring2021cmpe202.SpringBackEnd;

import java.time.LocalDateTime;

public class Transaction {
	private String originAccountID;
	private String targetAccountID;
	private float transactionAmount;
	private LocalDateTime initialTransactionDate;
	private boolean recurring;
	private int transactionPeriodInHours;
	
	public boolean isRecurring() {
		return recurring;
	}
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}
	public String getTargetAccountID() {
		return targetAccountID;
	}
	public void setTargetAccountID(String targetAccountID) {
		this.targetAccountID = targetAccountID;
	}
	public float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public int getTransactionPeriodInDays() {
		return transactionPeriodInHours;
	}
	public void setTransactionPeriodInDays(int transactionPeriodInDays) {
		this.transactionPeriodInHours = transactionPeriodInDays;
	}
	public LocalDateTime getInitialTransactionDate() {
		return initialTransactionDate;
	}
	public void setInitialTransactionDate(LocalDateTime initialTransactionDate) {
		this.initialTransactionDate = initialTransactionDate;
	}
	public String getOriginAccountID() {
		return originAccountID;
	}
	public void setOriginAccountID(String originAccountID) {
		this.originAccountID = originAccountID;
	}

	
}
