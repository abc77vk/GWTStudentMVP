package my.app.main.server.entity;

import java.io.Serializable;

import javax.persistence.Id;

import my.app.main.client.entity.StudentInfo;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String login;
	private String password;
	private String name;
	private Integer age;

	public Student() {
	}

	public Student(String login, String password, String name, Integer age) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.age = age;
	}
	
	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", age=" + age
				+ "]";
	}

	public void addMark(Mark mark) {
		mark.setStudent(new Key<Student>(Student.class, this.id));
	}
	
	public StudentInfo getStudentInfo() {
		return new StudentInfo(name, String.valueOf(age));
	}

}
