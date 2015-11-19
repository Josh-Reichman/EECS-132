/**
 * 
 */
package project4;

import java.awt.*;
import javax.swing.*;

import project4.ChessGame.*;

/**
 * @author Josh Reichman
 * code for the elephant
 */
public class ElephantPiece extends ChessPiece {
	/**
	 * @param board
	 * @param color
	 * @param icon
	 * @param side
	 * @param row
	 * @param column
	 * Creates a ChessPiece that is an Elephant
	 */
	public ElephantPiece(ChessBoard board, Color color, Icon icon, ChessGame.Side side, int row, int column) {
		this.board = board;
		this.color = color;
		this.label = "E";
		this.icon = icon;
		this.side = side;
		this.row = row;
		this.column = column;
	}
	/** 
	 * Sets the color of the piece to the corresponding color of a side
	 */
	@Override
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
	 */
	@Override
	public boolean isLegalMove(int row, int column) {
		if (board.hasPiece(row, column)) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * @param row
	 * @param column
	 * @return boolean
	 * Tells if a location on the chess board is legal with no opponent
	 */
	@Override
	public boolean isLegalNonCaptureMove(int row, int column) {
		if (!board.hasPiece(row, column)) {
			if (getSide().equals(Side.NORTH)) {
				if (row <= 5) {
					return true;
				} else {
					return false;
				}
			} else { // (getSide().equals(Side.SOUTH))
				if (row >= 6) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	/**
	 * @param row
	 * @param column
	 * @return boolean
	 * Tells if a location on the chess board is legal with an opponent
	 */
	@Override
	public boolean isLegalCaptureMove(int row, int column) {

		return false;
	}

}