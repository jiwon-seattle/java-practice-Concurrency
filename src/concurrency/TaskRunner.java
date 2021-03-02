package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskRunner {
	public static void main(String[] args) throws ExecutionException {
		Concurrency c1 = new Concurrency(0);
		Concurrency c2 = new Concurrency(1);
		
		ExecutorService executorServicePool = Executors.newFixedThreadPool(2);
		
		Future<Integer> future1 = executorServicePool.submit(c1);
		Future<Integer> future2 = executorServicePool.submit(c2);
		
		try {
			System.out.println("Upload Complete: " + future1.get());
			System.out.println("Upload Complete: " + future2.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}
	}
}
