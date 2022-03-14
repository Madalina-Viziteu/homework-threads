package bridgethread;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Bridge bridge = new Bridge();
        Car car1 = new Car("Dacia", "Duster");
        Car car2 = new Car("Mazda", "CX3");
        Car car3 = new Car("Hyundai", "cactus");
        Car car4 = new Car("Volvo", "V90");
        Car car5 = new Car("Honda", "civic");

    /*
        Thread thread1 = new Thread(() -> bridge.driveThrough(car1));

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bridge.driveThrough(car2);
            }
        });

        Runnable thread3 = () -> {
            String threadName = Thread.currentThread().getName();
            bridge.driveThrough(car3);
        };

        thread1.run();
        thread2.run();
        thread3.run();

    */


        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "");
        CompletableFuture<Void> future0 = completableFuture.thenRun(() -> System.out.println("The bridge opened"));
        future0.get();


        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String thread4 = Thread.currentThread().getName();
            bridge.driveThrough(car4);
            bridge.driveThrough(car1);
            bridge.driveThrough(car2);
            bridge.driveThrough(car3);
        });


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            Callable<String> task = () -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    bridge.driveThrough(car5);
                    return "All cars crossed the bridge";
                } catch (InterruptedException e) {
                    throw new IllegalStateException("task interrupted", e);
                }
            };

            Future<String> future = executorService.submit(task);
            System.out.println("future done? " + future.isDone());
            String result = null;
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("future done? " + future.isDone());
            System.out.println("result " + result);
        });

        executor.shutdown();

    }
}
