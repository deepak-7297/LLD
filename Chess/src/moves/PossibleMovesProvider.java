package moves;

import model.Board;
import model.Cell;
import model.PieceType;

import java.util.List;

public interface PossibleMovesProvider {
    PieceType pieceType();

    List<Cell> showAvailableMoves(Cell curCell, Board board);
}
