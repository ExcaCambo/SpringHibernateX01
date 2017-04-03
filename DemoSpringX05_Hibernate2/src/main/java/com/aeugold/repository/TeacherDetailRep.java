package com.aeugold.repository;

import java.util.ArrayList;

import com.aeugold.enity.FullTimeTeacher;

public interface TeacherDetailRep {
	public ArrayList<FullTimeTeacher> getFullTimeTeacher();
	public boolean insertTeacher(FullTimeTeacher obj);
	public boolean updateTeacher(FullTimeTeacher obj);
	public boolean deleteTeacher(int id);
}
