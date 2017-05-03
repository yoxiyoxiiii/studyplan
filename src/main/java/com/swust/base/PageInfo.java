package com.swust.base;

import java.util.List;

/**
 * 
 * ��ҳ ���
 * @author Administrator
 *
 * @param <T>
 */
public class PageInfo<T> {
	
	//页面大小
	private Integer pageSize=10;
	//当前页数
	private Integer pageNumber=1;
	
	private int totalRecord;//总的记录数
	private int totalPage;//总的页数
	
	//多个查询参数
	private Object[] params;
	//单个 参数
	private Object param;
	//数据
	private List<T> data;
	
	public PageInfo(){}
	
	public PageInfo(int pageNumber,int pageSize, Object []params ){
		this.pageNumber=pageNumber;
		this.pageSize=pageSize;
		this.params =params;
	}
	

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		int number=totalRecord/this.pageSize;
		this.totalPage = totalRecord % this.pageSize ==0?number:number +1;
	}
	
	
	public void setTotalPage(int totalRecord) {
		this.totalRecord=totalRecord;
		setTotalPage();
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	

}
