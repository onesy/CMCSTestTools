package org.CMCSToolsSet.RedundancyManage;

public class NodeInfo {
	
	public static int VirtualNodeCount = 0;
	
	private String host = null;
	
	private int port = 0;
	
	private String Channel = null;
	
	private int DB = 0;
	
	private int redundancyNumber = 0;
	
	private String magicStr = null;
	
	public NodeInfo(String host, int port, String Channel, int DB, int redundancyNumber, String magicStr, int VirtualNodeCount){
		
		this.setHost(host);
		
		this.setPort(port);
		
		this.setChannel(Channel);
		
		this.setDB(DB);
		
		this.setRedundancyNumber(redundancyNumber);
		
		this.setMagicStr(magicStr);
		
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

	public String getMagicStr() {
		return magicStr;
	}

	public void setMagicStr(String magicStr) {
		this.magicStr = magicStr;
	}

}
