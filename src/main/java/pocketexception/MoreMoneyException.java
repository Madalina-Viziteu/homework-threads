package pocketexception;

public class MoreMoneyException extends Throwable{
    public MoreMoneyException(){
        super("There are to much money in the pocket");
    }
}
