package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import model.Jurado;

public class JuradoJpaDAO {
	private static JuradoJpaDAO instance;
    protected EntityManager entityManager;
    
    public static JuradoJpaDAO getInstance(){
              if (instance == null){
                       instance = new JuradoJpaDAO();
              }
              
              return instance;
    }
	
	@SuppressWarnings("unchecked")
    public List<Jurado> findAll() {
		List<Jurado> list = new ArrayList<Jurado>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		list = sessao.createQuery("from Jurado").list();
		sessao.getTransaction().commit();
		sessao.close();
		return list;
    }

	public void addJurado(Jurado jrd) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.save(jrd);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	
	public void removeJurado(String login) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		Jurado jrd = (Jurado) sessao.load(Jurado.class, login);
		sessao.delete(jrd);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	public void updateJurado(Jurado jrd) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.update(jrd);
		sessao.getTransaction().commit();
		sessao.close();
	}
}
