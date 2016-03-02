package example.zookeeper.api;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class GetChildrenASyn implements Watcher{
	
	private static ZooKeeper zookeeper;
	
	public static void main(String[] args) {
		String connectString = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		int sessionTimeout = 5000;
		try {
			zookeeper = new ZooKeeper(connectString, sessionTimeout, new GetChildrenASyn());
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
				if(event.getType() == EventType.NodeChildrenChanged){
					zookeeper.getChildren("/", true, new IChildren2CallBack(), "ctx");
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
		zookeeper.getChildren(path, true, new IChildren2CallBack(), "context data");
	}
	
	static class IChildren2CallBack implements AsyncCallback.Children2Callback{

		@Override
		public void processResult(int rc, String path, Object ctx,
				List<String> children, Stat stat) {

			StringBuffer sb = new StringBuffer();
			sb.append("rc=" + rc).append("\n");
			sb.append("path=" + path).append("\n");
			sb.append("ctx=" + ctx).append("\n");
			sb.append("children" + children).append("\n");
			sb.append("stat" + stat).append("\n");
			System.out.println(sb.toString());
		}
		
	}
	
}
