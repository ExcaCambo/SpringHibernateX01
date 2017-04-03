package com.aeugold.repository.implement;

import java.util.ArrayList;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.aeugold.enity.FullTimeTeacher;
import com.aeugold.repository.TeacherDetailRep;
import com.aeugold.util.HibernateUtil;


@Repository
public class TeacherDetailRepImp implements TeacherDetailRep{

	@Override
	public ArrayList<FullTimeTeacher> getFullTimeTeacher() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		ArrayList<FullTimeTeacher> employees = (ArrayList<FullTimeTeacher>) session.createQuery(
				"FROM getfulltime").list();

		session.getTransaction().commit();
		session.close();
		return employees;
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
