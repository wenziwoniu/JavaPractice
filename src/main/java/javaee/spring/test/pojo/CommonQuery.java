package javaee.spring.test.pojo;

public class CommonQuery {
	
	private int pageNum;
	
	private int numPerPage;
	
	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	private int start;
	
	public int getPageNum() {
		if (pageNum < 1) {
			this.pageNum = 1;
		}
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStart() {
		if (pageNum < 1) {
			this.start = 0;
		} else {
			this.start = (pageNum - 1) * numPerPage;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
