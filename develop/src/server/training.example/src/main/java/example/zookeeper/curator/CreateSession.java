package example.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.AfterConnectionEstablished;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

import example.zookeeper.api.ZKCommons;

public class CreateSession {
	
	public static void main(String[] args) {
		
		/*
		 * 在curator中，CuratorFramework作为zookeeper的client接口
		 */
		String connectString = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(5000, 3);
		
//		CuratorFrameworkFactory.newClient(connectString, 5000, 5000, retryPolicy);
		
		final CuratorFramework client = CuratorFrameworkFactory
				.builder()
				.connectString(connectString)
				.sessionTimeoutMs(5000)
				.connectionTimeoutMs(5000)
				.retryPolicy(retryPolicy)
				.build();
		
		client.start();
		try {
			AfterConnectionEstablished.execute(client, new Runnable() {
				
				
				@Override
				public void run() {
					try {
						Stat stat = new Stat();
						byte[] data = client.getData().storingStatIn(stat).forPath("/");
						System.out.println(new String(data));
						System.out.println(stat);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("do something after get connect");
				}
			});
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			States stat = client.getZookeeperClient().getZooKeeper().getState();
//			CuratorFrameworkState stat = client.getState();
			System.out.println(stat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
}
