package Exceptions.Domains;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException() {

        super("No data found");
    }
}
