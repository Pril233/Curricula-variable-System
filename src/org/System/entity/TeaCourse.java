package org.System.entity;

public class TeaCourse {
	private int cno;
	private String cname;
	private int sno;
	private String sname;
	private int grade;
	
	public TeaCourse(int cno,String cname,int sno,String sname,int grade) {
		this.cno=cno;
		this.cname=cname;
		this.sno=sno;
		this.sname=sname;
		this.grade=grade;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	
	
}
