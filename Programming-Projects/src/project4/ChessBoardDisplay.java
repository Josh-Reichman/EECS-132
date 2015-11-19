/**
 * 
 */
package project4;

import javax.swing.*;

/**
 * @author Josh Reichman
 * Chess board gui interface code
 */
public interface ChessBoardDisplay {

	public void displayEmptySquare(JButton jButn, int row, int column);  
	public void displayFilledSquare(JButton jButn, int row, int column, ChessPiece piece );
	public void highlightSquare(JButton jButn, int row, int column, boolean highlighted, ChessPiece piece);
}
