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
	
	public ArrayList<HashNode> initConsistentHash(ArrayList<String> contents){
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
	
	public static ArrayList<HashNode> sort(ArrayList<HashNode> hna){
		return null;
	}

	private static void LikedFull(ArrayList<HashNode> hna) {
		HashNode hn = hna.get(0);
		hn.isStartNode = true;
		hn.pre_node = hn;
		for (int i = 0; i < hna.size(); i++) {
			hn.Next_node = hna.get(i + 1);
			hn.Next_node.pre_node = hn;
			hn = hn.Next_node;
		}
	}

}
