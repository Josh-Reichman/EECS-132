/**
 * 
 */
package project4;
import java.awt.*;
import javax.swing.*;

import project4.ChessGame.*;
/**
 * @author joshreichman
 *
 */
public class KingPiece extends ChessPiece{
 
 public KingPiece(ChessBoard board, Color color, Icon icon, ChessGame.Side side,int row,int column){
	 this.board=board;
	 this.color=color;
	 this.label="K";
	 this.icon=icon;
	 this.side=side;
	 this.row=row;
	 this.column=column;
 }
 
 public void setColor(Color colorInput){
  color = colorInput;
 }
 @Override
 public Color getColor(){
  return color;
 }
 @Override
 public String getLabel(){
  return label;
 }
 @Override
 public Icon getIcon(){
  return icon;
 }
 @Override
 public ChessBoard getChessBoard() {
  // TODO Auto-generated method stub
  return board;
 }
 @Override
 public Side getSide() {
  // TODO Auto-generated method stub
  return side;
 }
 @Override
 public int getRow() {
  // TODO Auto-generated method stub
  return row;
 }
 @Override
 public int getColumn() {
  // TODO Auto-generated method stub
  return column;
 }
 @Override
 public boolean isLegalMove(int row, int column) {
  if(board.hasPiece(row, column)){
	  return false;
  }
  else{
	  return true;
  }
 }
 @Override
 public boolean isLegalNonCaptureMove(int row, int column) {
	 if(!board.hasPiece(row, column)){
		 if(getSide().equals(Side.NORTH)){
			 if(row <= 3 && column > 3 && column < 7){
				 return true;
			 }
			 else{
				 return false;
			 }
		 }
		 else{ //(getSide().equals(Side.SOUTH))
			 if(row >= 7 && column > 3 && column < 7){
				 return true;
			 }
			 else{
				 return false;
			 }
		 }
	 }
	 else{
		 return false;
	 }
 }
 @Override
 public boolean isLegalCaptureMove(int row, int column) {
  // TODO Auto-generated method stub
  return false;
 }

 @Override
 public void moveDone() {  
 }

}