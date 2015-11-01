///**
*
@author
Lucas Alva-Ganoza this class gives
more precise
decimal numbers than*
double and
long types*/

public class RealNumber {

	/**
	 * int field that represents the number of digits to the right of the
	 * decimal point
	 */
	private int precision;

	/** boolean field that tells if the number is negative */
	private boolean isNegative;

	/** stores every digit of the real number */
	private byte[] data;

	/**
	 * Constructor that initializes an instance of RealNumber
	 * 
	 * @param precision
	 *            is the precision
	 * @param isNegative
	 *            indicates whether the number is negative or not
	 * @param data
	 *            takes the number that will be turned into an array when
	 *            the precision is larger than the number of entries a new
	 *            array must be created that fills the array with zeroes to
	 *            complete precision
	 */
	public RealNumber(int precision, boolean isNegative, byte[] data) {
		this.precision = precision;
		this.isNegative = isNegative;
		if (precision > data.length) {
			this.data = new byte[precision];
			for (int i = 0; i < data.length; i++) {
				this.data[i] = data[i];
			}

			/** adds zero to compensate for precision */
			for (int i = data.length; i < this.data.length; i++) {
				this.data[i] = 0;
			}
		}

		else
			this.data = data;
	}

	/**
	 * Constructor that initializes an instance of real number
	 * 
	 * @param precision
	 *            is the precision
	 * @param value
	 *            is the actual number value is rounded or filled with
	 *            additional zeroes to fit with the precision
	 */
	public RealNumber(int precision, String value) {

		/**
		 * keeps track of how many digits before decimal point for ading zeroes
		 */
		int num = 0;

		/** keeps track of the number of digits before the decimal */
		int numD = 0;
		this.precision = precision;
		if (value.charAt(0) == '-') {
			isNegative = true;
		}
		/**
		 * checks the string for how many digits until a decimal point. This
		 * will be added to precision for arraylength
		 */
		for (int i = 0; value.charAt(i) != '.'; i++) {
			numD++;
		}
		/** how many digits until stop adding zeroes */
		for (int i = 0; i < this.getPrecision() - value.length() + numD; i++) {
			num++;
		}

		/** case in which the precision is zero */
		if (this.getPrecision() == 0) {

		}

		/** case in which precision equals number of digits after decimal */
		if (value.length() - numD - 1 > this.getPrecision()) {
			if (value.charAt(0) == '9' && value.charAt(2) == '9') {
				this.data = new byte[this.getPrecision() + numD + 2];
			}
			this.data = new byte[this.getPrecision() + numD + 2]; // ADDED ONE
			int i = this.getData().length;
			int j = 0;
			while (i >= 0 && j <= this.getData().length) { // MAKE SURE THE
				// ARRAY DOES NOT
				// RUN OUT OF INDEX
				// OR WHATEVER
				/** case in which rounding up is needed */
				if (value.charAt(i + 1) >= '5' && i == this.getData().length) {
					data[j] = (byte) (((byte) value.charAt(i)) - 47);
					i--;
					j++;
					System.out.println("ADA");
				}

				* if ( value.charAt(i) == '9' && value.charAt(i + 1) >= '5' ) {
					* data[j] = 0; i--; j++; System.out.println("I got here"); }


				if (value.charAt(i) == '.') {
					i--;
					System.out.println("qwer");
				} else {
					data[j] = (byte) ((byte) (value.charAt(i)) - 48);
					i--;
					j++;
					System.out.println("tyuio");
				}
			}
			// for ( int x = 0; x >=
		}
		/** fix the error with the nine rounding by */
		for (int q = 0; data[q] >= 10; q++) {
			if (data[q] >= 5 && data[q] < 10) {
				data[q + 1] = (byte) (data[q + 1] + 1);
			}
			if (data[q] >= 10) {
				data[q] = 0;
				data[q + 1] = (byte) (data[q + 1] + 1);
				System.out.println("Not");
			} else
				;
			System.out.println("ABC");
		}

		/** case in which zeroes are needed to add more precision */
		if (value.length() - numD - 1 < this.getPrecision()) {

			/** */
			this.data = new byte[this.getPrecision() + numD];
			int i = value.length() - 1;
			int j = 0;
			while (num >= 0) {
				data[j] = 0;
				j++;
				num--;
			}
			while (i >= 0) {
				if (value.charAt(i) == '.') {
					i--;
				} else {
					data[j] = (byte) ((byte) (value.charAt(i)) - 48);
					i--;
					j++;
				}
			}
		}
	}

