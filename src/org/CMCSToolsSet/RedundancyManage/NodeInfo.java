package org.CMCSToolsSet.RedundancyManage;

public class NodeInfo {
	
	public static int VirtualNodeCount = 0;
	
	private String host = null;
	
	private int port = 0;
	
	private String Channel = null;
	
	private int DB = 0;
	
	private int redundancyNumber = 0;
	
	public NodeInfo(String host, int port, String Channel, int DB, int redundancyNumber, int VirtualNodeCount){
		
		this.setHost(host);
		
		this.setPort(port);
		
		this.setChannel(Channel);
		
		this.setDB(DB);
		
		this.setRedundancyNumber(redundancyNumber);
		
		if(VirtualNodeCount != 0)
			NodeInfo.VirtualNodeCount = VirtualNodeCount;
		
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public int getDB() {
		return DB;
	}

	public void setDB(int dB) {
		DB = dB;
	}

	public int getRedundancyNumber() {
		return redundancyNumber;
	}

	public void setRedundancyNumber(int redundancyNumber) {
		this.redundancyNumber = redundancyNumber;
	}

}
