package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import model.Avaliacao;

public class AvaliacaoJpaDAO {
	private static AvaliacaoJpaDAO instance;
    protected EntityManager entityManager;
    
    public static AvaliacaoJpaDAO getInstance(){
              if (instance == null){
                       instance = new AvaliacaoJpaDAO();
              }
              
              return instance;
    }
	
	@SuppressWarnings("unchecked")
    public List<Avaliacao> findAll() {
		List<Avaliacao> list = new ArrayList<Avaliacao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		list = sessao.createQuery("from Avaliacao").list();
		sessao.getTransaction().commit();
		sessao.close();
		return list;
    }

	public void addAvaliacao(Avaliacao avlc) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.save(avlc);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	
	public void removeAvaliacao(Integer id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		Avaliacao avlc = (Avaliacao) sessao.load(Avaliacao.class, id);
		sessao.delete(avlc);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	public void updateAvaliacao(Avaliacao avlc) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.update(avlc);
		sessao.getTransaction().commit();
		sessao.close();
	}
}