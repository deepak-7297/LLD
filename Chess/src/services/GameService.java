package services;

import exceptions.CheckMateException;
import exceptions.ChessException;
import model.Cell;
import model.PieceColor;
import model.Player;

import java.util.List;

public class GameService {
    public Player player1;
    public Player player2;
    public Player currentTurn;
    public ChessBoardService chessBoardService;


    public GameService(String player1name, String player2Name, PieceColor player1Color, PieceColor player2Color){
        player1 = new Player(player1name);
        player2 = new Player(player2Name);
        player1.setColor(player1Color);
        player2.setColor(player2Color);
    }

    public void startGame(){
        chessBoardService = new ChessBoardService();
    }

    public void playTurn(Cell fromCell, int horPos, int VerticalPos) throws CheckMateException {
        try{
            chessBoardService.makeMove(fromCell,horPos,VerticalPos);
        }catch (CheckMateException exception){
            throw  new CheckMateException("Player " + currentTurn.getUsername() + "Won");
        }

        if(currentTurn.equals(player1))
            currentTurn = player2;
        else
            currentTurn = player2;
    }
}
