/**
 * 
 */
package project4;
import java.awt.*;

import javax.swing.*;

/**
 * @author joshreichman
 *
 */
public class XiangqiDisplay implements ChessBoardDisplay {

	@Override
	public void displayEmptySquare(JButton jButn, int row, int column){
		jButn.setBackground(java.awt.Color.GRAY);
		jButn.setText("");
		jButn.setIcon(null);
	}
	@Override
	public void displayFilledSquare(JButton jButn, int row, int column, ChessPiece piece){
		jButn.setBackground(piece.getColor());
		jButn.setText(piece.getLabel());
		jButn.setIcon(piece.getIcon());
	}
	
	@Override
	public void highlightSquare(JButton jButn, int row, int column, boolean highlighted, ChessPiece piece){
		if(highlighted){
			jButn.setBackground(java.awt.Color.YELLOW);
		}
	}
}
