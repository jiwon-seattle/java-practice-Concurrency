package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Concurrency implements Callable<Integer>{
	private int counter;
	public Concurrency(int counter) {
		this.counter = counter;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public int incrementCtr() {
		return counter++;
	}
	
	@Override
	public Integer call() throws Exception {
		incrementCtr();
		return getCounter();
	}
}

