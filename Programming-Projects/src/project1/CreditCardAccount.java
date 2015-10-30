//Josh Reichman
//Lets you create and modify credit card accounts

package project1;

public class CreditCardAccount {
	private double curBalance;
	private double tolPaid;
	private int crdLimit;
	private double intRate;
	private int minMonthlyPayment;
	private int latePayPenalty;
	private double intCharged;
	private boolean pifFlag;

	public CreditCardAccount() {
		curBalance = 0;
		tolPaid = 0;
		crdLimit = 0;
		intRate = 0;
		minMonthlyPayment = 0;
		latePayPenalty = 0;
		intCharged = 0;
		pifFlag = true;
	}

	public CreditCardAccount(int limit, double rate, int min, int latePen) {
		curBalance = 0;
		tolPaid = 0;
		crdLimit = limit;
		intRate = rate;
		minMonthlyPayment = min;
		latePayPenalty = latePen;
		intCharged = 0;
		pifFlag = true;
	}

	public int getCreditLimit() {
		return crdLimit;
	}

	public void setCreditLimit(int limit) {
		crdLimit = limit;
	}

	public double getInterestRate() {
		return intRate;
	}

	public void setInterestRate(double rate) {
		intRate = rate;
	}

	public int getMinMonthlyPayment() {
		return minMonthlyPayment;
	}

	public void setMinMonthlyPayment(int min) {
		minMonthlyPayment = min;
	}

	public int getLatePaymentPenalty() {
		return latePayPenalty;
	}

	public void setLatePaymentPenalty(int penalty) {
		latePayPenalty = penalty;
	}

	public boolean charge(double amount) {
		if (curBalance + amount <= crdLimit) {
			curBalance += amount;
			return true;
		} else
			return false;
	}

	public void payment(double amount) {
		curBalance -= amount;
		tolPaid += amount;
	}

	public void incrementDay() {
		if (pifFlag == false) {
			intCharged += (curBalance + intCharged) * (intRate / 365);
		}
	}

	public void incrementMonth() {
		curBalance += intCharged;
		intCharged = 0;
		if (tolPaid >= minMonthlyPayment)
			pifFlag = true;
		else
			pifFlag = false;
	}

}
