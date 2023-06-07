package utilities;

public enum Keys {
	API_KEY("ywQeXV3Nyn7ZLhG5W+HB7Q==CNIRH8eHzKxkNsdV"),
	SQL_URL("jdbc:mysql://localhost:3306/bikeRental"),
	SQL_USERNAME("root"),
	SQL_PASSWORD("newdaytoday");

	private final String key;

	Keys(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}

