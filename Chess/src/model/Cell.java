package model;

import java.util.ArrayList;

public class Cell {
    public Integer posHorizontal;
    public Integer posVertical;
    public Piece piece = null;

    public Cell(Integer posHorizontal, Integer posVertical) {
        this.posHorizontal = posHorizontal;
        this.posVertical = posVertical;
    }

    public Cell(Integer posHorizontal, Integer posVertical, Piece piece) {
        this.posHorizontal = posHorizontal;
        this.posVertical = posVertical;
        this.piece = piece;
    }

    public Integer getPosHorizontal() {
        return posHorizontal;
    }

    public Integer getPosVertical() {
        return posVertical;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isHavingPiece(){
        return piece==null;
    }
}
