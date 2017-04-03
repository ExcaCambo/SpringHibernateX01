package com.aeugold.service;

import java.util.ArrayList;

import com.aeugold.enity.FullTimeTeacher;

public interface TeacherDetailService {
	
	public ArrayList<FullTimeTeacher> getFullTimeTeacher();
	public boolean insertTeacher(FullTimeTeacher obj);
	public boolean updateTeacher(FullTimeTeacher obj);
	public boolean deleteTeacher(int id);
}
