package example.thread.exchager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

public class ExchangerTestcase {
	
	/**
	 * 用于两个线程之间的交换，在交换时线程处于阻塞状态
	 */
	
	Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();
	
	List<Integer> fullLoop = new ArrayList<Integer>();
	List<Integer> emptyLoop = new ArrayList<Integer>();
	
	
	class Producer implements Runnable{

		@Override
		public void run() {

			List<Integer> dataList = emptyLoop;
			AtomicInteger data = new AtomicInteger(0);
			while(dataList != null){
				dataList.add(data.incrementAndGet());
				System.out.println(dataList.size());
				if(dataList.size() > 10){
					try {
						dataList = exchanger.exchange(dataList);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	class Cunsomer implements Runnable{

		@Override
		public void run() {
			List<Integer> dataList = fullLoop;
			try {
				while (dataList != null) {
					if (dataList.isEmpty()) {
						dataList = exchanger.exchange(dataList);
					}else{
						System.out.println(dataList.remove(0));
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void start(){
		
		new Thread(new Producer()).start();
		new Thread(new Cunsomer()).start();
	}
	
	public static void main(String[] args) {
		ExchangerTestcase etc = new ExchangerTestcase();
		etc.start();
	}
	
}
