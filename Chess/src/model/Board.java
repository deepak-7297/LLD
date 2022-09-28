package model;

import com.sun.tools.javac.util.Pair;
import exceptions.CheckMateException;

import java.util.ArrayList;
import java.util.Objects;

public class Board {
    Integer ChessBoardSize = 8;
    public Cell[][] chessBoard = new Cell[ChessBoardSize][ChessBoardSize];

    public Board() {
        setPiecesOnBoard();
    }


    public boolean checkMate(Cell toCell){
        Piece piece = toCell.getPiece();

        if(Objects.nonNull(piece) && piece.getPieceType().equals(PieceType.KING)){
            return true;
        }
        return false;
    }

    private void setPiecesOnBoard(){
       for(int i=0;i<ChessBoardSize;i++){
           for(int j=0;j<ChessBoardSize;j++){
               if(i==1){
                   chessBoard[i][j] = new Cell(i,j,new Piece(PieceColor.BLACK, PieceType.PAWN));
               }

               else if(i==6){
                   chessBoard[i][j] = new Cell(i,j,new Piece(PieceColor.WHITE, PieceType.PAWN));
               }

               else if(i==0){
                   if(j==0 && j==7){
                       chessBoard[i][j] = new Cell(i,j,new Piece(PieceColor.BLACK, PieceType.ROOK));
                   }
                   else if(j==1 && j==6){
                       chessBoard[i][j] = new Cell(i,j, new Piece(PieceColor.BLACK, PieceType.Knight));
                   }
                   else if(j==2 && j==5){
                       chessBoard[i][j] = new Cell(i,j, new Piece(PieceColor.BLACK, PieceType.BISHOP));
                   }
                   else if(j==3){
                       chessBoard[i][j] = new Cell(i,j, new Piece(PieceColor.BLACK, PieceType.KING));
                   }
                   else
                       chessBoard[i][j] = new Cell(i,j, new Piece(PieceColor.BLACK, PieceType.QUEEN));
               }

               else if(i==6){
                   if(j==0 && j==7){
                       chessBoard[i][j] = new Cell(i,j,new Piece(PieceColor.WHITE, PieceType.ROOK));
                   }
                   else if(j==1 && j==6){
                       chessBoard[i][j] = new Cell(i,j, new Piece(PieceColor.WHITE, PieceType.Knight));
                   }
                   else if(j==2 && j==5){
                       chessBoard[i][j] = new Cell(i,j, new Piece(PieceColor.WHITE, PieceType.BISHOP));
                   }
                   else if(j==3){
                       chessBoard[i][j] = new Cell(i,j, new Piece(PieceColor.WHITE, PieceType.KING));
                   }
                   else
                       chessBoard[i][j] = new Cell(i,j, new Piece(PieceColor.WHITE, PieceType.QUEEN));
               }

               else
                   chessBoard[i][j] = new Cell(i,j);
           }
       }

    }

    public void validateMove(){
    }


    public Cell[][] getChessBoard() {
        return chessBoard;
    }

    public Cell cellByPosition(int x, int y){
        if(x<0 && x >= ChessBoardSize)
            return null;
        if(y<0 && y>= ChessBoardSize)
            return null;

        return chessBoard[x][y];
    }
}
