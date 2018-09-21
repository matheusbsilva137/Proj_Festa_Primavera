package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import model.Instituicao;

public class InstituicaoJpaDAO {
	private static InstituicaoJpaDAO instance;
    protected EntityManager entityManager;
    
    public static InstituicaoJpaDAO getInstance(){
              if (instance == null){
                       instance = new InstituicaoJpaDAO();
              }
              
              return instance;
    }
	
	@SuppressWarnings("unchecked")
    public List<Instituicao> findAll() {
		List<Instituicao> list = new ArrayList<Instituicao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		list = sessao.createQuery("from Instituicao").list();
		sessao.getTransaction().commit();
		sessao.close();
		return list;
    }

	public void addInstituicao(Instituicao inst) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.save(inst);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	
	public void removeInstituicao(int id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		Instituicao inst = (Instituicao) sessao.load(Instituicao.class, id);
		sessao.delete(inst);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	public void updateInstituicao(Instituicao inst) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.update(inst);
		sessao.getTransaction().commit();
		sessao.close();
	}
}
