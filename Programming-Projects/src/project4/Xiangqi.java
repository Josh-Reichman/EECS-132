package project4;

import java.awt.Color;

import javax.swing.Icon;

public class Xiangqi implements ChessGame {
	ChessBoard xiangqiGame;

	Xiangqi(){
		xiangqiGame = new ChessBoard(10,9,new XiangqiDisplay());
		xiangqiGame.addPiece(new KingPiece(xiangqiGame, Color.RED, null, ChessGame.Side.NORTH,0,4), 0,4) ;
	}
	public static void main(String[] args){
		new Xiangqi();
	}
	
	
	@Override
	public boolean legalPieceToPlay(ChessPiece piece) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean makeMove(KingPiece piece, int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}
}
