package example.zookeeper.zkclient;

import java.util.concurrent.TimeUnit;

import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import example.zookeeper.api.ZKCommons;

public class CreateSession {
	public static void main(String[] args) {
		String zkServers = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		int sessionTimeout = 5000;
		int connectionTimeout = 5000;
		ZkClient client = new ZkClient(zkServers, sessionTimeout, connectionTimeout);
		System.out.println("zkclient connected");
		System.out.println(client.waitForKeeperState(KeeperState.SyncConnected, 5, TimeUnit.SECONDS));
		
		client.subscribeStateChanges(new IZkStateListener() {
			
			@Override
			public void handleStateChanged(KeeperState state) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("session state changed, state=" + state);
			}
			
			@Override
			public void handleSessionEstablishmentError(Throwable error)
					throws Exception {
				// TODO Auto-generated method stub
				System.out.println("new session establish error");
			}
			
			@Override
			public void handleNewSession() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("new session create");
			}
		});
		
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
