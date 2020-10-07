package org.System.entity;

public class Student {
	private int sno;
	private String sname;
	private String ssex;
	private int  sage;
	private String sdept;
	
	public Student(int sno,String sname,String ssex,int sage,String sdept) {
		this.sno=sno;
		this.sname=sname;
		this.ssex=ssex;
		this.sage=sage;
		this.sdept=sdept;
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
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	
	@Override
	public String toString() { 
		
		return this.getSno()+"-"+this.getSname()+"-"+this.getSsex()+this.getSage()+"-"+this.getSdept();
	}
	

}
