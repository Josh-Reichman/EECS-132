package project4;

import java.awt.Color;
import javax.swing.*;

public interface ChessPiece {
	
	public ChessBoard getChessBoard();
	public Color getColor();
	public String getLabel();
	public Icon getIcon();
	public ChessGame.Side getSide();
	public int getRow();
	public int getColumn();
	public boolean isLegalNonCaptureMove(int row, int column);
	public boolean isLegalCaptureMove(int row, int column);
	public boolean isLegalMove(int row, int column);
	public void moveDone();
}
