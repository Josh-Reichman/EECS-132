package project4;
/**
 * 
 */

/**
 * @author Josh Reichman
 * Xiangqi chess game code variant
 */
public class XiangqiGame implements ChessGame{

	ChessGame.Side currentTurn = ChessGame.Side.NORTH;

	@Override
	public boolean legalPieceToPlay(ChessPiece piece) {
		return piece.side.equals(currentTurn);
	}
	@Override
	public boolean makeMove(ChessPiece pieces, int row, int column) {

		return false;
	}
}
