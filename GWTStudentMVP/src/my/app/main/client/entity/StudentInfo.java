package my.app.main.client.entity;

import java.io.Serializable;

public class StudentInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String age;
	
	public StudentInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	

	public StudentInfo(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	
}
