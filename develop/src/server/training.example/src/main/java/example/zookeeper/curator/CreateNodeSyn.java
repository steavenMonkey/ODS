package example.zookeeper.curator;

import java.util.ArrayList;
import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.AfterConnectionEstablished;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.ACL;

import example.zookeeper.api.ZKCommons;

public class CreateNodeSyn {
	
	public static void main(String[] args) throws Exception {
		
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
		AfterConnectionEstablished.execute(client, new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
		
		try {
			States stat = client.getZookeeperClient().getZooKeeper().getState();
//			CuratorFrameworkState stat = client.getState();
			System.out.println("zookeeper connect stat:" + stat);
			
//			String path = client.create().forPath("/node_01", "123".getBytes());
			
			
			
			List<ACL> aclList = new ArrayList<ACL>();
			ACL worldAcl = new ACL(Perms.ALL, Ids.ANYONE_ID_UNSAFE);
			aclList.add(worldAcl);
			String path = client.create()
							.withMode(CreateMode.EPHEMERAL)
							.withACL(aclList )
							.forPath("/node_02", "123".getBytes());
			
			
			System.out.println("create node success,the node path:" + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
}
