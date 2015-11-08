/**
 * 
 */
package project3;

/**
 * @author Josh Reichman
 */
public class RealNumber {
 /**
  * an integer that indicates the number of digits to the right of the decimal point
  */
 private int precision;
 /**
  * a boolean that determines whether the is data negative or positive
  */
 private boolean isNegative;
 /**
  * an array that stores all the digits of RealNumber
  */
 private byte[] data;
 /*
 public static void main(String[] args)
 { 
  RealNumber test = new RealNumber(4, false, new byte[]{1,8,9,9,8,7});
  RealNumber test2 = new RealNumber(4, false, new byte[]{1,2,1,9,9,8,8});
  System.out.println(RealNumber.add(test, test2));
 }
  */
 /**
  * Primary constructor using an array as input data
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

 /**
  * Secondary constructor using a String as input data
  * @param precision
  * @param value
  * @see {@literal} this constructor is currently non functional
  */
 public RealNumber(int precision, String value) {

 }

 /**
  * Returns the number of digits to the right of RealNumber's decimal point
  * @return precision of the RealNumber
  */
 public int getPrecision() {
  return this.precision;
 }

 /**
  * Returns a boolean value dependent on the RealNumber's isNegative value
  * @return isNegative
  */
 public boolean isNegative() {
  return this.isNegative;
 }

 /**
  * Returns the values within RealNumber
  * @return data 
  * @see {@literal} Only accessible within methods 
  */
 private byte[] getData() {
  return this.data;
 }

 /**
  * Returns string value of RealNumber
  * @return sb.toString
  * @see {@literal} This method is currently not correct in certain cases
  */
 @Override
 public String toString() {
  StringBuilder sb = new StringBuilder(); //StringBuilder used for creating output string
  if(this.isNegative())
   sb.append("-");
  if (this.getPrecision() == 0) {
   //Loops through all data without having a decimal
   for (int i = this.getData().length - 1; i >= 0; i--) {
    sb.append(this.getData()[i]);
   }
  }
  else if(this.getPrecision() > this.getData().length - 1){ 
   sb.append(".");
   //Loops through all data placing zeros where there is less data than the number of precision values needed
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
   boolean leadingZero = true; //Checks if there's a zero at the beginning of data[]
   int currentZero = 0; //Counts number of zero's until the first positive number is read
   //Loops through all data excluding beginning zeros in the output
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
  else{ //if Precision == this.getData().length
   sb.append(".");
   //Loops through all data placing a decimal in front
   for (int i = this.getData().length - 2; i >= 0; i--) {
    sb.append(this.getData()[i]);
   }
  }

  return sb.toString();
 }

 /**
  * Returns a positive value if value1 > value2, negative value if value1 < value2, or 0 if value1 = value2
  * @param value1
  * @param value2
  * @return integer
  * @see {@literal} This method is currently non functional
  */
 public static int compare(RealNumber value1, RealNumber value2) {

 }

 /**
  * Returns a positive value if the RealNumber > value, negative value if the RealNumber < value, or 0 if the RealNumber = value
  * @param value
  * @return integer
  * @see {@literal} This method is currently non functional
  */
 public int compareTo(RealNumber value) {

 }

 /** 
  * Checks if a RealNumber is equivalent to another RealNumber
  * @param o
  * @return boolean
  * @throws ClassCastException
  */
 @Override
 public boolean equals(Object o) throws ClassCastException{
  if (!(o instanceof RealNumber)){
   throw new ClassCastException();
  }
  return this.toString().equals(o.toString());

 }

 /**
  * Adds two RealNumber objects together
  * @param value1
  * @param value2
  * @return {@literal} RealNumber
  * @see {@literal} This method is currently not fully functional
  * @see {@literal} It can only get the correct length of addData
  */
 public static RealNumber add(RealNumber value1, RealNumber value2) {
  int precision; // new RealNumber array precision
  boolean isNegative = false;// new RealNumber isNegative value (currently just false)
  byte[] addData; // new RealNumber data array
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
  if(greaterRealnumber){
   //Loops through data taking in the fact the value1 >= value2
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
  else{
   //Loops through data taking in the fact the value1 < value2
   for(int i2 = addData.length - 2,i1 = i2 - (i2 - value1.getData().length-1); i2 >= 0; i1--,i2--){   

    if(i2>=0){
     //if((byte) (value1.getData()[i1]+ value2.getData()[i2])>9){
     // addData[i2+1]++;
     // addData[i2] = (byte) (value1.getData()[i1]+ value2.getData()[i2]-10);
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
  //  return new RealNumber(precision,isNegative,addData[]);
 }


 /**
  * Subtracts two RealNumber objects together
  * @param value1
  * @param value2
  * @return RealNumber 
  * @see {@literal} this method is currently non functional
  */
 public static RealNumber subtract(RealNumber value1, RealNumber value2) {

 }

 /**
  * Multiplies two RealNumber objects together
  * @param value1
  * @param value2
  * @return RealNumber 
  * @see {@literal} this method is currently non functional
  */
 public static RealNumber multiply(RealNumber value1, RealNumber value2) {

 }

 /**
  * divides two RealNumber objects together
  * @param value1
  * @param value2
  * @return RealNumber 
  * @see {@literal} this method is currently non functional
  */
 public static RealNumber divide(RealNumber value1, RealNumber value2) {

 }

 /**
  * Takes the square root of a RealNumber
  * @param value
  * @return RealNumber 
  * @see {@literal} this method is currently non functional
  */
 public static RealNumber squareRoot(RealNumber value) {

 }

}