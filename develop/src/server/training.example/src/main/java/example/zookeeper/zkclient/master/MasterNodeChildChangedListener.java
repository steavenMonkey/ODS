package example.zookeeper.zkclient.master;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

public class MasterNodeChildChangedListener implements IZkChildListener{
	
	private ZkClient zkClient;
	
	public MasterNodeChildChangedListener(ZkClient zkClient) {
		super();
		this.zkClient = zkClient;
	}



	@Override
	public void handleChildChange(String parentPath, List<String> currentChilds)
			throws Exception {
		
			
	}

}
