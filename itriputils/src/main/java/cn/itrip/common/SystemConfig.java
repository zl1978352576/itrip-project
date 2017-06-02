package cn.itrip.common;
/**
 * SystemConfig
 * @author hanlu
 *
 */
public class SystemConfig {

	/**
	 * 文件上传路径，通过properties文件进行配置
	 */
	private String fileUploadPathString;
	/**
	 * 上传文件访问URL，通过properties文件进行配置
	 */
	private String visitImgUrlString;
	/**
	 * 生成订单的机器码，通过properties文件进行配置
	 */
	private String machineCode;

	private String orderProcessOK;

	private String orderProcessCancel;

	/**
	 * 云通信短信平台账户Account Sid
	 */
	private String smsAccountSid;
	/**
	 * 云通信短信平台账户Auth Toke
	 */
	private String smsAuthToken;
	/**
	 * 云通信短信平台账户App ID
	 */
	private String smsAppID;
	/**
	 * 云通信短信平台Server IP
	 */
	private String smsServerIP;
	/**
	 * 云通信短信平台Server Port
	 */
	private String smsServerPort;

	public String getSmsAccountSid() {
		return smsAccountSid;
	}

	public void setSmsAccountSid(String smsAccountSid) {
		this.smsAccountSid = smsAccountSid;
	}

	public String getSmsAuthToken() {
		return smsAuthToken;
	}

	public void setSmsAuthToken(String smsAuthToken) {
		this.smsAuthToken = smsAuthToken;
	}

	public String getSmsAppID() {
		return smsAppID;
	}

	public void setSmsAppID(String smsAppID) {
		this.smsAppID = smsAppID;
	}

	public String getSmsServerIP() {
		return smsServerIP;
	}

	public void setSmsServerIP(String smsServerIP) {
		this.smsServerIP = smsServerIP;
	}

	public String getSmsServerPort() {
		return smsServerPort;
	}

	public void setSmsServerPort(String smsServerPort) {
		this.smsServerPort = smsServerPort;
	}

	public String getOrderProcessOK() {
		return orderProcessOK;
	}

	public void setOrderProcessOK(String orderProcessOK) {
		this.orderProcessOK = orderProcessOK;
	}

	public String getOrderProcessCancel() {
		return orderProcessCancel;
	}

	public void setOrderProcessCancel(String orderProcessCancel) {
		this.orderProcessCancel = orderProcessCancel;
	}

	public String getMachineCode() {
		return machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}

	public String getVisitImgUrlString() {
		return visitImgUrlString;
	}

	public void setVisitImgUrlString(String visitImgUrlString) {
		this.visitImgUrlString = visitImgUrlString;
	}

	public String getFileUploadPathString() {
		return fileUploadPathString;
	}

	public void setFileUploadPathString(String fileUploadPathString) {
		this.fileUploadPathString = fileUploadPathString;
	}
	
	
	
}
