package org.CMCSToolsSet.OrdersConstructors;

import org.CMCSToolsSet.Configure.SolidConfigure;

public abstract class OrderBase {

	@SuppressWarnings("unused")
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
		String[] params = msg.split(SolidConfigure.PaxosOrderSplitor);
		// 处理结尾的content中的\r\r\n\n
		for (int i = 15; i < params.length; i++) {
			content += params[i] + SolidConfigure.PaxosOrderSplitor;
		}
		content = content.substring(0, content.length() - 4);
		this.setHost(params[1]);
		this.setPort(Integer.parseInt(params[2]));
		this.setPasswd(params[3]);
		this.setIncreamentNo(Long.parseLong(params[4]));
		this.setCategory(params[5]);
		this.setContent(content);
		//预备位置不做处理今后如有需要需要进行调整
	}

	public abstract void Process(String content);

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public long getIncreamentNo() {
		return increamentNo;
	}

	public void setIncreamentNo(long increamentNo) {
		this.increamentNo = increamentNo;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
