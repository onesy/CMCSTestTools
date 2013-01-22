package org.CMCSToolsSet.TestProcesses;

import java.util.ArrayList;

public class Arraytest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(6);
		System.out.println(al.size());
//		System.exit(0);
		for(int i = 0;i < al.size(); i ++){
			if(5 < al.get(i)){
				al.add(i, 5);
				break;
			}
		}
		
		for (int i : al) {
			System.err.println(i);
		}

	}

}
