package example.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class CyclicBarrierTestCase {
	
	@Test
	public void testCyclicBarrier(){
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("do something after await... ...");
			}
		});
		for(int i=0; i<4; i++){
			Task task = new Task(barrier, i);
			new Thread(task).start();
		}
		System.out.println("after distribute task....");
		
		
	}
	
	
	class Task implements Runnable{
		
		private CyclicBarrier barrier;
		private int taskId;
		
		public Task(CyclicBarrier barrier, int taskId) {
			super();
			this.barrier = barrier;
			this.taskId = taskId;
		}



		@Override
		public void run() {
			System.out.println("taskId:"+ taskId +"doing sub task......");
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
	}
}
