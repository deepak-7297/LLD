package moves;

import model.PieceType;

public class PossibleMovesProviderFactory {

    public static PossibleMovesProvider getPossibleMovesProvider(PieceType pieceType){
        PossibleMovesProvider possibleMovesProvider = null;
        switch (pieceType){
            case KING: possibleMovesProvider = new KingMovesProvider(); break;
            case QUEEN: possibleMovesProvider =  new QueenMovesProvider(); break;
        }

        return possibleMovesProvider;
    }
}
