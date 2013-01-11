package org.CMCSToolsSet.ConsistentHashing;

public class HashNode {
	
	/**
	 * next 4th node
	 */
	public HashNode Next4thNode = null;
	/**
	 * next 3rd node
	 */
	public HashNode Next3rdNode = null;
	/**
	 * next 2nd node
	 */
	public HashNode Next2ndNode = null;
	/**
	 * next node
	 */
	public HashNode Next = null;
	/**
	 * pre_node,cause the delete operation need it 
	 * 
	 */
	public HashNode pre_node = null;
	/**
	 * is this node the start node?
	 */
	public boolean isStartNode = false;
	
	public long hashNumber = 0;
	
	public String Contained = null;
	
	public HashNode(long hashNumber, String Contained, boolean isStart){
		this.hashNumber = hashNumber;
		this.Contained = Contained;
		this.isStartNode = isStart;
	}

}
