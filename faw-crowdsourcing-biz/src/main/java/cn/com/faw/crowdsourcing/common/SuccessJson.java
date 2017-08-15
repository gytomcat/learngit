package cn.com.faw.crowdsourcing.common;


/**
 * 操作成功返回信息
 * 
 * @author zbq
 */
public class SuccessJson extends BaseJson {

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "success"
	 * }
	 * </pre>
	 */
	public SuccessJson() {
		super(STATUS_SUCCESS);
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "success",
	 *     message: 自定义提示信息或数据
	 * }
	 * </pre>
	 * 
	 * @param message 错误信息
	 */
	public SuccessJson(String message) {
		super(STATUS_SUCCESS, message);
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "success",
	 *     number: 自定义数字(可以返回主键等)
	 * }
	 * </pre>
	 * 
	 * @param message 错误信息
	 */
	public SuccessJson(Number number) {
		super(STATUS_SUCCESS, String.valueOf(number));
	}

	/**
	 * 构造函数
	 * 
	 * <pre>
	 * 返回信息包括
	 * {
	 *     status: "success",
	 *     message: 自定义提示信息或数据
	 * }
	 * </pre>
	 * 
	 * @param message 错误信息
	 */
	public SuccessJson(Object data) {
		super(STATUS_SUCCESS, data);
	}

}
