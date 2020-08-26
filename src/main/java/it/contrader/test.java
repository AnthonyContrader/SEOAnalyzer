package it.contrader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.contrader.model.User;
import it.contrader.model.User.Usertype;
import it.contrader.session.SessionHibernate;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = SessionHibernate.getSessionfactory();
		Session session = factory.openSession();
		
		User u = new User();
		u.setUsername("mario");
		u.setPassword("rossi");
		u.setUsertype(Usertype.USER);
		
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
