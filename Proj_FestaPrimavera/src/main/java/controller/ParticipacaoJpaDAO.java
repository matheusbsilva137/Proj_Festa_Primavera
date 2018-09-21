package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import model.Avaliacao;
import model.Participacao;

public class ParticipacaoJpaDAO {
	private static ParticipacaoJpaDAO instance;
    protected EntityManager entityManager;
    
    public static ParticipacaoJpaDAO getInstance(){
              if (instance == null){
                       instance = new ParticipacaoJpaDAO();
              }
              
              return instance;
    }
	
	@SuppressWarnings("unchecked")
    public List<Participacao> findAll() {
		List<Participacao> list = new ArrayList<Participacao>();
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		list = sessao.createQuery("from Participacao").list();
		sessao.getTransaction().commit();
		sessao.close();
		return list;
    }

	public void addParticipacao(Participacao ptcp) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.save(ptcp);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	
	public void removeParticipacao(Integer id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		Participacao ptcp = (Participacao) sessao.load(Participacao.class, id);
		sessao.delete(ptcp);
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	public void updateParticipacao(Participacao ptcp) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.beginTransaction();
		sessao.update(ptcp);
		sessao.getTransaction().commit();
		sessao.close();
	}
}
