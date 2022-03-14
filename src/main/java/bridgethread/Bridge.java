package bridgethread;

public class Bridge {
    public void driveThrough(Car car){
        System.out.println(car + " is crossing the bridge...");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(car + " finished crossing the bridge.");
    }
}
