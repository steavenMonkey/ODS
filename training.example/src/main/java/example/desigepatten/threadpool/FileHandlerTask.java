package example.desigepatten.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

public class FileHandlerTask implements Runnable{

	private int taskId;
	private CountDownLatch downLatch;
	public FileHandlerTask(int taskId, CountDownLatch downLatch) {
		this.taskId = taskId;
		this.downLatch = downLatch;
	}
//	@Override
	public void run() {

		System.out.println("file task " + taskId + " is running now");
		ThreadPoolExecutor linePool = null;
		try {
			linePool = ThreadPoolHolder.getInstance().getLinePool();
			for(int i=0; i<10; i++){
				LineHanlderTask lineTask = new LineHanlderTask(i);
				ThreadPoolHolder.getInstance().submitTask(linePool, lineTask);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			downLatch.countDown();
		}
		
	}

}
