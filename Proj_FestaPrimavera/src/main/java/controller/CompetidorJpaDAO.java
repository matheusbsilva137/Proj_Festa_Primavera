package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import model.Competidor;

public class CompetidorJpaDAO {
	private static CompetidorJpaDAO instance;
    protected EntityManager entityManager;
    
    public static CompetidorJpaDAO getInstance(){
              if (instance == null){
                       instance = new CompetidorJpaDAO();
              }
              
              return instance;
    }
	
	@SuppressWarnings("unchecked")
    public List<Competidor> findAll() {
		List<Competidor> list = new ArrayList<Competidor>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		list = sessao.createQuery("from Competidor").list();
		sessao.getTransaction().commit();
		sessao.close();
		return list;
    }

	public void addCompetidor(Competidor cptd) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.save(cptd);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	
	public void removeCompetidor(Integer id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		Competidor cptd = (Competidor) sessao.load(Competidor.class, id);
		sessao.delete(cptd);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	public void updateCompetidor(Competidor cptd) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.update(cptd);
		sessao.getTransaction().commit();
		sessao.close();
	}
}
