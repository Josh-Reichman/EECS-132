//Josh Reichman
//Fun with loops and strings

////////////// Personal Notes/////////////////
//  ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,  //
//  :Allowed Java API Classes and methods:  //
//  ''''''''''''''''''''''''''''''''''''''  //
// class String                             //
//    *length                               //
//    *charAt                               //
// class StringBuilder                      //
//    *length                               //
//    *charAt                               //
//    *append                               //
//    *toString                             //
// class Character                          //
//    *any method                           //
// JOptionPane                              //
//    *ShowInputDialog                      //
//////////////////////////////////////////////

//package project2;
import java.io.*;
import javax.swing.JOptionPane;

public class HW2 {

 public static void main(String[] args) {
  System.out.println(HW2.hiddenInString("abracadabra", "cad", 1));
  System.out.println(HW2.hiddenInString("abracadabra", "cad", 2));
  System.out.println(HW2.hiddenInString("abracadabra", "baaa", 2));
  System.out.println(HW2.hiddenInString("abracadabra", "ab", 3));
  System.out.println(HW2.hiddenInString("abracadabra", "abc", 3));
  System.out.println(HW2.hiddenInString("abracadabra", "bar", -3));

 }

 public static String replaceFirstK(String input, char find, char replace, int replaceAmount) {
  int replaceCount = 0;
  int currentCount = 0;
  StringBuilder sb = new StringBuilder();
  while (!(sb.length() < input.length()) || (replaceCount < replaceAmount)) {
   if (input.charAt(currentCount) == (Character) find) {
    sb.append(replace);
    replaceCount++;
   } else {
    sb.append(input.charAt(currentCount));
   }
   currentCount++;
  }
  while (currentCount < input.length()) {
   sb.append(input.charAt(currentCount));
   currentCount++;
  }
  return sb.toString();
 }

 public static String allChars(char first, char last) {
  int currentCount = 0;
  StringBuilder sb = new StringBuilder();
  for (int count = (int) last - (int) first; currentCount <= count; currentCount++) {
   sb.append(Character.toChars(currentCount + (int) first));
  }
  return sb.toString();
 }
 /*
 public static String showCharOfString(String input, String notRedacted) {
  int charactersToCheck = notRedacted.length();
  StringBuilder sb = new StringBuilder();
  for (int currentPos = 0, charactersChecked = 0; currentPos < input.length(); currentPos++, charactersChecked  = 0) {

   while(charactersChecked <= charactersToCheck)
    if(input.charAt(currentPos)=='a'){

    }
   sb.append(Character.toUpperCase(input.charAt(currentPos)));
  }

 }

 public static boolean hangman(String word, int guesses) {

 }
  */
 public static boolean hiddenInString(String input, String find, int charSkip) {
  int currentPos;
  int findPos;
  if(charSkip>0){
   currentPos = 0;
   while(currentPos < input.length()){
    findPos = currentPos;
    for(int charsChecked = 1;input.charAt(findPos) == find.charAt(charsChecked-1);findPos+=charSkip, charsChecked++){
     if(charsChecked == find.length()){
      return true;
     }
     if (findPos+charSkip>input.length()-1){
      return false;
     }
    }
    currentPos++;
   }
   return false;
  }
  else
  {
   currentPos = input.length()-1;
   while(currentPos > 0){
    findPos = currentPos;
    for(int charsChecked = 1;input.charAt(findPos) == find.charAt(charsChecked-1);findPos+=charSkip, charsChecked++){
     if(charsChecked == find.length()){
      return true;
     }
     if (findPos+charSkip>input.length()-1){
      return false;
     }
    }
    currentPos--;
   }
   return false;
  }
 }
 public static String capitalizeWords(String input) {
  StringBuilder sb = new StringBuilder();
  StringBuilder currentWord = new StringBuilder();


  for (int currentPos = 0; currentPos < input.length(); currentPos++) {

   sb.append(Character.toUpperCase(input.charAt(currentPos)));
  }
  return sb.toString();
 }
}
