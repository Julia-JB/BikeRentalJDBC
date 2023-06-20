package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Pass {

	int passId;
	String type;
	BigDecimal price;
	Date validFrom;
	Date validTo;
	int userId;

	public Pass() {
	}
	public Pass(int passId, String type, BigDecimal price, Date validFrom, Date validTo,
	            int userId) {
		this.passId = passId;
		this.type = type;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.userId = userId;
	}

	public Pass(String type, BigDecimal price, Date validFrom, Date validTo, int userId) {
		this.type = type;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Pass{" + "passId=" + passId + ", type='" + type + '\'' + ", price=" + price + ", validFrom=" + validFrom + ", validTo=" + validTo + ", userId=" + userId + '}';
	}

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = userId;
	}
}
