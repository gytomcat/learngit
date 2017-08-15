package cn.com.faw.crowdsourcing.common;

/**
 * 操作失败返回信息
 * 
 * @author zbq
 */
public class ErrorJson extends BaseJson {

	// 错误码
	private Integer errCode;

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "error",
	 * }
	 * </pre>
	 */
	public ErrorJson() {
		super(STATUS_ERROR);
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "error",
	 *     errorCode: 自定义错误码
	 * }
	 * </pre>
	 * 
	 * @param errCode 错误码
	 */
	public ErrorJson(Integer errCode) {
		super(STATUS_ERROR);
		this.errCode = errCode;
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "error",
	 *     errorCode: 自定义错误码,
	 *     data: 自定义数据
	 * }
	 * </pre>
	 * 
	 * @param errCode 错误码
	 */
	public ErrorJson(Integer errCode, Object data) {
		super(STATUS_ERROR, data);
		this.errCode = errCode;
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "error",
	 *     message: 自定义错误信息
	 * }
	 * </pre>
	 * 
	 * @param message 错误信息
	 */
	public ErrorJson(String message) {
		super(STATUS_ERROR, message);
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "error",
	 *     message: 自定义错误信息,
	 *     data: 自定义数据
	 * }
	 * </pre>
	 * 
	 * @param message 错误信息
	 */
	public ErrorJson(String message, Object data) {
		super(STATUS_ERROR, message, data);
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "error",
	 *     errorCode: 自定义错误码,
	 *     message: 自定义错误信息
	 * }
	 * </pre>
	 * 
	 * @param errCode 错误码
	 * @param message 错误信息
	 */
	public ErrorJson(Integer errCode, String message) {
		super(STATUS_ERROR, message);
		this.errCode = errCode;
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "error",
	 *     errorCode: 自定义错误码,
	 *     message: 自定义错误信息,
	 *     data: 自定义数据
	 * }
	 * </pre>
	 * 
	 * @param errCode 错误码
	 * @param message 错误信息
	 */
	public ErrorJson(Integer errCode, String message, Object data) {
		super(STATUS_ERROR, message, data);
		this.errCode = errCode;
	}

}
