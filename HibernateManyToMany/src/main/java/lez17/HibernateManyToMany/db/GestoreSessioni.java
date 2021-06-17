package lez17.HibernateManyToMany.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lez17.HibernateManyToMany.models.Esame;
import lez17.HibernateManyToMany.models.Studente;

public class GestoreSessioni {
	
	private static GestoreSessioni ogg_gestore;
	private SessionFactory factory;

	public static GestoreSessioni getIstanza() {
		if(ogg_gestore == null) {
			ogg_gestore = new GestoreSessioni();
		}
		
		return ogg_gestore;
	}
	
	public SessionFactory getFactory() {
		if(factory == null) {
			factory = new Configuration().configure("lez17/HibernateManyToMany/resources/universita.cfg.xml")
					.addAnnotatedClass(Studente.class)
					.addAnnotatedClass(Esame.class)
					.buildSessionFactory();
		}
		
		return factory;
	}

}
