package project4;

public interface ChessGame {

	public boolean legalPieceToPlay(/*chess piece*/ );
	public boolean makeMove(ChessPiece piece, int row, int column);
	public enum Side {NORTH, SOUTH};
}
