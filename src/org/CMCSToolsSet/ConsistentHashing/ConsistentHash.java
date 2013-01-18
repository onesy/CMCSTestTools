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
		tmp = sort(tmp);
		return tmp;
	}

	/**
	 * 注：由于几乎没有可能键值重复，所以相等的情况就不用考虑。由于对性能要求不高，所以冒泡排序即可，如果性能要求高可以使用平衡树
	 * 
	 * @param hna
	 * @return
	 */
	public static ArrayList<HashNode> sort(ArrayList<HashNode> hna) {

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

	public static HashNode findResponseOne(BigInt hashNumber) {
		int NodeCount = ConsistentHash.CircledoubleLinkedList.size();
		int startNode = 0;
		int step = 4;
		for (;;) {
			if (startNode + step < NodeCount) {
				if (ConsistentHash.CircledoubleLinkedList.get(startNode + step).hashNumber
						.toBigInteger().compareTo(hashNumber.toBigInteger()) < 0) {
					startNode += step;
				} else {
					if (step != 1)
						step = step / 2;
					else
						return ConsistentHash.CircledoubleLinkedList
								.get(startNode + step);
				}
			} else {
				if (ConsistentHash.CircledoubleLinkedList.get(NodeCount).hashNumber
						.toBigInteger().compareTo(hashNumber.toBigInteger()) < 0) {
					return ConsistentHash.CircledoubleLinkedList.get(0);
				} else {
					if (step != 1)
						step = step / 2;
					else
						return ConsistentHash.CircledoubleLinkedList
								.get(startNode + step);
				}
			}
		}
	}

	private static void LikedFull(ArrayList<HashNode> hna) {

	}

}
