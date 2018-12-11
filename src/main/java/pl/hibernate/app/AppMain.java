package pl.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.hibernate.entity.Course;
import pl.hibernate.entity.User;

public class AppMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			int userId = 2;
			int courseId = 11;

			User user = session.get(User.class, userId);

			System.out.println("User: " + user);
			System.out.println("Courses: " + user.getCourses());

			Course c = session.get(Course.class, courseId);
			System.out.println("Participant of the course with the id 11: " + c.getUser());
			
			session.getTransaction().commit();

		} finally {
			System.out.println("The user has been added");
			session.close();
			sessionFactory.close();
		}

	}

}
