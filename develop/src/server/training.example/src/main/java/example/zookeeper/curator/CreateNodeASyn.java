package example.zookeeper.curator;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

import com.ibm.db2.jcc.a.e;

import example.zookeeper.api.ZKCommons;

public class CreateNodeASyn {
	
	public static void main(String[] args) {
		
		/*
		 * 在curator中，CuratorFramework作为zookeeper的client接口
		 */
		String connectString = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(5000, 3);
		
//		CuratorFrameworkFactory.newClient(connectString, 5000, 5000, retryPolicy);
		
		CuratorFramework client = CuratorFrameworkFactory
				.builder()
				.connectString(connectString)
				.sessionTimeoutMs(5000)
				.connectionTimeoutMs(5000)
				.retryPolicy(retryPolicy)
				.build();
		
		client.start();

		try {
			States stat = client.getZookeeperClient().getZooKeeper().getState();
//			CuratorFrameworkState stat = client.getState();
			System.out.println("zookeeper connect stat:" + stat);
			
//			String path = client.create().forPath("/node_01", "123".getBytes());
			
			
			
//			List<ACL> aclList = new ArrayList<ACL>();
//			ACL worldAcl = new ACL(Perms.ALL, Ids.ANYONE_ID_UNSAFE);
//			aclList.add(worldAcl);
//			String path = client.create()
//							.withMode(CreateMode.EPHEMERAL)
//							.withACL(aclList )
//							.forPath("/node_02", "123".getBytes());
			
			doSomething(client);
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void doSomething(CuratorFramework client) throws Exception{
		System.out.println(client.getZookeeperClient().getZooKeeper().getState());
		BackgroundCallback callback = new BackgroundCallback() {
			
			@Override
			public void processResult(CuratorFramework client, CuratorEvent event)
					throws Exception {
//				byte[] data = event.getData();
//				Stat stat = event.getStat();
//				KeeperState keeperStat = event.getWatchedEvent().getState();
//				System.out.println("keeperStat=" + keeperStat);
//				System.out.println("data=" + new String(data));
//				System.out.println("Stat=" + stat);
				String path = event.getPath();
				System.out.println(path);
				System.out.println(event.getContext());
				System.out.println(event.getResultCode());
				System.out.println(event.getType());
				
			}
		};
		Executor executor = Executors.newFixedThreadPool(1);
		
		client.create().withMode(CreateMode.EPHEMERAL).inBackground(callback, "context data", executor).forPath("/node_01", "123".getBytes());
	}
	
}
