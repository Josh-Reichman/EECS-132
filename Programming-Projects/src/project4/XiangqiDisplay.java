/**
 * 
 */
package project4;

import javax.swing.*;

/**
 * @author Josh Reichman
 * Xiangqi gui code
 */
public class XiangqiDisplay implements ChessBoardDisplay {

	/** 
	 * @param jButn
	 * @param row
	 * @param column
	 * Sets a square on a chess board to a state with nothing on it
	 */
	@Override
	public void displayEmptySquare(JButton jButn, int row, int column){
		jButn.setBackground(java.awt.Color.GRAY);
		jButn.setText("");
		jButn.setIcon(null);
	}
	/** 
	 * @param jButn
	 * @param row
	 * @param column
	 * @param piece
	 * Sets a square on a chess board to a state with a chess piece on it
	 */
	@Override
	public void displayFilledSquare(JButton jButn, int row, int column, ChessPiece piece){
		jButn.setBackground(piece.getColor());
		jButn.setText(piece.getLabel());
		jButn.setIcon(piece.getIcon());
	}
	/** 
	 * @param jButn
	 * @param row
	 * @param column
	 * @param highlighted
	 * @param piece
	 * Sets a square on a chess board to a state with a highlighted chess piece on it
	 */
	@Override
	public void highlightSquare(JButton jButn, int row, int column, boolean highlighted, ChessPiece piece){
		if(highlighted){
			jButn.setBackground(java.awt.Color.YELLOW);
		}
		else{
			if(piece == null){
				this.displayEmptySquare(jButn,row,column);
			}
			else{
				this.displayFilledSquare(jButn, row, column, piece);
			}
		}
	}
}
