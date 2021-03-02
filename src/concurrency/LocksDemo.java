package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksDemo {
	public static void main (String[] args) throws Exception {
		Lock lock = new ReentrantLock(true);
		Map<String, String> results = new HashMap<>();
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 4; i ++) {
			String task = "Task-" + i;
			String result = (String) executorService.submit(new LockTask(lock, task)).get();
			results.putIfAbsent(task, result);
		}
		executorService.shutdown();
		for(Map.Entry item : results.entrySet()) {
			System.out.println(item.getKey() + ": " + item.getValue());
		}
		System.out.println("counter: " + LockTask.count);
	}
}
