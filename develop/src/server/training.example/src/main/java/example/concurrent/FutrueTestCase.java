package example.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class FutrueTestCase {
	
	@Test
	public void testGet(){
		ExecutorService executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2));
		Task task = new Task();
		Future<Integer> future = executor.submit(task);
		try {
			System.out.println("main thread sleep 5s... ...");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Integer result = future.get();
			System.out.println(result);
			if(future.isDone()){
				executor.shutdown();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
	class Task implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			int sum = 0;
			for(int i=0; i<10; i++){
				sum+=i;
			}
			return sum;
		}
		
	}
}
