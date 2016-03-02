package example.zookeeper.api;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class GetDataSyn implements Watcher{
	
	private static ZooKeeper zookeeper;
	
	public static void main(String[] args) {
		String connectString = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		int sessionTimeout = 5000;
		try {
			zookeeper = new ZooKeeper(connectString, sessionTimeout, new GetDataSyn());
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
					try {
						Stat stat = new Stat();
						byte[] retArr = zookeeper.getData("/", true, stat);
						System.out.println("stat:" + stat);
						System.out.println("return byte[]: " + new String(retArr));
					} catch (KeeperException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
			Stat stat = new Stat();
			byte[] reByteArr = zooKeeper.getData(path, true, stat);
			System.out.println("do somethine stat: " + stat);
			System.out.println("do somethine return byte[]: " + new String(reByteArr));
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
