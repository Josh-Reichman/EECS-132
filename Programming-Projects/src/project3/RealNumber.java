/**
 * 
 */
package project3;

/**
 * @author Josh Reichman
 *
 */
public class RealNumber {
	private int precision;
	private boolean isNegative;
	private byte[] data;

	public RealNumber(int precision, boolean isNegative, byte[] data) {
		if (precision <= data.length) {

		}
	}

	public RealNumber(int precision, String value) {

	}

	/**
	 * @return Precision
	 */
	public int getPrecision() {
		return precision;
	}

	/**
	 * @return isNegative
	 */
	public boolean isNegative() {
		return isNegative;
	}

	/**
	 * @return data
	 */
	public byte[] getData() {
		return data;
	}

	@Override
	public String toString() {

	}

	public static int compare(RealNumber value1, RealNumber value2) {
		
	}

	public int compareTo(RealNumber value) {

	}

	@Override
	public boolean equals(Object o) {

	}

	public static RealNumber add(RealNumber value1, RealNumber value2) {

	}

	public static RealNumber subtract(RealNumber value1, RealNumber value2) {

	}

	public static RealNumber multiply(RealNumber value1, RealNumber value2) {

	}

	public static RealNumber divide(RealNumber value1, RealNumber value2) {

	}

	public static RealNumber squareRoot(RealNumber value) {

	}
}