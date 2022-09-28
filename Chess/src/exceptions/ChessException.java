package exceptions;

public class ChessException extends Throwable {
    public String message;
    public Integer statusCode = 501;

    public ChessException(String message, Integer statusCode){
        this.statusCode = statusCode;
        this.message = message;
    }

}
