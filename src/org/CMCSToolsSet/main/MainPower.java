package org.CMCSToolsSet.main;

public class MainPower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String teststr = "this\r\r\n\n\r\r\n\nis";
		String[] strarr = teststr.split("\r\r\n\n");
		
		for(int i = 0; i < strarr.length ; i ++){
			if(strarr[i].equals(""))
				System.err.println("empty string!");
			System.out.println(strarr[i]);
		}
		String spli = "\r\r\n\n";
		System.err.println(spli.length());
	}

}
