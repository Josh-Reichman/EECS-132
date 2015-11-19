package project4;

import java.awt.Color;

/**
 * @author Josh Reichman
 * Sets up a game of Xiangqi
 */
public class Xiangqi {
	ChessBoard xiangqiGame;

	public static void main(String[] args) {
		new Xiangqi();

	}

	/**
	 * Places all pieces on a chess board.
	 */
	Xiangqi() {
		xiangqiGame = new ChessBoard(10, 9, new XiangqiDisplay(), new XiangqiGame());
		// Kings
		xiangqiGame.addPiece(new KingPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 4), 0, 4);
		xiangqiGame.addPiece(new KingPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 4), 9, 4);

		// Guards
		xiangqiGame.addPiece(new GuardPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 5), 0, 5);
		xiangqiGame.addPiece(new GuardPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 3), 0, 3);
		xiangqiGame.addPiece(new GuardPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 5), 9, 5);
		xiangqiGame.addPiece(new GuardPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 3), 9, 3);

		// Elephants
		xiangqiGame.addPiece(new ElephantPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 6), 0, 6);
		xiangqiGame.addPiece(new ElephantPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 2), 0, 2);
		xiangqiGame.addPiece(new ElephantPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 6), 9, 6);
		xiangqiGame.addPiece(new ElephantPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 2), 9, 2);

		// Knights
		xiangqiGame.addPiece(new KnightPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 7), 0, 7);
		xiangqiGame.addPiece(new KnightPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 1), 0, 1);
		xiangqiGame.addPiece(new KnightPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 7), 9, 7);
		xiangqiGame.addPiece(new KnightPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 1), 9, 1);

		// Rooks
		xiangqiGame.addPiece(new RookPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 8), 0, 8);
		xiangqiGame.addPiece(new RookPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 0, 0), 0, 0);
		xiangqiGame.addPiece(new RookPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 8), 9, 8);
		xiangqiGame.addPiece(new RookPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 9, 0), 9, 0);

		// Cannons
		xiangqiGame.addPiece(new CannonPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 2, 7), 2, 7);
		xiangqiGame.addPiece(new CannonPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 2, 1), 2, 1);
		xiangqiGame.addPiece(new CannonPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 7, 7), 7, 7);
		xiangqiGame.addPiece(new CannonPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 7, 1), 7, 1);

		// Pawns
		xiangqiGame.addPiece(new PawnPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 3, 6), 3, 6);
		xiangqiGame.addPiece(new PawnPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 3, 2), 3, 2);
		xiangqiGame.addPiece(new PawnPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 6, 6), 6, 6);
		xiangqiGame.addPiece(new PawnPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 6, 2), 6, 2);
		xiangqiGame.addPiece(new PawnPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 3, 8), 3, 8);
		xiangqiGame.addPiece(new PawnPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH, 3, 0), 3, 0);
		xiangqiGame.addPiece(new PawnPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 6, 8), 6, 8);
		xiangqiGame.addPiece(new PawnPiece(xiangqiGame, Color.WHITE, null, ChessGame.Side.SOUTH, 6, 0), 6, 0);

	}

}
