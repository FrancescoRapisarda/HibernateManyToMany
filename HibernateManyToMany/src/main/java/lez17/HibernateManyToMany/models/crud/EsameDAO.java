package lez17.HibernateManyToMany.models.crud;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import lez17.HibernateManyToMany.db.GestoreSessioni;
import lez17.HibernateManyToMany.models.Esame;

public class EsameDAO implements Dao<Esame> {

	@Override
	public void insert(Esame t) {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			sessione.save(t);
			
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
	}
	
	

	@Override
	public Esame findById(int id) {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			Esame temp = sessione.get(Esame.class, id);
			
			sessione.getTransaction().commit();
			
			return temp;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		return null;
	}

	
	
	@Override
	public List<Esame> findAll() {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			TypedQuery<Esame> esame = sessione.createQuery("FROM Esame", Esame.class);
			List<Esame> elencoEsame = esame.getResultList();
			
			sessione.getTransaction().commit();
			
			return elencoEsame;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		return null;
	}

	
	
	@Override
	public boolean delete(int id) {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			Esame temp = sessione.load(Esame.class, id);
			
			sessione.delete(temp);
			
			sessione.getTransaction().commit();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		return false;
	}

	
	
	@Override
	public boolean delete(Esame t) {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			sessione.delete(t);
			
			sessione.getTransaction();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	
	
	@Override
	public boolean update(Esame t) {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			sessione.update(t);
			
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	
}
