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
