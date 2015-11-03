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

	public static void main(String[] args)
	{ 
		RealNumber test = new RealNumber(4, false, new byte[]{1,8,9,9,8,7});
		RealNumber test2 = new RealNumber(4, false, new byte[]{1,2,1,9,9,8,8});
		System.out.println(RealNumber.add(test, test2));
	}
	/**
	 * @param precision
	 * @param isNegative
	 * @param data
	 */
	public RealNumber(int precision, boolean isNegative, byte[] data) {
		this.precision = precision;
		this.isNegative = isNegative;
		if (precision > data.length) {
			this.data = new byte[precision];
			for(int i = 0; i < data.length; i++){
				this.data[i] = data[i];
			}
			for (int i = data.length; i < this.data.length; i++) {
				this.data[i] = 0;
			}
		}
		else
			this.data = data;
	}

	public RealNumber(int precision, String value) {

	}

	/**
	 * @return Precision
	 */
	public int getPrecision() {
		return this.precision;
	}

	/**
	 * @return isNegative
	 */
	public boolean isNegative() {
		return this.isNegative;
	}

	/**
	 * @return data
	 */
	public byte[] getData() {
		return this.data;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		if(this.isNegative())
			sb.append("-");
		if (this.getPrecision() == 0) {
			for (int i = this.getData().length - 1; i >= 0; i--) {
				sb.append(this.getData()[i]);
			}
		}
		else if(this.getPrecision() > this.getData().length - 1){ 
			sb.append(".");
			for(int i = this.getPrecision()-1; i >= 0; i--){
				if(i > this.getData().length-1){
					sb.append("0");
				}
				else {
					sb.append(this.getData()[i]);
				}
			}

		}
		else if(this.getPrecision() < this.getData().length - 1){ //overflow data goes past decimal point
			boolean leadingZero = true;
			int currentZero = 0;
			for(int i = this.getData().length - 1;i >= 0; i--){
				if(leadingZero){
					if(leadingZero && ((this.getData()[i] != 0)||(this.getPrecision()==i))){
						leadingZero = false;
						if(this.getPrecision()-1==i){
							sb.append(".");
						}
						i+= currentZero -1;
						if(this.getData()[i]-1==0){
							sb.append(".");
						}
					}
					else{
						currentZero++;
					}
				}
				else{
					if(this.getPrecision() == i){
						sb.append(this.getData()[i]+".");
					}
					else if(this.getPrecision() != i){
						sb.append(this.getData()[i]);
					}

				}
			}
		}
		else{
			sb.append(".");
			for (int i = this.getData().length - 2; i >= 0; i--) {
				sb.append(this.getData()[i]);
			}
		}

		return sb.toString();
	}
	/*
 public static int compare(RealNumber value1, RealNumber value2) {

 }

 public int compareTo(RealNumber value) {

 }
	 */
	@Override
	public boolean equals(Object o) throws ClassCastException{
		if (!(o instanceof RealNumber)){
			throw new ClassCastException();
		}
		return this.toString().equals(o.toString());

	}

	public static RealNumber add(RealNumber value1, RealNumber value2) {
		int precision;
		boolean isNegative = false;
		byte[] addData;
		boolean greaterRealnumber; //true = value1. false = value2
		if (value1.getPrecision() >=value2.getPrecision()){
			precision = value1.getPrecision();
		}
		else{
			precision = value2.getPrecision();
		}
		if(value1.getData().length-value1.getPrecision() >= value2.getData().length-value2.getPrecision()){
			addData = new byte[value1.getData().length-value1.getPrecision() + precision+1];
			greaterRealnumber = true;
		}
		else{
			addData = new byte[value2.getData().length-value2.getPrecision() + precision+1];
			greaterRealnumber = false;
		}
		System.out.println(addData.length);
		if(greaterRealnumber){//value1 is bigger
			for(int i1 = addData.length - 2,i2 = i1 - (i1 - value2.getData().length-1); i1 >= 0; i1--,i2--){	  

				if(i2>=0){
					if((byte) (value1.getData()[i1]+ value2.getData()[i2])>9){
						addData[i1+1]++;
						addData[i1] = (byte) (value1.getData()[i1]+ value2.getData()[i2]-10);
					} 
					else{
						addData[i1] = (byte) (value1.getData()[i1]+ value2.getData()[i2]);
					}
				}
				else{
					addData[i1] = (byte) (value1.getData()[i1]);
				}
			}
		}
		else{//value2 is bigger
			for(int i2 = addData.length - 2,i1 = i2 - (i2 - value1.getData().length-1); i2 >= 0; i1--,i2--){	  

				if(i2>=0){
					//if((byte) (value1.getData()[i1]+ value2.getData()[i2])>9){
					//	addData[i2+1]++;
					//	addData[i2] = (byte) (value1.getData()[i1]+ value2.getData()[i2]-10);
					//} 
					//else{
						addData[i2] = (byte) (value1.getData()[i1]+ value2.getData()[i2]);
					//}
				}
				else{
					addData[i2] = (byte) (value2.getData()[i2]);
				}
			}
		}
		return new RealNumber(precision,isNegative,new byte[]{1,1});
	}

	/*
 public static RealNumber subtract(RealNumber value1, RealNumber value2) {

 }

 public static RealNumber multiply(RealNumber value1, RealNumber value2) {

 }

 public static RealNumber divide(RealNumber value1, RealNumber value2) {

 }

 public static RealNumber squareRoot(RealNumber value) {

 }
	 */
}