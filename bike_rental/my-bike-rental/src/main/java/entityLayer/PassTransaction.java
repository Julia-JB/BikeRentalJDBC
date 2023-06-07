package entityLayer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PassTransaction {

	private int transactionId;
	private LocalDateTime dateTime;
	private String type;
	private BigDecimal amount;
	private int userId;
	private int passId;

	public PassTransaction(LocalDateTime dateTime, String type, BigDecimal amount,
	                       int userId, int passId) {
		this.dateTime = dateTime;
		this.type = type;
		this.amount = amount;
		this.userId = userId;
		this.passId = passId;
	}

	public PassTransaction(int transactionId, LocalDateTime dateTime, String type,
	                       BigDecimal amount, int userId, int passId) {
		this.transactionId = transactionId;
		this.dateTime = dateTime;
		this.type = type;
		this.amount = amount;
		this.userId = userId;
		this.passId = passId;
	}

	public PassTransaction() {

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

	public int getPassId() {
		return passId;
	}

	public void setPass_id(int pass_id) {
		this.passId = passId;
	}
}
