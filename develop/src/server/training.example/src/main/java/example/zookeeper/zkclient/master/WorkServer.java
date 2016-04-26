package example.zookeeper.zkclient.master;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;


public class WorkServer {
	
	
	private ServerData masterData;//master server的运行时data
	private ServerData runningData;//当前server的运行时data
	
	private ZkClient zklient;
	
	private String MASTER_PATH = "";
	
	private IZkDataListener dataListener;
	
	
	
	public void stop(){
		
	}
	
	//争当master
	private boolean takeMaster(){
		
		return false;
	}

	
}
