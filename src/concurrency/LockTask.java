package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;


public class LockTask implements Callable {
	public static int count;
	public String taskName;
	Lock lock;
	LockTask(Lock lock, String name) {
		this.lock = lock;
		this.taskName = name;
	}
	
	private void incrementCounter() {
		++count;
	}
	
	@Override 
	public String call() {
		String result = "";
		System.out.println(Thread.currentThread().getName() + "Started " + this.taskName);
		try {
			lock.lock();
			Thread.sleep(2000);
			incrementCounter();
			lock.unlock();
			result = "Passed";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = "Failed";
		}
		System.out.println(Thread.currentThread().getName() + "Ended " + this.taskName);
		return result;
	}
}

