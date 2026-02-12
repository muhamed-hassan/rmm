package app.web.models;

import java.util.HashSet;

public class PageModel<T> {
	
	private HashSet<T> data;
	
	private boolean firstPage;
	
	private boolean lastPage;

	public HashSet<T> getData() {
		return data;
	}

	public void setData(HashSet<T> data) {
		this.data = data;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

}