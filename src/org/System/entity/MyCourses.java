package org.System.entity;

public class MyCourses {
	int cno;
	String cname;
	String tname;
	
	public MyCourses(int cno, String cname, String tname) {
		this.cno=cno;
		this.cname=cname;
		this.tname=tname;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
}
