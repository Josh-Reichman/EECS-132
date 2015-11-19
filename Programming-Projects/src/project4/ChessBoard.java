/**
 * 
 */
package project4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Josh Reichman
 * Creates the chess board and manages pieces within
 */
public class ChessBoard {
	private int rows;
	private int columns;
	private JPanel board;
	private JFrame boardDisplay;
	private JButton[][] grid;
	private ChessPiece[][] pieces;
	private ChessBoardDisplay display;
	private ChessGame chessVersion;
	private boolean firstClick;

	/**
	 * @param rowInput
	 * @param columnsInput
	 * @param chessDisplay
	 * @param chessVersion
	 * Creates the chess board
	 */
	public ChessBoard(int rowInput, int columnsInput, ChessBoardDisplay chessDisplay, ChessGame chessVersion) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		firstClick = true;
		rows = rowInput;
		columns = columnsInput;
		display = chessDisplay;
		board = new JPanel(new GridLayout(rows, columns));
		this.chessVersion = chessVersion;
		boardDisplay = new JFrame();
		pieces = new ChessPiece[rows][columns];
		grid = new JButton[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				grid[i][j] = new JButton();
				grid[i][j].addActionListener(new ChessBoardListener(i, j));
				board.add(grid[i][j]);
				display.displayEmptySquare(grid[i][j], rows, columns);
			}
		}
		boardDisplay.getContentPane().add(board, "Center");
		boardDisplay.setSize(500, 500);
		boardDisplay.setVisible(true);
	}

	/**
	 * @param piece
	 * @param row
	 * @param column
	 * adds a piece to the chess board
	 */
	public void addPiece(ChessPiece piece, int row, int column) {
		pieces[row][column] = piece;
		display.displayFilledSquare(grid[row][column], row, column, piece);
	}

	/**
	 * @param row
	 * @param column
	 * @return ChessPiece
	 * removes a piece from the chess board
	 */
	public ChessPiece removePiece(int row, int column) {
		ChessPiece pieceRemoved = pieces[row][column];
		pieces[row][column] = null;
		return pieceRemoved;
	}

	/**
	 * @param row
	 * @param column
	 * @return boolean
	 * checks if there is a piece on a location
	 */
	public boolean hasPiece(int row, int column) {
		if (pieces[row][column] == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param row
	 * @param column
	 * @return ChessPiece
	 * checks if there is a piece on a location and returns it
	 */
	public ChessPiece getPiece(int row, int column) {
		if (pieces[row][column] == null) {
			return null;
		} else {
			return pieces[row][column];
		}
	}

	/**
	 * Actionlistener for the ChessBoard class
	 */
	public class ChessBoardListener implements ActionListener {
		private int row;
		private int column;
		private int prevRow;
		private int prevColumn;

		/**
		 * @param row
		 * @param column
		 * Constructor
		 */
		public ChessBoardListener(int row, int column) {
			this.row = row;
			this.column = column;
			this.prevRow = row;
			this.prevColumn = column;

		}

		/**
		 * ActionEvent code
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton click = (JButton) e.getSource();

			if (firstClick) {
				if (hasPiece(row, column)) {
					display.highlightSquare(click, row, column, true, getPiece(row, column));

					if (chessVersion.legalPieceToPlay(pieces[row][column])) {
						System.out.print(2);
						firstClick = false;
					} else {
						firstClick = true;
					}
				}

			} else {
				if (getPiece(row, column) == null) {
					getPiece(prevRow + 1, prevColumn + 1).setDefaultColor();
					firstClick = true;
				} else if (row != prevRow && column != prevColumn) {
					display.highlightSquare(click, row, column, false, getPiece(row, column));
					firstClick = true;
				}
			}

		}
	}

}
