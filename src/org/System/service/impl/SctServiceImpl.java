package org.System.service.impl;
import java.util.List;

import org.System.entity.MyCourses;
import org.System.entity.Sct;
import org.System.entity.TeaCourse;
import org.System.dao.impl.SctDaoImpl;

public class SctServiceImpl {
	SctDaoImpl sctdao = new SctDaoImpl();
	
	
	public boolean addSct(Sct sct,int cpno) {
		
		if(sctdao.isExist(sct)==false) {
			if(cpno==0)
			return sctdao.addSct(sct);
			else
			{
				if(sctdao.isFinish(sct.getSno(), cpno)) {
					return sctdao.addSct(sct);
				}
				else
					System.out.println("先行课未完成");
			}
		}
		else
			System.out.println("已选修该课程");
			return false;
		}
		
	
	
	
	public List<Sct> queryAllSct(){
		return sctdao.queryAllSct();
	}
	
	public List<MyCourses> queryMyCourses(int sno){
		return sctdao.queryMyCourse(sno);
	}
	
	public List<TeaCourse> queryTeaCourse(int tno){
		return sctdao.queryTeaCourse(tno);
	}
	
	public boolean deleteSct(int sno,int cno) {
		return sctdao.deleteSct(sno, cno);
	}
	
	public boolean Score(int grade,int sno,int cno,int tno) {
		return sctdao.Score(grade, sno, cno, tno);
	}
	
}
