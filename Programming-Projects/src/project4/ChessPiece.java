package project4;

import java.awt.Color;
import javax.swing.*;

import project4.ChessGame.Side;

/**
 * @author Josh Reichman
 * General code for the all chesspiece subclasses
 */
public abstract class ChessPiece {

	protected ChessBoard board;
	protected Color color;
	protected String label;
	protected Icon icon;
	protected ChessGame.Side side;
	protected int row;
	protected int column;

	/**
	 * @param colorInput
	 * sets the color of a piece
	 */
	public void setColor(Color colorInput) {
		color = colorInput;
	}

	/**
	 * @return Color
	 * returns the color of a piece
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @return String
	 * returns the label of a piece
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @return Icon
	 * returns the icon of a piece
	 */
	public Icon getIcon() {
		return icon;
	}
	/**
	 * @return ChessBoard
	 * returns the chess board used by a piece
	 */
	public ChessBoard getChessBoard() {
		return board;
	}

	/**
	 * @return Side
	 * returns the team of a piece
	 */
	public Side getSide() {
		return side;
	}

	/**
	 * @return int
	 * returns row coordinate 
	 */
	public int getRow() {
		return row;
	}
	/**
	 * @return int
	 * returns column coordinate 
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Sets the color of a piece to the corresponding color of a side
	 */
	public void setDefaultColor() {
		if (side == Side.NORTH)
			setColor(Color.RED);
		else // South
			setColor(Color.WHITE);
	}
	/**
	 * @param row
	 * @param column
	 * @return boolean
	 * Tells if a location on the chess board is legal
	 * Overridden by pieces
	 */
	public boolean isLegalNonCaptureMove(int row, int column) {
		return false;
	}
	/**
	 * @param row
	 * @param column
	 * @return boolean
	 * Tells if a location on the chess board is legal with no opponent
	 * Overridden by pieces
	 */
	public boolean isLegalCaptureMove(int row, int column) {
		return false;
	}
	/**
	 * @param row
	 * @param column
	 * @return boolean
	 * Tells if a location on the chess board is legal with an opponent
	 * Overridden by pieces
	 */
	public boolean isLegalMove(int row, int column) {
		return false;
	}

	public void moveDone() {
	}
}
