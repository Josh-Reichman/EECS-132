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
public class ChessBoard implements ActionListener{
	private int rows;
	private int columns;
	private JPanel board;
	private JFrame boardDisplay;
	private JButton[][] grid;
	private ChessPiece[][] pieces;
	private ChessBoardDisplay display;
	private ChessGame chessVersion;
	private boolean firstClick;

	public ChessBoard(int rowInput, int columnsInput, ChessBoardDisplay chessDisplay){
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e) {
		}
		firstClick = false;
		rows = rowInput;
		columns = columnsInput;
		display = chessDisplay;
		board= new JPanel(new GridLayout(rows,columns));
		chessVersion = new ChessGame.Xiangqi();
		boardDisplay = new JFrame();
		pieces = new ChessPiece[rows][columns];
		grid = new JButton [rows][columns];
		for(int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++){
				grid[i][j] = new JButton();
				board.add(grid[i][j]);
			}
		}
		boardDisplay.getContentPane().add(board, "Center");
		boardDisplay.setSize(500,500);
		boardDisplay.setVisible(true);
	}
	public void addPiece(ChessPiece piece, int row, int column){
		pieces[row][column] = piece;
		display.displayFilledSquare(grid[row][column], row, column, piece);
	}
	public ChessPiece removePiece(int row, int column){
		ChessPiece pieceRemoved = pieces[row][column];
		pieces[row][column] = null;
		return pieceRemoved;
	}
	public boolean hasPiece(int row, int column){
		if(pieces[row][column].equals(null)){
			return false;
		}
		else{
			return true;
		}
	}
	public ChessPiece getPiece(int row, int column){
		if(pieces[row][column].equals(null)){
			return null;
		}
		else{
			return pieces[row][column];
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JButton click = (JButton) e.getSource();
		for(int i =0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j].equals(click)){
					if(!pieces[i][j].equals(null)){
						this.
					}
					else{
						makeMove(pieces[i][j], i, j);
					}
				}
			}
		}
		makeMove(pieces[1][1], 2, 3);
	}
}
