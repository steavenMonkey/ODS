package example.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadPoolExcutorTestCase {
	
	@Test
	public void testGetCompletedTask(){
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10));
		System.out.println(pool.getCompletedTaskCount());
		pool.shutdown();
		System.out.println(pool.getTaskCount());
		System.out.println(pool.isShutdown());
		
	}
	
	
}
