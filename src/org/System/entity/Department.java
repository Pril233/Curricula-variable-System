package org.System.entity;

public class Department {
	int dno;	
	String dname;
	String dmanager;
	
	public Department(int dno,String dname,String dmanager) {
		this.dno=dno;
		this.dname=dname;
		this.dmanager=dmanager;
	}
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDmanager() {
		return dmanager;
	}
	public void setDmanager(String dmanager) {
		this.dmanager = dmanager;
	}
	
	public String toString() {
		return this.getDno()+"-"+this.getDname()+"-"+this.getDmanager();
	}
	
	

}
