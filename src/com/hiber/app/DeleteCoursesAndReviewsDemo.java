package com.hiber.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.Course;
import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;
import com.hiber.entity.Review;

public class DeleteCoursesAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int courseid = 10;
			
			Course course = session.get(Course.class, courseid);
			
			if(course!=null) {
				System.out.println(course);
				System.out.println(course.getReviews());
				System.out.println("delete the course and review");
				session.delete(course);
			}
			

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
