package org.CMCSToolsSet.ConsistentHashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import sun.security.util.BigInt;

public class ConsistentHash {

	private static ArrayList<HashNode> CircledoubleLinkedList = null;

	private ConsistentHash(ArrayList<String> hna) {
		// 初始化一致性hash的爽链表
		ConsistentHash.CircledoubleLinkedList = initConsistentHash(hna);
		ConsistentHash.LikedFull(CircledoubleLinkedList);
	}
	
	private ConsistentHash(){
		initConsistentHash();
	}

	public ArrayList<HashNode> initConsistentHash(ArrayList<String> contents) {
		MessageDigest md5;
		ArrayList<HashNode> tmp = new ArrayList<HashNode>();
		for (int i = 0; i < contents.size(); i++) {
			try {
				md5 = MessageDigest.getInstance("MD5");
				md5.update(contents.get(i).getBytes());
				byte[] result = md5.digest();
				BigInt bd = new BigInt(result);
				tmp.add(new HashNode(bd, contents.get(i), false));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tmp = Sort(tmp);
		return tmp;
	}
	
	public void initConsistentHash(){
		ConsistentHash.CircledoubleLinkedList = new ArrayList<HashNode>();
	}

	/**
	 * 注：由于几乎没有可能键值重复，所以相等的情况就不用考虑。由于对性能要求不高，所以冒泡排序即可，如果性能要求高可以使用平衡树
	 * 
	 * @param hna
	 * @return
	 */
	public static ArrayList<HashNode> Sort(ArrayList<HashNode> hna) {

		ArrayList<HashNode> hnatmp = new ArrayList<HashNode>();

		for (int j = 0; j < hna.size(); j++) {
			HashNode tmpNode = null;
			for (int i = 0; i < hna.size(); i++) {
				if (null == tmpNode) {
					tmpNode = hna.get(i);
				} else {
					if (hna.get(i).hashNumber.toBigInteger().compareTo(
							tmpNode.hashNumber.toBigInteger()) > 0) {
						tmpNode = hna.get(i);
					} else {
						continue;
					}
				}
			}
			hnatmp.add(j, tmpNode);
		}

		return hnatmp;
	}

	/**
	 * 以4为步进跳跃查找
	 * 要求节点数是4的倍数
	 * @param hashNumber
	 * @return
	 */
	public static HashNode FindResponseOne(BigInt hashNumber) {
		int NodeCount = ConsistentHash.CircledoubleLinkedList.size();
		int startNode = 0;
		int step = 4;
		for (;;) {
			/**
			 * 在不会跳出整个环的情况下，进行判断，但是直觉告诉我：这里有BUG
			 */
			if (startNode + step < NodeCount) {
				if (ConsistentHash.CircledoubleLinkedList.get(startNode + step - 1).hashNumber
						.toBigInteger().compareTo(hashNumber.toBigInteger()) < 0) {
					startNode += step;
				} else {
					//目标节点在步进之内
					if (step != 1)//折半步进
						step = step / 2;
					else//就是下个节点
						return ConsistentHash.CircledoubleLinkedList
								.get(startNode + step - 1);
				}
			} else {
				if (ConsistentHash.CircledoubleLinkedList.get(NodeCount - 1).hashNumber
						.toBigInteger().compareTo(hashNumber.toBigInteger()) < 0) {
					//超出最后一个节点的
					return ConsistentHash.CircledoubleLinkedList.get(0);
				} else {
					if (step != 1)
						step = step / 2;
					else
						return ConsistentHash.CircledoubleLinkedList
								.get(startNode + step - 1);
				}
			}
		}
	}
	
	/**
	 * 查找到指定的节点
	 * @param hn
	 * @return
	 */
	public static HashNode FindTheOne(BigInt hn){
		for(int i = 0; i < ConsistentHash.CircledoubleLinkedList.size(); i ++){
			if(ConsistentHash.CircledoubleLinkedList.get(i).hashNumber.toBigInteger().compareTo(hn.toBigInteger()) == 0){
				return ConsistentHash.CircledoubleLinkedList.get(i);
			}
		}
		return null;
	}
	
	public static HashNode FindBrothers(String host, int port, String Channel, int DB, int redundancyNumber){
		
		/**
		 * TODO hash算法有待考虑。
		 * 问题如下
		 * 1. 如何才能通过已知节点找到冗余节点
		 * 2. 如何才能合适的加入虚拟节点？
		 * 答2：通常的做法是对host + number ，那么这样就需要对HashNode类进行更改，其中必须包含如下信息
		 * 1.. 这个节点是第几个冗余节点
		 * 2.. 那一个节点是真实节点
		 * 3.. 
		 * 
		 * 那么这个问题进而分裂成2个问题，所以需要有两个方法一个用于找到冗余节点，一个用于找打Virtual节点
		 * 但是找到冗余节点是找打它的虚拟节点还是真实节点？仍然是个很头疼的问题,对于这个问题，我的解法是，随机去找，找到虚拟节点的随机一个进行操作
		 */
		return null;
		
	}
	
	public static HashNode FindVirtuals(){
		return null;
	}
	
	public static void InsertNode(HashNode hn){
		for(int i = 0; i < ConsistentHash.CircledoubleLinkedList.size(); i ++){
			if(hn.hashNumber.toBigInteger().compareTo(ConsistentHash.CircledoubleLinkedList.get(i).hashNumber.toBigInteger()) > 0){
				ConsistentHash.CircledoubleLinkedList.add(i, hn);
			} else {
				continue;
			}
		}
	}
	
	public static boolean DeleteNode(BigInt hashNumber){
		for(int i = 0; i < ConsistentHash.CircledoubleLinkedList.size(); i ++){
			if(ConsistentHash.CircledoubleLinkedList.get(i).hashNumber.toBigInteger().compareTo(hashNumber.toBigInteger()) == 0){
				ConsistentHash.CircledoubleLinkedList.remove(i);
				return true;
			}
		}
		return false;
	}

	private static void LikedFull(ArrayList<HashNode> hna) {

	}

}
