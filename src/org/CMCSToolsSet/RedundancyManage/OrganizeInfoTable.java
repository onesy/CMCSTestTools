package org.CMCSToolsSet.RedundancyManage;

import java.util.ArrayList;
import java.util.HashMap;

public class OrganizeInfoTable {
	
	private static OrganizeInfoTable organizeInfo = null;
	
	private static HashMap<String, ArrayList<NodeInfo>> magicToNodeOrganization = null;
	
	private OrganizeInfoTable() {
		// TODO Auto-generated constructor stub
		OrganizeInfoTable.setMagicToNodeOrganization(new HashMap<String, ArrayList<NodeInfo>>());
	}
	
	public synchronized static OrganizeInfoTable getInstance(){
		if(OrganizeInfoTable.organizeInfo == null)
			OrganizeInfoTable.organizeInfo = new OrganizeInfoTable();
		return OrganizeInfoTable.organizeInfo;
	}

	public static HashMap<String, ArrayList<NodeInfo>> getMagicToNodeOrganization() {
		return magicToNodeOrganization;
	}

	public static void setMagicToNodeOrganization(
			HashMap<String, ArrayList<NodeInfo>> magicToNodeOrganization) {
		OrganizeInfoTable.magicToNodeOrganization = magicToNodeOrganization;
	}

}
