//Josh Reichman
//Creates account holder and assigns different accounts
package project1;

public class Account {

	/////////////////////////////Variables\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/////////////////////////////|||||||||\\\\\\\\\\\\\\\\\\\\\\\\\\\
	// / / / / / / / / / / / Personal Information / / / / / / / / / /
	private String firName; //First Name
	private String lasName; //Last Name
	private String strAddress; //Street Address
	private String zipCode; //Zip Code
	
	// / / / / / / / / / / / / Accounts / / / / / / / / / / / / / / /
	private BankAccount savAccount; //Savings
	private BankAccount chkAccount; //Checking
	private BankAccount mrkAccount; //Money Market
	private CreditCardAccount crcAccount; //Credit Card
	
	// / / / / / / / / / / / / / Date / / / / / / / / / / / / / / / /
	private Date curDate; //Day, Month

	////////////////////////////Main Code\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////|||||||||\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	///////////////////////////Constructor\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public Account(String fn, String ln, Date dm) {
		firName = fn;
		lasName = ln;
		curDate = dm;
	}
	
	/////////////////////////Personal/Information\\\\\\\\\\\\\\\\\\\\
	// First Name
	public String getFirstName() {
		return firName;
	}

	public void setFirstName(String first) {
		firName = first;
	}

	// Last Name
	public String getLastName() {
		return lasName;
	}

	public void setLastName(String last) {
		lasName = last;
	}

	// Street Address
	public String getStreetAddress() {
		return strAddress;
	}

	public void setStreetAddress(String address) {
		strAddress = address;
	}

	// Zip Code
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zip) {
		zipCode = zip;
	}

	// Savings Account
	public BankAccount getSavingsAccount() {
		return savAccount;
	}

	public void setSavingsAccount(BankAccount savings) {
		savAccount = savings;
	}

	// Checking Account
	public BankAccount getCheckingAccount() {
		return chkAccount;
	}

	public void setCheckingAccount(BankAccount checking) {
		chkAccount = checking;
	}

	// Money Market Account
	public BankAccount getMoneyMarketAccount() {
		return mrkAccount;
	}

	public void setMoneyMarketAccount(BankAccount market) {
		mrkAccount = market;
	}

	// CreditCardAccount
	public CreditCardAccount getCreditCardAccount() {
		return crcAccount;
	}

	public void setCreditCardAccount(CreditCardAccount cc) {
		crcAccount = cc;
	}

	public Date getDate() {
		return curDate;
	}

	public void setDate(Date dm) {
		curDate = dm;
	}

}
