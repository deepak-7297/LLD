package moves;

import model.Board;
import model.Cell;
import model.PieceType;

import java.util.List;

public class QueenMovesProvider implements PossibleMovesProvider {
    @Override
    public PieceType pieceType() {
        return null;
    }

    @Override
    public List<Cell> showAvailableMoves(Cell curCell, Board board) {
        return null;
    }
}
