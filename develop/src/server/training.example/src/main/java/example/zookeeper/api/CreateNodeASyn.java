package example.zookeeper.api;

import java.io.IOException;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class CreateNodeASyn implements Watcher{
	
	private static ZooKeeper zookeeper;
	
	public static void main(String[] args) {
		String connectString = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		int sessionTimeout = 5000;
		try {
			zookeeper = new ZooKeeper(connectString, sessionTimeout, new CreateNodeASyn());
			System.out.println(zookeeper.getState());
			Thread.sleep(Integer.MAX_VALUE);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event);
		if(event.getState().equals(KeeperState.SyncConnected)){
			doSomething();
		}
	}
	
	private void doSomething(){
		/*
		 * 异步调用创建节点接口
		 */
		System.out.println("clinet connected zookeeper, now is do something");
		String path = "/node_01";
		byte[] data = "123".getBytes();
		zookeeper.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new IStringCallBack(), "123");
	}
	
	static class IStringCallBack implements AsyncCallback.StringCallback{

		@Override
		public void processResult(int rc, String path, Object ctx, String name) {
			StringBuffer sb = new StringBuffer();
			sb.append("rc=" + rc+ "\n" );/*接口调用结果的返回码*/
			sb.append("path=" + path+ "\n" );/*节点路径*/
			sb.append("ctx=" + ctx+ "\n" );/*异步调用时传入的上下文参数*/
			sb.append("name=" + name);/*节点创建成功后的节点名*/
			System.out.println(sb.toString());
		}
		
	}
}
