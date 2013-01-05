package org.CMCSToolsSet.TestProcesses;

public abstract class TestBase {
	
	public TestBase(){
		//do something
	}
	
	public final void testGo(){
		this.process();
	}
	
	public abstract void process();

}
