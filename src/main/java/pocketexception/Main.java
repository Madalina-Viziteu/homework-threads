package pocketexception;

public class Main {
    public static void main(String args[]) {
        Pocket myPocket = new Pocket();
        try {
            myPocket.setMoney(350);
        } catch (MoreMoneyException e) {
            System.out.println(e.getMessage());
        } catch (LessMoneyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(myPocket);
    }
}
