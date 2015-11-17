package project4;

public interface ChessGame {

 public boolean legalPieceToPlay(ChessPiece piece);
 public boolean makeMove(KingPiece piece, int row, int column);
 public enum Side {NORTH, SOUTH};
}
