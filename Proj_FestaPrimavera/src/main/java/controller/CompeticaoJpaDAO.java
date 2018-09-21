package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import model.Competicao;
import model.Jurado;


public class CompeticaoJpaDAO {
	private static CompeticaoJpaDAO instance;
    protected EntityManager entityManager;
    
    public static CompeticaoJpaDAO getInstance(){
              if (instance == null){
                       instance = new CompeticaoJpaDAO();
              }
              
              return instance;
    }
	
	@SuppressWarnings("unchecked")
    public List<Competicao> findAll() {
		List<Competicao> list = new ArrayList<Competicao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		list = sessao.createQuery("from Competicao").list();
		sessao.getTransaction().commit();
		sessao.close();
		return list;
    }

	public void addCompeticao(Competicao cptc) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.save(cptc);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	
	public void removeCompeticao(int edicao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		Competicao cptc = (Competicao) sessao.load(Competicao.class, edicao);
		sessao.delete(cptc);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	public void updateCompeticao(Competicao cptc) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.update(cptc);
		sessao.getTransaction().commit();
		sessao.close();
	}
}
