package org.CMCSToolsSet.ConsistentHashing;

public class HashNode <T> {
	
	/**
	 * next 4th node
	 */
	public HashNode<T> Next4thNode = null;
	/**
	 * next 3rd node
	 */
	public HashNode<T> Next3rdNode = null;
	/**
	 * next 2nd node
	 */
	public HashNode<T> Next2ndNode = null;
	/**
	 * next node
	 */
	public HashNode<T> Next = null;
	/**
	 * pre_node,cause the delete operation need it 
	 * 
	 */
	public HashNode<T> pre_node = null;
	/**
	 * is this node the start node?
	 */
	public boolean isStartNode = false;
	
	public T Contained = null;

}
