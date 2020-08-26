package it.contrader.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHibernate {

	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("creazione sessione fallita!" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
}
