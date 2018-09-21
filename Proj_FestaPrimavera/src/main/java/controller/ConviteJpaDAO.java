package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import model.Convite;
import model.Participacao;

public class ConviteJpaDAO {
	private static ConviteJpaDAO instance;
    protected EntityManager entityManager;
    
    public static ConviteJpaDAO getInstance(){
              if (instance == null){
                       instance = new ConviteJpaDAO();
              }
              
              return instance;
    }
	
	@SuppressWarnings("unchecked")
    public List<Convite> findAll() {
		List<Convite> list = new ArrayList<Convite>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		list = sessao.createQuery("from Convite").list();
		sessao.getTransaction().commit();
		sessao.close();
		return list;
    }

	public void addConvite(Convite cvt) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.save(cvt);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	
	public void removeConvite(Integer id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		Convite cvt = (Convite) sessao.load(Convite.class, id);
		sessao.delete(cvt);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	public void updateConvite(Convite cvt) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.update(cvt);
		sessao.getTransaction().commit();
		sessao.close();
	}
}