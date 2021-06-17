package lez17.HibernateManyToMany.models.crud;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import lez17.HibernateManyToMany.db.GestoreSessioni;
import lez17.HibernateManyToMany.models.Studente;

public class StudenteDAO implements Dao<Studente> {

	@Override
	public void insert(Studente t) {
		
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
	public Studente findById(int id) {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			
			Studente temp = sessione.get(Studente.class, id);
			
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
	public List<Studente> findAll() {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			TypedQuery<Studente> studente = sessione.createQuery("FROM Studente", Studente.class);
			List<Studente> elencoStudenti = studente.getResultList();
			
			sessione.getTransaction().commit();
			
			return elencoStudenti;
			
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
			
			Studente temp = sessione.load(Studente.class, id);
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
	public boolean delete(Studente t) {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			sessione.delete(t);
			
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
	public boolean update(Studente t) {
		
		Session sessione = GestoreSessioni.getIstanza().getFactory().getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			sessione.update(t);
			
			sessione.getTransaction().commit();
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		return false;
	}

}


