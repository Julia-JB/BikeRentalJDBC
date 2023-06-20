package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentalTransaction {
	private int transactionId;
	private LocalDateTime dateTime;
	private String type;
	private BigDecimal amount;
	private int userId;
	private int rentalId;

	public RentalTransaction(int transactionId, LocalDateTime dateTime, String type, BigDecimal amount, int userId, int rentalId) {
		this.transactionId = transactionId;
		this.dateTime = dateTime;
		this.type = type;
		this.amount = amount;
		this.userId = userId;
		this.rentalId = rentalId;
	}

	public RentalTransaction(LocalDateTime dateTime, String type, BigDecimal amount, int userId, int rentalId) {
		this.dateTime = dateTime;
		this.type = type;
		this.amount = amount;
		this.userId = userId;
		this.rentalId = rentalId;
	}

	@Override
	public String toString() {
		return "RentalTransaction{" + "transactionId=" + transactionId + ", dateTime=" + dateTime + ", type='" + type + '\'' + ", amount=" + amount + ", userId=" + userId + ", rentalId=" + rentalId + '}';
	}

	public RentalTransaction() {
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
}
