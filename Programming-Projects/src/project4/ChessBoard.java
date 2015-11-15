/**
 * 
 */
package project4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author joshreichman
 *
 */
public class ChessBoard {
	private int rows;
	private int columns;
	private JPanel board;
	private JFrame boardDisplay;
	private JButton[][] grid;
	public ChessBoard(int rowInput, int columnsInput, ChessBoardDisplay chessDisplay, ChessGame chessVersion){
		int rows = rowInput;
		int columns = columnsInput;
		board= new JPanel(new GridLayout(rows,columns));
		boardDisplay.getContentPane().add(board, "Center");
		grid = new JButton [rows][columns];
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++){
				grid[i][j] = new JButton();
			}
		}
		boardDisplay.setVisible(true);
	}
	public void addPiece(ChessPiece piece, int row, int column){
		
	}
	public ChessPiece removePiece(ChessPiece piece, int row, int column){
		
	}
	public boolean hasPiece(int row, int column){
		
	}
	public ChessPiece getPiece(int row, int column){
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
	}
		
}