	/**
	 * retreives the value of the precision of the RealNumber
	 * 
	 * @return precision
	 */
	public int getPrecision() {

		return precision;
	}

	/**
	 * retreives the data array of the RealNumber
	 * 
	 * @return precison
	 */
	public byte[] getData() {

		return data;
	}

	/**
	 * this method returns true if the RealNumber is negative, and false if
	 * it is not negative
	 * 
	 * @return true or false
	 */
	public boolean isNegative() {

		/** if the RealNumber is negative */
		if (isNegative) {

			/** returns true if the condition above is met */
			return true;
		}

		/**
		 * if the real number is not negative, then the method returns false
		 */
		else
			return false;
	}

	/**
	 * overrides the toString() method from object and returns the data
	 * array as a String
	 */
	@Override
	public String toString() {

		/** keeps track of the number of digits before the decimal point */
		int track = 0;

		/**
		 * Initialies the StringBuilder needed to build the return String
		 */
		StringBuilder rep = new StringBuilder();

		/** appends a negative sign if the number is negative */
		if (this.isNegative()) {
			rep.append('-');
		}

		/** case in which precision is zero */
		if (this.getPrecision() == 0) {

			/** runs thorugh the array to copy to the StringBuilder */
			for (int i = this.getData().length - 1; i > 0; i--) {
				rep.append(this.getData()[i]);
			}
		}

		/**
		 * case in which precision is greater than the data array length and
		 * zeroes are needed to add more precision
		 */
		if (this.getPrecision() > this.getData().length) {

			/**
			 * appends zeroes to the StringBuilder until it reached the
			 * point at which actual numbers are appended
			 */
			for (int i = this.getPrecision(); i > this.getPrecision() - this.getData().length; i--) {
				rep.append('0');
			}

			/**
			 * appends the data to StringBuilder at data[i] as long as i is
			 * greater than or equal to zero
			 */
			for (int i = this.getData().length; i >= 0; i--) {
				rep.append(this.getData()[i]);
			}
		}

		/** the precision is less than the data array length */
		if (this.getPrecision() < this.getData().length && this.getPrecision() != 0) {

			/**
			 * runs through the array backwards as long i is greater than
			 * zero and i is greater than or equal to the precision
			 */
			for (int i = this.getData().length - 1; i > 0 && i >= this.getPrecision(); i--) {

				/**
				 * if the number at the end of the array is not 0, then any
				 * zeroes after it are needed
				 */
				if (this.getData()[i] == 0 && this.getData()[this.getData().length - 1] != 0) {
					rep.append(this.getData()[i]);
					track = i;
				}

				/**
				 * appends the data at i to StringBuilder as long as it is
				 * not zero and sets track to be equal to i
				 */
				if (this.getData()[i] != 0) {
					rep.append(getData()[i]);
					track = i;
				}

				/**
				 * if the number at the end of the data array is not zero,
				 * AKA leading zeroes are present, track is set equual to i
				 */
				if (this.getData()[i] == 0 && this.getData()[this.getData().length - 1] == 0) {
					track = i;
				}
			}

			/**
			 * appends the decimal point to StringBuilder after the numbers
			 * before it have been appended
			 */
			rep.append('.');

			/**
			 * appends the rest of the numbers i data to the rigth of the
			 * decimal point in StringBuilder as long as i is greater than
			 * or euqal to 0 or the end of the data array
			 */
			for (int i = track - 1; i >= 0; i--) {
				rep.append(this.getData()[i]);
			}

		}

		/**
		 * otherwise, appends the decimal point to StringBuilder and the
		 * rest of the data array
		 */
		// REMEMBER TO TAKE OUT THIS
		// COMMENT#######################################################

		/**
		 * uses the substring method to copy the StringBuilder to a String
		 * that will be returned
		 */
		String repString = rep.substring(0, rep.length());
		return repString;
	}

