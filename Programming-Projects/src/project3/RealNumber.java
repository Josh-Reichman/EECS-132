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
  RealNumber test = new RealNumber(1, false, new byte[]{1,2,5,8});
  RealNumber test2 = new RealNumber(2, false, new byte[]{1,2,1});
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
  if (value1.getPrecision() >=value2.getPrecision()){
   precision = value1.getPrecision();
  }
  else{
   precision = value2.getPrecision();
  }
  if(value1.getData().length-value1.getPrecision() >= value2.getData().length-value2.getPrecision()){
   addData = new byte[value1.getData().length-value1.getPrecision() + precision+1];
  }
  else{
   addData = new byte[value2.getData().length-value2.getPrecision() + precision+1];
  }
  System.out.println(addData.length);
  for(int i = addData.length - 2,v1 =value1.getData().length-1,v2 = value2.getData().length-1; i >= 0; i--,v1--,v2--){
   addData[i]= value1.getData()[v1]+ value2.getData()[v2];
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