package project4;

/**
 * @author Josh Reichman
 * General code for chess game variants
 */
public interface ChessGame {

	public boolean legalPieceToPlay(ChessPiece piece);
	public boolean makeMove(ChessPiece pieces, int row, int column);
	public enum Side {NORTH, SOUTH};
}