	public static int compare(RealNumber value1, RealNumber value2) {

		int v1 = value1.getData().length;
		int v2 = value2.getData().length;
		int result = 0;
		boolean noLZeroes1 = false;
		boolean noLZeroes2 = false;
		int v1NumD = 0;
		int v2NumD = 0;
		while (!noLZeroes1 || !noLZeroes2) {
			if (!noLZeroes1) {
				v1--;
			}

			if (!noLZeroes2) {
				v2--;
			}

			if (value1.getData()[v1] != 0) {
				noLZeroes1 = true;
			}

			if (value2.getData()[v2] != 0) {
				noLZeroes2 = true;
			}

		}

		while (v1NumD < value1.getData().length - value1.getPrecision()
				|| v2NumD < value2.getData().length - value2.getPrecision()) {
			System.out.println("oooo");
			System.out.println(value1.getData().length - value1.getPrecision());
			System.out.println(value2.getData().length - value2.getPrecision());
			if (v1NumD == value1.getData().length - value1.getPrecision()
					&& v2NumD < value2.getData().length - value2.getPrecision()) {
				v2NumD++;
				System.out.println("wetbycg");
			}
			if (v1NumD < value1.getData().length - value1.getPrecision()
					&& v2NumD == value2.getData().length - value2.getPrecision()) {
				v1NumD++;
				System.out.println("o124oo");
				;
			}
			if (v1NumD != value1.getData().length - value1.getPrecision()
					&& v2NumD != value2.getData().length - value2.getPrecision()) {
				v1NumD++;
				v2NumD++;
				System.out.println(v1NumD);
				System.out.println(v2NumD);
			}
		}

		if (value1.isNegative() == false && value2.isNegative() == true) {
			result = 1;
		}

		if (value1.isNegative() == true && value2.isNegative() == false) {
			result = -1;
		}

		if (v1NumD > v2NumD && value1.isNegative() == false && value2.isNegative() == false) {
			result = 1;
		}

		if (v1NumD < v2NumD && value1.isNegative() == false && value2.isNegative() == false) {
			result = -1;
		}

		if (v1NumD > v2NumD && value1.isNegative() == true && value2.isNegative() == true) {
			result = -1;
		}

		if (v1NumD < v2NumD && value1.isNegative() == true && value2.isNegative() == true) {
			result = 1;
		}

		if (v1NumD == v2NumD && value1.isNegative() == false && value2.isNegative() == false) {

			int checkNumD1 = v1NumD + value1.getPrecision() - 1;

			int checkNumD2 = v2NumD + value2.getPrecision() - 1;

			while (checkNumD1 >= 0 && checkNumD2 >= 0 && result == 0) {

				if (value1.getData()[checkNumD1] > value2.getData()[checkNumD2]) {
					result = 1;
				}

				if (value1.getData()[checkNumD1] < value2.getData()[checkNumD2]) {
					result = -1;
				}

				else {
					checkNumD1--;
					checkNumD2--;
				}
			}
		}

		if (v1NumD == v2NumD && value1.isNegative() == true && value2.isNegative() == true) {

			while (checkNumD1 >= 0 && checkNumD2 >= 0 && result == 0) {

				if (value1.getData()[checkNumD1] < value2.getData()[checkNumD2]) {
					result = 1;
				}

				if (value1.getData()[checkNumD1] > value2.getData()[checkNumD2]) {
					result = -1;
				}

				else {
					checkNumD1--;
					checkNumD2--;
				}
			}
		}
		return result;
	}
}
/**
 * compares two values of class RealNumber
 * 
 * @param value1
 *            is a RealNumber
 * @param value2
 *            is a RealNumber
 * @return returns zero value if the two values are equal, if value1 >
 *         value2, then it returns a positive value, if value1 < value2,
 *         then it returns a negative value.
 */
// public static int compare( RealNumber value1, RealNumber value2 ) {
// int v1 = 0;
// int v2 = 0;
// for ( int
// }

// public
}
