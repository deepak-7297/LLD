package moves;

import model.Board;
import model.Cell;
import model.PieceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class KingMovesProvider implements PossibleMovesProvider{
    @Override
    public PieceType pieceType() {
        return PieceType.KING;
    }

    @Override
    public List<Cell> showAvailableMoves(Cell curCell, Board board) {
        int[][] possiblePositions = {{1,1}, {-1,-1}, {-1,1}, {1, -1}, {-1,0}, {1,0}, {0,-1}, {0, 1}};
        List<Cell> result = new ArrayList<>();

        for(int index=0; index< 8; index++){
            Cell cell = board.cellByPosition(curCell.getPosHorizontal() + possiblePositions[index][0],
                    curCell.getPosVertical() + possiblePositions[index][1]);
            if(!Objects.isNull(cell))
                result.add(cell);
        }

        return result;
    }
}
