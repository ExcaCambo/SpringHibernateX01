package com.aeugold.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeugold.enity.FullTimeTeacher;
import com.aeugold.repository.TeacherDetailRep;
import com.aeugold.service.TeacherDetailService;

@Service
public class TeacherDetailServiceImp implements TeacherDetailService {

	@Autowired
	private TeacherDetailRep teacherRep;
	
	@Override
	public ArrayList<FullTimeTeacher> getFullTimeTeacher() {
		// TODO Auto-generated method stub
		return teacherRep.getFullTimeTeacher();
	}

	@Override
	public boolean insertTeacher(FullTimeTeacher obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTeacher(FullTimeTeacher obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTeacher(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
