package org.CMCSToolsSet.RedundancyManage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import sun.security.util.BigInt;

public class NodeSet {

	public static HashMap<BigInt, ArrayList<NodeInfo>> SliceOfNodes = null;

	private static NodeSet NodeSetOfCluster = null;

	public static void InitialNodeSt() {
		/**
		 * 初始化OrganizeInfoTable(必须)
		 */
		
		/**
		 * 
		 * 读取配置文件，寻找依赖关系 1.找到那些是同组的
		 * 
		 */

	}

	/**
	 * nodeInfo.getMagicStr() + nodeInfo.getPort() + nodeInfo.getChannel() +
	 * nodeInfo.getDB() 剔除 host 相关
	 * 
	 * @param nodeInfo
	 * @return
	 */
	public static String getSignStr4MD5(NodeInfo nodeInfo) {
		return nodeInfo.getMagicStr() + nodeInfo.getPort()
				+ nodeInfo.getChannel() + nodeInfo.getDB();
	}

	public synchronized static NodeSet getInstance() {
		if (null == NodeSetOfCluster) {
			NodeSet.NodeSetOfCluster = new NodeSet();
		}
		return NodeSet.NodeSetOfCluster;
	}

	private NodeSet() {

		SliceOfNodes = new HashMap<BigInt, ArrayList<NodeInfo>>();

	}

	/**
	 * the nodes who have same host+port+Channel+DB will recover each other.
	 * 包装private setNode()
	 * 
	 * @param nodeInfo
	 */
	public static void addNode(NodeInfo nodeInfo) {
		// 首先，计算MD5，找到指定的那个“组”
		// Host+port+Channel+Db
		setNode(nodeInfo.getHost(), nodeInfo.getPort(), nodeInfo.getChannel(),
				nodeInfo.getDB(), nodeInfo.getRedundancyNumber(),
				nodeInfo.getMagicStr(), 0);

	}

	/**
	 * 包装private setNode()
	 * 
	 * @param nodeInfo
	 */
	public static void delNode(NodeInfo nodeInfo) {
		setNode(null, 0, null, 0, nodeInfo.getRedundancyNumber(),
				nodeInfo.getMagicStr(), 0);
	}

	/**
	 * 包装private setNode()
	 * 
	 * @param nodeInfo
	 */
	public static void setNode(NodeInfo nodeInfo) {
		setNode(nodeInfo.getHost(), nodeInfo.getPort(), nodeInfo.getChannel(),
				nodeInfo.getDB(), nodeInfo.getRedundancyNumber(),
				nodeInfo.getMagicStr(), 0);
	}

	/**
	 * 如果节点已经废掉或者无法通过检查，将会返回空
	 * 
	 * @param host
	 * @param port
	 * @param Channel
	 * @param Db
	 * @param RedundancyNumber
	 * @return NodeInfo or null
	 */
	public static NodeInfo getNode(String host, int port, String Channel,
			int Db, int RedundancyNumber, String magic) {
		BigInt MD5FLocation = calculateMD5(magic, port, Channel, Db,
				RedundancyNumber);
		NodeInfo newni = NodeSet.SliceOfNodes.get(MD5FLocation).get(
				RedundancyNumber);
		if (checkNode(newni)) {
			return newni;
		}
		return null;
	}
	
	public static ArrayList<NodeInfo> getOrganize(String magicStr){
		return null;
	}

	private static void setNode(String host, int port, String Channel, int Db,
			int RedundancyNumber, String magic, int VirtualNodeCount) {
		BigInt MD5FLocation = calculateMD5(magic, port, Channel, Db,
				RedundancyNumber);
		ArrayList<NodeInfo> NIarr = NodeSet.SliceOfNodes.get(MD5FLocation);
		NodeInfo newNi = new NodeInfo(host, port, Channel, Db,
				RedundancyNumber, magic, VirtualNodeCount);
		try {
			NIarr.set(RedundancyNumber, newNi);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.err.println("‘组’没有那么长！请检查配置");
		}
	}

	/**
	 * 检查一个节点是否可用
	 * 
	 * @param nodeInfo
	 * @return
	 */
	public static boolean checkNode(NodeInfo nodeInfo) {
		if (nodeInfo.getHost() != null && nodeInfo.getPort() != 0
				&& nodeInfo.getChannel() != null && nodeInfo.getDB() != 0
				&& NodeInfo.VirtualNodeCount != 0
				&& nodeInfo.getMagicStr() != null)
			return true;

		return false;
	}

	public static BigInt calculateMD5(String magic, int port, String Channel,
			int Db, int RedundancyNumber) {
		String SRCStr = magic + port + Channel + Db;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md5.update(SRCStr.getBytes());
		byte[] result = md5.digest();
		BigInt bd = new BigInt(result);
		return bd;
	}

	public static BigInt calculateMD5(NodeInfo nodeInfo) {
		String SRCStr = getSignStr4MD5(nodeInfo);
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md5.update(SRCStr.getBytes());
		byte[] result = md5.digest();
		BigInt bd = new BigInt(result);
		return bd;
	}

}
