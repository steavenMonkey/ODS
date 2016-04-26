package example.threadPool;

public class LineHanlderTask implements Runnable{

	private int taskId;
	public LineHanlderTask(int taskId) {
		this.taskId = taskId;
	}
//	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("line task " + taskId + " is running now");
	}
	

}
