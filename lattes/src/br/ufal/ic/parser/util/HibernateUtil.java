package br.ufal.ic.parser.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();
	
	private static ThreadLocal<Transaction> transactions = new ThreadLocal<Transaction>();
	
	private static SessionFactory sessionFactory;
	
	private static Configuration configuration;
	
	static {
		configuration = new AnnotationConfiguration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session openSession() {
		sessions.set(sessionFactory.openSession());
		transactions.set(sessions.get().beginTransaction());
		return sessions.get();
	}	
	
	public static Session getSession() {
		return sessions.get();
	}
	
	public static void close() {
		sessions.get().close();
		sessions.set(null);
	}

	public static void commit() {
		transactions.get().commit();
		transactions.set(null);
	}

	public static void rollback() {
		transactions.get().rollback();
		transactions.set(null);		
	}

}
