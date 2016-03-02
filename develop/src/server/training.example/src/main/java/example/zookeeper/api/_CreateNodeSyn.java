package example.zookeeper.api;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

public class _CreateNodeSyn implements Watcher{
	
	private ZooKeeper zookeeper;
	
	public void createSession(){
		String connectString = ZKCommons.ZK_SERVER_IP + ":" + ZKCommons.ZK_SERVER_PORT;
		int sessionTimeout = 5000;
		Watcher watcher  = new _CreateNodeSyn();
		try {
			zookeeper = new ZooKeeper(connectString, sessionTimeout, watcher);
//			System.out.println(zookeeper.getState());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 同步调用创建节点的API
	 * 并且设置节点访问权限
	 * zookeeper的权限控制只能对指定节点有效，对其子节点或父节点无效
	 */
	public void createNodeSyn(WatchedEvent event){
			try {
			/*
			 * path：节点路径，根节点为/
			 * data: 节点的数据内容
			 * acl：权限控制列表，一共有create，read，write，delete，admin5种权限，针对不同的作用域，可以是
			 * world，auth，digest，ip
			 * */
			String path = "/node_01";
			byte[] data = "123".getBytes();
			List<ACL> aclList = new ArrayList<ACL>();
			/*
			 * Id －－》schema：id
			 * world:anyone
			 * auth:null
			 * digest:Base64(SHA1(username:passworld))
			 * ip:192.168.21.106
			 * 
			 */
			Id worldId = new Id("world", "anyone");
			ACL worldAcl = new ACL(Perms.ALL, worldId );
			
			Id authId = new Id("auth", null);//面向所有有权限的用户
			ACL authAcl = new ACL(Perms.ALL, authId);
			
			Id digestId = new Id("digest", DigestAuthenticationProvider.generateDigest("weixin:000000"));
			ACL digestAcl = new ACL(Perms.ALL, digestId);
			
			Id ipId = new Id("ip", ZKCommons.ZK_SERVER_IP);
			ACL ipIAcl = new ACL(Perms.ALL, ipId);
			
//			aclList.add(digestAcl);
//			aclList.add(ipIAcl);
//			aclList.add(authAcl);
			aclList.add(worldAcl);
			KeeperState state = event.getState();
			if(state.equals(KeeperState.SyncConnected)){
				System.out.println(state);
				zookeeper.delete(path, -1);
			}
			
			CreateMode createMode = CreateMode.EPHEMERAL;//临时节点
//				zookeeper.create(path, data, aclList, CreateMode.EPHEMERAL);
			} catch (KeeperException | InterruptedException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

	@Override
	public void process(WatchedEvent event) {

		System.out.println(event);
		System.out.println("get connect process event, event state:" + event.getState());
		doSomething(event);
		
	}
	
	private void doSomething(WatchedEvent event){
		createNodeSyn(event);
	}
	
	
	
	public static void main(String[] args) {
		_CreateNodeSyn session = new _CreateNodeSyn();
		session.createSession();
//		session.createNodeSyn();
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
