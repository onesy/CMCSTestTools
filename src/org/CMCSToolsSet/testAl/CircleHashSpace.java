package org.CMCSToolsSet.testAl;

import java.math.BigInteger;
import java.util.ArrayList;

public class CircleHashSpace {

	private static CircleHashSpace circleHashSpace = null;

	private static ArrayList<String> MagicArray = null;

	private CircleHashSpace() {
		CircleHashSpace.setMagicArray(new ArrayList<String>());
	}

	private CircleHashSpace(ArrayList<String> magicArray) {
		CircleHashSpace.setMagicArray(magicArray);
	}

	public synchronized static CircleHashSpace getInstance() {
		if (CircleHashSpace.circleHashSpace == null)
			CircleHashSpace.circleHashSpace = new CircleHashSpace();
		return CircleHashSpace.circleHashSpace;
	}

	public synchronized static CircleHashSpace getInstance(
			ArrayList<String> magicArray) {
		if (CircleHashSpace.circleHashSpace == null
				|| CircleHashSpace.circleHashSpace
						.equals(new CircleHashSpace()))
			CircleHashSpace.circleHashSpace = new CircleHashSpace(Sort(magicArray));
		return CircleHashSpace.circleHashSpace;
	}

	public static ArrayList<String> getMagicArray() {
		return MagicArray;
	}

	public static void setMagicArray(ArrayList<String> magicArray) {
		MagicArray = magicArray;
	}

	/**
	 * 随便写个冒泡吧，别整复杂了，时间不多，时间以后再来整,反正节点也不多。。。对吧？
	 * 
	 * @param magicArray
	 * @return
	 */
	private static ArrayList<String> Sort(ArrayList<String> magicArray){
		ArrayList<String> tmpArray = new ArrayList<String>();
		for(int i = 0; i < magicArray.size(); i ++ ){
			String biggest = null;
			for(int j = 0; j < magicArray.size(); j ++){
				if(biggest == null||new BigInteger(biggest).compareTo(new BigInteger(magicArray.get(j))) < 1){
					biggest = magicArray.get(j);
				}
			}
			tmpArray.add(i, biggest);
		}
		
		return tmpArray;
		
	}
	
	public static void add(String magic){
		未完成
	}
}
