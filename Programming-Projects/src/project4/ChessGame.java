package project4;

public interface ChessGame {

 public boolean legalPieceToPlay(ChessPiece piece);
 public boolean makeMove(ChessPiece pieces, int row, int column);
 public enum Side {NORTH, SOUTH};
}
