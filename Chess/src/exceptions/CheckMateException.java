package exceptions;

public class CheckMateException extends ChessException{

    public static String message = "CheckMate, You won the game";

    public CheckMateException() {
        super(message,501);
    }

    public CheckMateException(String message){
        super(message, 200);
    }
}
