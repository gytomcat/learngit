package cn.com.faw.crowdsourcing.common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ORM对象基类, 提供常用的字段及方法
 * 
 * @author zbq
 */
public class BaseModel {

	/**
	 * ID: 无(-1)
	 */
	public static final long NONE_ID = -1L;

	/**
	 * Y.是, N.否
	 */
	public static final String YES = "Y";
	public static final String NO = "N";

	/**
	 * 状态: Y.可用, N.不可用
	 */
	public static final String ABLED = "Y";
	public static final String DISABLED = "N";

	/**
	 * 正负因子: 1.加, -1:减
	 */
	public static final int FACTOR_PLUS = 1;
	public static final int FACTOR_MINUS = -1;

	// ID(Column: ID)
	private Long id;

	// 创建时间(Column: CREATE_TIME)
	@JsonIgnore
	private Date createTime;

	// 更新时间(Column: UPDATE_TIME)
	@JsonIgnore
	private Date updateTime;

	// 是否有效,Y:有效,N:无效,默认N(Column: ENABLED)
	@JsonIgnore
	private String enabled;

	// 数量
	protected Integer interval;

	/**
	 * 无参构造
	 */
	public BaseModel() {
	}

	/**
	 * 根据增量参数构造
	 */
	public BaseModel(Long id, boolean increase) {
		this.id = id;
		this.interval = increase ? 1 : -1;
	}

	/**
	 * 获取ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取是否有效,Y:有效,N:无效,默认N
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * 设置是否有效,Y:有效,N:无效,默认N
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
