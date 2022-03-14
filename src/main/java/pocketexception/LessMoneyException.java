package pocketexception;

public class LessMoneyException extends Throwable {

    public LessMoneyException (){
        super("There are too less money in the pocket");
    }
}
