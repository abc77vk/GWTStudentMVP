package my.app.main.server.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import my.app.main.client.entity.MarkInfo;

import com.googlecode.objectify.Key;

public class Mark implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String name;
	private Integer mark;
	private Date date = new Date();
	private Key<Student> student;

	public Mark() {
	}
	
	public Long getId() {
		return id;
	}

	public Mark(String name, Integer mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Key<Student> getStudent() {
		return student;
	}

	public void setStudent(Key<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Mark [id=" + id + ", name=" + name + ", mark=" + mark + ", date=" + date + ", student=" + student + "]";
	}
	
	public MarkInfo asMarkInfo() {
		return new MarkInfo(name, String.valueOf(mark));
	}

}
