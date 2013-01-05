package org.CMCSToolsSet.TestProcesses;

import org.CMCSToolsSet.Configure.SolidConfigure;

public class TestConfirm extends TestBase {

	public void process() {
		
	}
	
	public String OrderStr(String Category){
		String order = "PAXOS_BABY" + SolidConfigure.PaxosMsgSplitor
				+ "127.0.0.1" + SolidConfigure.PaxosMsgSplitor + "6379"
				+ SolidConfigure.PaxosMsgSplitor + "none"
				+ SolidConfigure.PaxosMsgSplitor + "1"
				+ SolidConfigure.PaxosMsgSplitor + Category
				+ SolidConfigure.PaxosMsgSplitor + "backup0"
				+ SolidConfigure.PaxosMsgSplitor + "backup1"
				+ SolidConfigure.PaxosMsgSplitor + "backup2"
				+ SolidConfigure.PaxosMsgSplitor + "backup3"
				+ SolidConfigure.PaxosMsgSplitor + "backup4"
				+ SolidConfigure.PaxosMsgSplitor + "backup5"
				+ SolidConfigure.PaxosMsgSplitor + "backup6"
				+ SolidConfigure.PaxosMsgSplitor + "backup7"
				+ SolidConfigure.PaxosMsgSplitor + "backup8"
				+ SolidConfigure.PaxosMsgSplitor + "{ther is nothing}";
		return order;
	}

	public TestConfirm() {
		super();
	}

	public void testGo() {
		super.testGo();
	}

}
