package example.zookeeper.zkclient.master;

import java.io.Serializable;

public class ServerData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6445098953446507856L;

	private String serverName ;
	private String czid;
	
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getCzid() {
		return czid;
	}
	public void setCzid(String czid) {
		this.czid = czid;
	}
	
	
	
}
	