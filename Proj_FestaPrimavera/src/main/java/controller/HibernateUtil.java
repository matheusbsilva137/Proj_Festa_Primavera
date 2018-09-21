package controller;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Avaliacao;
import model.Competicao;
import model.Competidor;
import model.Convite;
import model.Instituicao;
import model.Jurado;
import model.Participacao;

public class HibernateUtil {
	private static final SessionFactory factory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(Avaliacao.class);
		configuration.addAnnotatedClass(Competicao.class);
		configuration.addAnnotatedClass(Competidor.class);
		configuration.addAnnotatedClass(Convite.class);
		configuration.addAnnotatedClass(Instituicao.class);
		configuration.addAnnotatedClass(Jurado.class);
		configuration.addAnnotatedClass(Participacao.class);
		configuration.configure();
		
		return configuration.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}