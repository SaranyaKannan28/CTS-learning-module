import java.util.concurrent.*;
import java.util.*;

public class ExecutorCallableDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
     
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Future<String>> futureList = new ArrayList<>();


        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            Callable<String> task = () -> {
                Thread.sleep(100); 
                return "Result of Task " + taskId;
            };

            Future<String> future = executor.submit(task);
            futureList.add(future);
        }

        for (Future<String> future : futureList) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}
