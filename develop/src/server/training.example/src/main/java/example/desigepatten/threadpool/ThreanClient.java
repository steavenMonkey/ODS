package example.desigepatten.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreanClient {
	
	
	public static void main(String[] args) {
		
		
		CountDownLatch countDownLatch = new CountDownLatch(1);
		ThreadPoolExecutor filePool = null;
		ThreadPoolExecutor linePool = null;
		try {
			filePool = ThreadPoolHolder.getInstance().getFilePool();
			linePool = ThreadPoolHolder.getInstance().getLinePool();
			for(int i=0;i<1;i++){
				FileHandlerTask fileTask = new FileHandlerTask(i, countDownLatch);
				ThreadPoolHolder.getInstance().submitTask(filePool, fileTask);
			}
			countDownLatch.await();
			boolean flag = false;
			while(!flag){
				if(linePool.getActiveCount() > 0){
					System.out.println("line pool stil has task");
				}else{
					System.out.println("line pool finisl all tasks");
					flag = true;
				}
			}
			filePool.shutdown();
			linePool.shutdown();
			System.out.println("all task finished..............");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
