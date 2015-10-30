//Josh Reichman
//Lets you create and modify bank accounts
package project1;

public class BankAccount {

	/////////////////////////////Variables\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/////////////////////////////|||||||||\\\\\\\\\\\\\\\\\\\\\\\\\\\
	// / / / / / / / / / / / / Current Values / / / / / / / / / / / /
	private double curBalance;			// Current Balance
	private int curWithdrawNumber; 		// Current Monthly Withdraw Number
	private double curEarnedInterest; 	// Current Monthly Interest Amount Earned
	
	// / / / / / / / / / / / / / / Flags  / / / / / / / / / / / / / / 
	private boolean ovrFlag; 			// Overdraft Flag
	
	// / / / / / / / / / / / / / Constants  / / / / / / / / / / / / /
	private double intRate; 			// Interest Rate
	
	// / / / / / / / / / / / / / / Fees / / / / / / / / / / / / / / /
	private double atmFee; 				// ATM Fee
	private double ovrFee; 				// Overdraft Fee
	private double bocFee; 				// Bounced Check Fee
	private double wtdFee; 				// Withdraw Fee
	
	// / / / / / / / / / / / / / Limits / / / / / / / / / / / / / / /
	private int wtdLimit; 				// Withdraw Limit
	private int minBalance; 			// Minimum Balance
	
	//|||||||||||||||||||||||||||||End|||||||||||||||||||||||||||||\\
	
	
	////////////////////////////Main Code\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	////////////////////////////|||||||||\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	///////////////////////////Constructors\\\\\\\\\\\\\\\\\\\\\\\\\\
	// Default Constructor
	public BankAccount() {
		curBalance = 0;
		curWithdrawNumber = 0;
		curEarnedInterest = 0;
		ovrFlag = false;
		intRate = 0;
		atmFee = 0;
		ovrFee = 0;
		bocFee = 0;
		wtdFee = 0;
		wtdLimit = 0;
		minBalance = 0;
	}

	// Preset Constructor
	public BankAccount(double intRateSet, int minBalanceSet, double ovrFeeSet, double atmFeeSet, double bocFeeSet) {
		curBalance = 0;
		curWithdrawNumber = 0;
		curEarnedInterest = 0;
		ovrFlag = false;
		intRate = intRateSet;
		atmFee = atmFeeSet;
		ovrFee = ovrFeeSet;
		bocFee = bocFeeSet;
		wtdFee = 0;
		wtdLimit = 0;
		minBalance = minBalanceSet;
	}
	
	///////////////////////////Current Values\\\\\\\\\\\\\\\\\\\\\\\\
	// Balance Command
	public double getBalance() {
		return curBalance;
	}

	/////////////////////////////Constants\\\\\\\\\\\\\\\\\\\\\\\\\\\
	// Interest Rate 
	public double getInterestRate() {
		return intRate;
	}
	public void setInterestRate(double rate) {
		intRate = rate;
	}
	
	///////////////////////////////Fees\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	// ATM Fee
	public double getATMFee() {
		return atmFee;
	}
	public void setATMFee(double fee) {
		atmFee = fee;
	}

	// Overdraft Fee
	public double getOverDraftFee() {
		return ovrFee;
	}
	public void setOverDraftFee(double fee) {
		ovrFee = fee;
	}

	// Bounced Check Fee
	public double getBouncedCheckFee() {
		return bocFee;
	}
	public void setBouncedCheckFee(double fee) {
		bocFee = fee;
	}

	// Withdraw Fee
	public double getWithdrawFee() {
		return wtdFee;
	}
	public void setWithdrawFee(double fee) {
		wtdFee = fee;
	}

	///////////////////////////Limits\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	// Minimum Balance
	public int getMinimumBalance() {
			return minBalance;
		}
	public void setMinimumBalance(int min) {
			minBalance = min;
		}

	// Withdraw Limit
	public int getWithdrawLimit() {
		return wtdLimit;
	}
	public void setWithdrawLimit(int limit) {
		wtdLimit = limit;
	}

	////////////////////Deposit and Withdraw\\\\\\\\\\\\\\\\\\\\\\\\\
	// Deposit
	public void deposit(double amount) {
		curBalance += amount;
	}
	// Withdraw General
	public boolean withdraw(double amount) {
		if (curBalance >= amount) {
			if ((wtdLimit == 0) || (curWithdrawNumber <= wtdLimit))
				curBalance -= amount;
			else
				curBalance -= (amount + wtdFee);

			if (wtdLimit != 0)
				curWithdrawNumber++;
			return true;
		} else
			return false;
	}
	// Withdraw from Check
	public boolean withdrawDraft(double amount) {
		if (curBalance >= amount) {
			if ((wtdLimit == 0) || (curWithdrawNumber <= wtdLimit))
				curBalance -= amount;
			else
				curBalance -= (amount + wtdFee);
			if (wtdLimit != 0)
				curWithdrawNumber++;
			return true;
		} else {
			curBalance -= bocFee;
			return false;
		}

	}
	// Withdraw from ATM
	public boolean withdrawATM(double amount) {
		if (this.withdraw(amount + atmFee)) {
			curBalance -= atmFee;
			return true;
		} else
			return false;
	}

	/////////////////////Date Incrementing\\\\\\\\\\\\\\\\\\\\\\\\\\\
	// +1 Day
	public void incrementDay() {
		if (curBalance < minBalance) {
			if (!ovrFlag) {
				curBalance -= ovrFee;
				ovrFlag = true;
			}
		} else {
			curEarnedInterest += (curBalance + curEarnedInterest) * (intRate / 365);
		}
	}
	// +1 Month
	public void incrementMonth() {
		curBalance += curEarnedInterest;
		curEarnedInterest = 0;
		ovrFlag = false;
	}

}
