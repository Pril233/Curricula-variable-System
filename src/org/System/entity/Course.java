package org.System.entity;

public class Course {
	int cno;
	String cname;
	int cpno;
	int ccredit;
	
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

	public int getCpno() {
		return cpno;
	}

	public void setCpno(int cpno) {
		this.cpno = cpno;
	}

	public int getCcredit() {
		return ccredit;
	}

	public void setCcredit(int ccredit) {
		this.ccredit = ccredit;
	}

	public Course(int cno,String cname,int cpno,int ccredit) {
		this.cno=cno;
		this.cname=cname;
		this.cpno=cpno;
		this.ccredit=ccredit;
	}
	

}
