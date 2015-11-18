package project4;

import java.awt.Color;



public class Xiangqi implements ChessGame {
	ChessBoard xiangqiGame;
	ChessGame.Side currentTurn;
	public static void main(String[] args){
		Xiangqi game = new Xiangqi();
		
	}
	Xiangqi(){
		xiangqiGame = new ChessBoard(10,9,new XiangqiDisplay());
		currentTurn = Side.NORTH;
		xiangqiGame.addPiece(new KingPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH,0,4), 0,4) ;
	}

	
	
	@Override
	public boolean legalPieceToPlay(ChessPiece piece) {
		return piece.side.equals(currentTurn);
	}
	@Override
	public boolean makeMove(ChessPiece pieces, int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}
}
