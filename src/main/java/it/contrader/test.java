package it.contrader;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.model.User.Usertype;
import it.contrader.service.AbstractService;
import it.contrader.session.SessionHibernate;



public class test extends AbstractService<User, UserDTO> {

	@Autowired
	private static testHibernate hibernate;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = SessionHibernate.getSessionfactory();
		Session session = factory.openSession();
		
		User u = new User();
		User u2 = new User();
		u.setUsername("mario");
		u.setPassword("rossi");
		u.setUsertype(Usertype.USER);
		System.out.println(u.getUsertype());
		/*session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();*/
		session.close();
		
		Session session2 = factory.openSession();
		session2.beginTransaction();
		u2.setUsername("mario");
		//u2 = hibernate.findByUsernameAndPassword("mario", "rossi");
		//System.out.println(u2.getUsername().toString());
		//List<User> l = (List<User>)session2.createQuery("from User").list();
		/*for(User us: l)
		{
			System.out.println(us.getUsertype().toString());
		}*/
		factory.close();
	}

}
