package example.threadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolHolder {
	
	private ThreadPoolExecutor filePool;
	private ThreadPoolExecutor linePool;
	
	private static ThreadPoolHolder instance = new ThreadPoolHolder();
	
	private ThreadPoolHolder(){
		this.filePool = new ThreadPoolExecutor(2, 10, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10));
		this.linePool = new ThreadPoolExecutor(2, 10, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10));
	}
	
	public static ThreadPoolHolder getInstance(){
		return instance;
	}
	
	public void submitTask(ThreadPoolExecutor pool, Runnable task){
		boolean flag = false;
		while(!flag){
			try {
				pool.submit(task);
				flag = true;
			} catch (RejectedExecutionException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public ThreadPoolExecutor getFilePool() {
		return filePool;
	}

	public ThreadPoolExecutor getLinePool() {
		return linePool;
	}
	
	
}
