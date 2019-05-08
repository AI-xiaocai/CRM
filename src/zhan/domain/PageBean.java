package zhan.domain;

import java.util.List;

public class PageBean {
	private Integer currentPage; //��ǰҳ
	private Integer totalPage; //��ҳ��
	private Integer totalCount; //�ܸ���
	private Integer beginIndex; //��ʼ����
	private List<Customer> list;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}
}
