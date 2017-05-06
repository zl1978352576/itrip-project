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
