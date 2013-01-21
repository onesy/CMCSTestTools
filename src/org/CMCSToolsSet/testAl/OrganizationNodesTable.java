package org.CMCSToolsSet.testAl;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


public class OrganizationNodesTable {
	
	private static OrganizationNodesTable OrganizationNodesTableI = null;
	/**
	 * key就是magic，magic就是一个hash code
	 */
	private static ConcurrentHashMap<String, ArrayList<NodeInfo>> MagicToNodeInfo_Table = null;
	
	private OrganizationNodesTable(){
		OrganizationNodesTable.setMagicToNodeInfo_Table(new ConcurrentHashMap<String, ArrayList<NodeInfo>>());
	}
	
	public synchronized static OrganizationNodesTable getInstance(){
		if(OrganizationNodesTableI == null)
			OrganizationNodesTableI = new OrganizationNodesTable();
		return OrganizationNodesTableI;
	}

	public static ConcurrentHashMap<String, ArrayList<NodeInfo>> getMagicToNodeInfo_Table() {
		if(MagicToNodeInfo_Table == null)
			MagicToNodeInfo_Table = new ConcurrentHashMap<String, ArrayList<NodeInfo>>();
		return MagicToNodeInfo_Table;
	}

	public static void setMagicToNodeInfo_Table(ConcurrentHashMap<String, ArrayList<NodeInfo>> magicToNodeInfo_Table) {
		OrganizationNodesTable.MagicToNodeInfo_Table = magicToNodeInfo_Table;
	}

}
