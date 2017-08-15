package cn.com.faw.crowdsourcing.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 数据查询分页对象,该类可以根据总条数及需要查询的页码数计算出当前页码对应的起始和截止行数
 * 
 * <pre>
 * <table>
 * <tr><th align="left">基本属性</th><th align="left">描述信息</th></tr>
 * <tr><td>totalRow</td><td>总条数,数据库查询得到设置该属性</td></tr>
 * <tr><td>currentPage</td><td>需要查询的页码,缺省为1(首页)</td></tr>
 * <tr><td>pageSize</td><td>每页显示条数,默认15条</td></tr>
 * <tr><td>totalPage</td><td>总页数,根据totalRow和pageSize计算得出()</td></tr>
 * <tr><td>StartRow</td><td>当前页开始记录位置,根据当前页码及条数计算得出</td></tr>
 * <tr><td>EndRow</td><td>当前页最后记录位置,根据当前页码及条数计算得出</td></tr>
 * <tr><td>pageList</td><td>分页显示页码数集合,根据当前页得出前后显示页码数</td></tr>
 * </table>
 * </pre>
 * <p>
 * 设置该类的<strong>总条数(totalRow)</strong>及<strong>需要查询的页码(currentPage)</strong>后<br>
 * 使用<strong>getStartRow</strong>和<strong>getEndRow</strong>方法可分别取得起始和截止行数,
 * 通过SQL即可实现分页<br>
 * 通过<strong>getPageList</strong>方法可以取得页码分页栏中需要显示的页码数
 * </p>
 * <p>
 * 根据业务需要创建一个实体分页类继承该类<strong>(不需要实现该类的任何方法)</strong>可实现分页查询
 * </p>
 * 
 * <pre>
 * 例：当前数据库中有103条记录,查询第4页的记录,每页显示15条
 * 需要创建一个分页实体对象继承该类并设置每页显示条数,总条数,当前需要查询的页码数
 * 
 *   public class UserPage extends Pagex{}
 *   
 *   UserPage page = new UserPage();
 *   page.setCurrentPage(3);
 *   page.setTotalRow(100);
 *  
 * 
 * 设置完成后即可通过分页对象取得相关分页信息
 * 当前页起始行数：page.getStartRow() = 31
 * 当前页截止行数：page.getEndRow() = 45
 * 页面显示分页页码：page.getPageList() = {1,2,3,4,5,6,7,8}
 * </pre>
 * 
 * @author Zou Bingquan
 * @date 2013-2-5 下午2:35:59
 */
public class Pagex {

	/**
	 * 默认排序字段:id
	 */
	private static final String DEFUALT_ORDER_BY_COLUMN = "id";

	/**
	 * 默认排序类型:倒序
	 */
	private static final String DEFUALT_ORDER_BY_TYPE = "DESC";

	/**
	 * 当前页码前后页显示数量, 默认显示当前页码的前5页和后5页
	 * <p>
	 * 该值为5且当前页码为第10页时, 调用getPageList方法得到的分页页码为6-15页<br>
	 * 该值为5且当前页码为第3页时, 调用getPageList方法得到的分页页码为1-7页
	 * </p>
	 */
	private static final int PAGE_EXCURSION = 5;

	/** 查询结果总条数 */
	private int totalRow = 0;

	/** 每页显示条数 */
	private int pageSize = 20;

	/** 当前页码,默认第一页 */
	private int currentPage = 1;

	/** 总页数,根据总条数(totalRow)及每次显示条数(pageSize)计算得出 */
	private int totalPage = 0;

	/** 页码集合 */
	private List<Integer> pageList;

	/**
	 * 排序字段名称,默认按ID
	 */
	private String orderByColumn = "id";

	/**
	 * 排序规则,默认倒序
	 */
	private String orderByType = "DESC";

	/**
	 * 判断当前页是否为首页
	 */
	public boolean isFirstPage() {
		return totalPage == 0 || currentPage == 1;
	}

	/**
	 * 判断当前页是否为末页
	 */
	public boolean isLastPage() {
		return totalPage == 0 || totalPage == currentPage;
	}

	/**
	 * 取得上一页
	 */
	public int getPreviousPage() {
		int prev = currentPage - 1;
		return prev <= 0 ? 1 : prev;
	}

	/**
	 * 取得下一页
	 */
	public int getNextPage() {
		int next = currentPage + 1;
		return next > totalPage ? totalPage : next;
	}

	/**
	 * 取得当前页
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * 设置当前页
	 */
	public void setCurrentPage(Integer currentPage) {
		if (currentPage != null && currentPage > 0) {
			this.currentPage = currentPage;
		}
	}

	/**
	 * 取得页面显示条数
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 设置页面显示条数
	 */
	public void setPageSize(Integer pageSize) {
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	/**
	 * 取得总记录数(默认为0条).
	 */
	public Integer getTotalRow() {
		return totalRow;
	}

	/**
	 * 设置总记录条数, 设置后可自动算出当前页数
	 */
	public void setTotalRow(Integer count) {
		totalRow = (count == null ? 0 : count);
		totalPage = totalRow / pageSize;
		if ((totalRow % pageSize) != 0) {
			totalPage++;
		}
		if (currentPage > totalPage) {
			this.setCurrentPage(totalPage);
		}
	}

	/**
	 * 获取当前页码前后页显示数量
	 */
	public int getPageExcursion() {
		return PAGE_EXCURSION;
	}

	/**
	 * 取得总页数
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * 取得当前页开始记录位置
	 * 
	 * <pre>
	 * MySQL分页从0开始,需要修改返回值为pgSize * cPage,Oracle需要+1
	 * </pre>
	 */
	public int getStartRow() {
		// for Oracle, from 1
		// return (currentPage - 1) * pageSize + 1;
		// for MySQL, from 0
		return (currentPage - 1) * pageSize;
	}

	/**
	 * 取得当前页开始记录位置
	 * 
	 * <pre>
	 * MySQL分页从0开始,需要修改返回值为pgSize * cPage
	 * </pre>
	 */
	/**
	 * public int getStartRow() { int cPage = this.currentPage;
	 * 
	 * if (cPage == 1) { return 0; } cPage--; int pgSize = pageSize;
	 * 
	 * return (pgSize * cPage); }
	 */

	/**
	 * 取得当前页结束记录位置
	 */
	public int getEndRow() {
		int result = pageSize * currentPage;
		return result < totalRow ? result : totalRow;
	}

	/**
	 * 取得分页页码集合
	 */
	public List<Integer> getPageList() {
		int startPage = currentPage - PAGE_EXCURSION;
		int endPage = currentPage + PAGE_EXCURSION;
		// 查询当前页之前可以显示几页
		if (startPage <= 0) {
			startPage = 1;
		}
		// 查询当前页之后可以显示几页
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		pageList = new ArrayList<Integer>();
		for (int i = startPage; i <= endPage; i++) {
			pageList.add(i);
		}
		return pageList;
	}

	public String getOrderByColumn() {
		return StringUtils.defaultIfEmpty(orderByColumn, DEFUALT_ORDER_BY_COLUMN);
	}

	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}

	public String getOrderByType() {
		return StringUtils.defaultIfEmpty(orderByType, DEFUALT_ORDER_BY_TYPE);
	}

	public void setOrderByType(String orderByType) {
		this.orderByType = orderByType;
	}

}
