package services;

import exceptions.CheckMateException;
import exceptions.ChessException;
import model.Board;
import model.Cell;
import model.Piece;
import model.PieceType;
import moves.PossibleMovesProvider;
import moves.PossibleMovesProviderFactory;

import java.util.List;
import java.util.Objects;

public class ChessBoardService {
    public Board board;

    public ChessBoardService(){
        board = new Board();
    }

    public boolean makeMove(Cell curCell, int horPos, int VerticalPos) throws CheckMateException {
        board.validateMove();

        Cell toCell = board.cellByPosition(horPos, VerticalPos);
        if(Objects.isNull(toCell))
            return false;

        if(toCell.isHavingPiece()){
            toCell.getPiece().setKilled(true);
        }
        Piece piece = curCell.getPiece();
        curCell.setPiece(null);
        toCell.setPiece(piece);
        piece.setTurnCount(piece.getTurnCount()+1);

        if(board.checkMate(toCell)){
            throw new CheckMateException();
        }
        return true;
    }


    public List<Cell> showPossibleMoves(Cell fromCell){
        Piece piece = fromCell.getPiece();
        if(Objects.isNull(piece))
            return null;

        PossibleMovesProvider possibleMovesProvider = PossibleMovesProviderFactory.getPossibleMovesProvider(fromCell.getPiece().getPieceType());
        return possibleMovesProvider.showAvailableMoves(fromCell, board);
    }
}
