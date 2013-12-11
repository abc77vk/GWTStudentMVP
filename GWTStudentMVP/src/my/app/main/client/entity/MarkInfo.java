package my.app.main.client.entity;

import java.io.Serializable;

public class MarkInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String name;
	private String mark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public MarkInfo(String name, String mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
	
	
}
