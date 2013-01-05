package org.CMCSToolsSet.TestProcesses;

import java.lang.reflect.InvocationTargetException;

import org.CMCSToolsSet.Configure.SolidConfigure;
import org.CMCSToolsSet.OrdersConstructors.OrderBase;
import org.apache.commons.lang3.ArrayUtils;

public class TestConfirm extends TestBase {

	public void process() {

		String orderStr = this.OrderStr("127.0.0.1", 6379, SolidConfigure.NONE, 0, "Confirm",
				null);
		@SuppressWarnings("rawtypes")
		Class clazz = null;
		try {
			clazz = Class.forName("org.CMCSToolsSet.OrdersConstructors.Confirm");
			@SuppressWarnings("unchecked")
			OrderBase orderBase = (OrderBase) clazz.getConstructor(String.class).newInstance(orderStr);
			System.err.println(orderBase.getHost());
			System.err.println(orderBase.getContent());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
				+ SolidConfigure.PaxosOrderSplitor + "{ther is nothing}";
		return order;
	}

	public TestConfirm() {
		super();
	}

}
