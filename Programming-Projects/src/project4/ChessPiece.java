package project4;

import java.awt.Color;
import javax.swing.*;

public class ChessPiece{
	
	 protected ChessBoard board;
	 protected Color color;
	 protected String label;
	 protected Icon icon;
	 protected ChessGame.Side side;
	 protected int row;
	 protected int column;
	
	public ChessBoard getChessBoard() {
		return null;
	}
	public Color getColor() {
		return null;
	}
	public String getLabel() {
		return null;
	}
	public Icon getIcon() {
		return null;
	}
	public ChessGame.Side getSide() {
		return null;
	}
	public int getRow() {
		return 0;
	}
	public int getColumn() {
		return 0;
	}
	public boolean isLegalNonCaptureMove(int row, int column) {
		return false;
	}
	public boolean isLegalCaptureMove(int row, int column) {
		return false;
	}
	public boolean isLegalMove(int row, int column) {
		return false;
	}
	public void moveDone() {
	}
}
