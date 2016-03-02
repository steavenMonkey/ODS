package example.zookeeper.api;

import java.io.IOException;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class GetDataASyn implements Watcher{
	
	private static ZooKeeper zookeeper;
	
	public static void main(String[] args) {
		String connectString = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		int sessionTimeout = 5000;
		try {
			zookeeper = new ZooKeeper(connectString, sessionTimeout, new GetDataASyn());
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
			if(event.getType() == EventType.None && null == event.getPath()){
				doSomething(zookeeper);
			}else{
				if(event.getType() == EventType.NodeDataChanged || event.getType() == EventType.NodeDeleted){
					zookeeper.getData("/", true, new IDataCallback(), "123");
				}
			}
		}
		
		
	}
	
	private void doSomething(ZooKeeper zooKeeper){
		/*
		 * 异步调用创建节点接口
		 */
		System.out.println("clinet connected zookeeper, now is do something");
		String path = "/";
		try {
//			List<String> subList = zookeeper.getChildren(path, false/*是否监听改节点*/);
//			System.out.println(subList);
			zookeeper.getChildren(path, true);
			zooKeeper.getData(path, true, new IDataCallback(), "123");
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	static class IDataCallback implements AsyncCallback.DataCallback{

		@Override
		public void processResult(int rc, String path, Object ctx, byte[] data,
				Stat stat) {
			StringBuffer sb = new StringBuffer();
			sb.append("rc=" + rc).append("\n");
			sb.append("path=" + path).append("\n");
			sb.append("ctx=" + ctx).append("\n");
			sb.append("data" + new String(data)).append("\n");
			sb.append("stat" + stat).append("\n");
			System.out.println(sb.toString());
		}
		
	}
	
}
