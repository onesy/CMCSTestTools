package org.CMCSToolsSet.TestProcesses;

import org.CMCSToolsSet.Configure.SolidConfigure;
import org.CMCSToolsSet.OrdersConstructors.OrderBase;
import org.apache.commons.lang3.ArrayUtils;

public class TestConfirm extends TestBase {
	
	public void process() {

		String orderStr = this.OrderStr("127.0.0.1", 6379, SolidConfigure.NONE, 0, "Confirm",
				null);
		TestUnit(super.getInstance("Confirm", orderStr));

	}
	
	public void TestUnit(OrderBase orderBase){
		//test here!
		System.err.println(orderBase.getHost());
		System.err.println(orderBase.getCategory());
		System.err.println(orderBase.getContent());
	}
	

	public String[] BakUpFiller(String[] contents) {
		int contenlength ;
		String [] filler;
		if (contents == null) {
			contenlength = 0;
		}else{
			contenlength = contents.length;
		}
		filler = new String [9 - contenlength];
		for (int i = 0; i < filler.length; i++) {
			filler[i] = SolidConfigure.BakUpFiller;
		}
		return ArrayUtils.addAll(contents, filler);
	}

	public String OrderStr(String host, int port, String passwd,
			long increamentNo, String Category, String[] bakups) {
		if(bakups == null){
			bakups = BakUpFiller(bakups);
		}
		String order = SolidConfigure.OrderHead
				+ SolidConfigure.PaxosOrderSplitor + host
				+ SolidConfigure.PaxosOrderSplitor + port
				+ SolidConfigure.PaxosOrderSplitor + passwd
				+ SolidConfigure.PaxosOrderSplitor + increamentNo
				+ SolidConfigure.PaxosOrderSplitor + Category
				+ SolidConfigure.PaxosOrderSplitor + bakups[0]
				+ SolidConfigure.PaxosOrderSplitor + bakups[1]
				+ SolidConfigure.PaxosOrderSplitor + bakups[2]
				+ SolidConfigure.PaxosOrderSplitor + bakups[3]
				+ SolidConfigure.PaxosOrderSplitor + bakups[4]
				+ SolidConfigure.PaxosOrderSplitor + bakups[5]
				+ SolidConfigure.PaxosOrderSplitor + bakups[6]
				+ SolidConfigure.PaxosOrderSplitor + bakups[7]
				+ SolidConfigure.PaxosOrderSplitor + bakups[8]
				+ SolidConfigure.PaxosOrderSplitor + "{ther is\r\r\n\n nothing}";
		return order;
	}
}
