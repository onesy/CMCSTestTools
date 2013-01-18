package org.CMCSToolsSet.ConsistentHashing;

import sun.security.util.BigInt;

public class HashNode {

	/**
	 * next node
	 */
	public HashNode Next_node = null;
	/**
	 * is this node the start node?
	 */
	public boolean isStartNode = false;
	/**
	 * hashNumber 
	 */
	public BigInt hashNumber = null;
	
	public String Contained = null;
	
	public HashNode(BigInt hashNumber, String Contained, boolean isStart){
		this.hashNumber = hashNumber;
		this.Contained = Contained;
		this.isStartNode = isStart;
	}

}
