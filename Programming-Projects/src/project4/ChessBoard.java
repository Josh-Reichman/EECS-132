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
 private int lastRow;
 private int lastColumns;
 private JPanel board;
 private JFrame boardDisplay;
 private JButton[][] grid;
 public ChessBoard(int rowInput, int columnsInput/*, ChessBoardDisplay chessDisplay, ChessGame chessVersion*/){
  try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      }
      catch (Exception e) {
      }

  rows = rowInput;
  columns = columnsInput;
  board= new JPanel(new GridLayout(rows,columns));
  boardDisplay = new JFrame();
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
  
 }
 public ChessPiece removePiece(ChessPiece piece, int row, int column){
  
 }
 public boolean hasPiece(int row, int column){
  
 }
 public ChessPiece getPiece(int row, int column){
  
 }
 @Override
 public void actionPerformed(ActionEvent e){
	 JButton click = (JButton) e.getSource();
	 for(int i =0; i < grid.length; i++){
		 for(int j = 0; j < grid[i].length; j++){
			 if(grid[i][j].equals(click)){
				 
			 }
		 }
	 }
 }
  
}
