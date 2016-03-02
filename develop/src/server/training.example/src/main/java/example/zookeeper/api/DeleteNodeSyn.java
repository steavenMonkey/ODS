package example.zookeeper.api;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class DeleteNodeSyn implements Watcher{
	
	private static ZooKeeper zookeeper;
	
	public static void main(String[] args) {
		String connectString = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		int sessionTimeout = 5000;
		try {
			zookeeper = new ZooKeeper(connectString, sessionTimeout, new DeleteNodeSyn());
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
//				if(event.getType() == EventType.NodeChildrenChanged){
//					try {
//						List<String> subList = zookeeper.getChildren("/", false);/*一个watch只能使用一次，如果想再次使用则需要再次注册*/
//						System.out.println(subList);
//					} catch (KeeperException e) {
//						e.printStackTrace();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
			}
		}
		
		
	}
	
	private void doSomething(ZooKeeper zooKeeper){
		/*
		 * 同步调用创建节点接口
		 */
		System.out.println("clinet connected zookeeper, now is do something");
		String path = "/node_01";
		try {
			// version为－1表示不校验版本号
			zooKeeper.delete(path, -1);
			System.out.println("delete " + path + "success");
		} catch (InterruptedException | KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
