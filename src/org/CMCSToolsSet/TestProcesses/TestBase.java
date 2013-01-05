package org.CMCSToolsSet.TestProcesses;

import java.lang.reflect.InvocationTargetException;

import org.CMCSToolsSet.Configure.SolidConfigure;
import org.CMCSToolsSet.OrdersConstructors.OrderBase;

public abstract class TestBase {
	
	public TestBase(){
		//do something
	}
	
	
	@SuppressWarnings({ "finally", "unchecked" })
	public OrderBase getInstance(String classname,String orderStr){
		@SuppressWarnings("rawtypes")
		Class clazz = null;
		OrderBase orderBase = null;
		try {
			clazz = Class.forName(SolidConfigure.OdrPkgPrefix + "Confirm");
			orderBase = (OrderBase) clazz.getConstructor(String.class).newInstance(orderStr);
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
		}finally{
			return orderBase;
		}
	}
	
	public abstract void process();

}
