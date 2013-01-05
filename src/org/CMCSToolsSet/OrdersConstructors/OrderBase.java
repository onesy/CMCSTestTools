package org.CMCSToolsSet.OrdersConstructors;

import org.CMCSToolsSet.Configure.SolidConfigure;

public abstract class OrderBase {

	private OrderBase Activitor;

	private String host;

	private int port;

	private String passwd;

	private long increamentNo;

	private String Category;

	private String content;

	public OrderBase(String msg) {
		OrderAnalasy(msg);
	}

	/**
	 * :: = \r\r\n\n paxos message =
	 * PAXOS_BABY::host::port::password::increamentNo
	 * ::Category::backup0::backup1::backup2
	 * ::backup3::backup4::backup5::backup6::backup7::backup8::content content =
	 * {.....}
	 * 
	 */

	public void OrderAnalasy(String msg) {
		String content = "";
		String[] params = msg.split(SolidConfigure.PaxosMsgSplitor);
		// 处理结尾的content中的\r\r\n\n
		for (int i = 15; i < params.length; i++) {
			content += params[i] + SolidConfigure.PaxosMsgSplitor;
		}
		content = content.substring(0, content.length() - 4);
		this.host = params[1];
		this.port = Integer.parseInt(params[2]);
		this.passwd = params[3];
		this.increamentNo = Long.parseLong(params[4]);
		this.Category = params[5];
		this.content = content;
		//预备位置不做处理今后如有需要需要进行调整
	}

	public abstract void Process(String content);
}
