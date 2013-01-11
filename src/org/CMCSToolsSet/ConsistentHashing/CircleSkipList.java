package org.CMCSToolsSet.ConsistentHashing;

import java.util.ArrayList;

public class CircleSkipList {
	
	private volatile static CircleSkipList circleSkipList = null;
	
	private ArrayList<HashNode> CircleSpace = new ArrayList<HashNode>();
	
	public static CircleSkipList getInstance(int length, long[] HashArray){
		if (null == circleSkipList) {
			synchronized (circleSkipList) {
				if(null != circleSkipList){
					circleSkipList = new CircleSkipList(length,HashArray);
				}
			}
		}
		return circleSkipList;
	}
	
	private CircleSkipList(int length, long[] HashArray){
		//initial the first node we call it "start node" also "node0" but is is not the 
		this.CircleSpace.add(new HashNode(0, "start", true));
		
		for(int i = 0;i < length; i ++){
			HashNode hn = new HashNode(HashArray[i], "body" + i, false);
			this.CircleSpace.add(hn);
			if(CircleSpace.get(i).isStartNode){
				CircleSpace.get(i).Next = hn;
				CircleSpace.get(i + 1).pre_node = CircleSpace.get(i);
			}
		}
	}
	
	

}
