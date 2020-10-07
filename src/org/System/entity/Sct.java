package org.System.entity;

public class Sct {
	private int sno;
	private int cno;
	private int tno;
	private int grade;
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Sct(int sno,int cno,int tno,int grade) {
		this.sno=sno;
		this.cno=cno;
		this.tno=tno;
		this.grade=grade;
	}

	public Sct(int sno, int cno, int tno) {
		this.sno=sno;
		this.cno=cno;
		this.tno=tno;
	}
}
