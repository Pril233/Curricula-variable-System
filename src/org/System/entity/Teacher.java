package org.System.entity;

public class Teacher {
	private int tno;
	private String tname;
	private String tsex;
	private int tage;
	private String teb;
	private String tpt;
	private int cno1;
	private int cno2;
	private int cno3;
	public Teacher(int tno, String tname, String tsex, int tage, String teb, String tpt, int cno1,
			int cno2, int cno3) {
		this.tno=tno;
		this.tname=tname;
		this.tsex=tsex;
		this.tage=tage;
		this.teb=teb;
		this.tpt=tpt;
		this.cno1=cno1;
		this.cno2=cno2;
		this.cno3=cno3;

	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getTeb() {
		return teb;
	}
	public void setTeb(String teb) {
		this.teb = teb;
	}
	public String getTpt() {
		return tpt;
	}
	public void setTpt(String tpt) {
		this.tpt = tpt;
	}
	public int getCno1() {
		return cno1;
	}
	public void setCno1(int cno1) {
		this.cno1 = cno1;
	}
	public int getCno2() {
		return cno2;
	}
	public void setCno2(int cno2) {
		this.cno2 = cno2;
	}
	public int getCno3() {
		return cno3;
	}
	public void setCno3(int cno3) {
		this.cno3 = cno3;
	}
}
