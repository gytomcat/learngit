package cn.com.faw.crowdsourcing.common;

/**
 * JSON返回值基类,提供返回码和返回消息
 * 
 * @author zbq
 */
public class BaseJson {

	/**
	 * 返回状态,成功/失败
	 */
	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_ERROR = "error";

	// 返回状态
	private String status;

	// 返回信息
	private String message;

	// 数据
	private Object data;

	public BaseJson(String status) {
		this.status = status;
	}

	public BaseJson(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public BaseJson(String status, Object data) {
		this.status = status;
		this.data = data;
	}

	public BaseJson(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
