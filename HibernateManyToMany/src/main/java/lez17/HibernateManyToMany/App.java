package lez17.HibernateManyToMany;

import java.util.ArrayList;

import lez17.HibernateManyToMany.models.Esame;
import lez17.HibernateManyToMany.models.Studente;
import lez17.HibernateManyToMany.models.crud.EsameDAO;
import lez17.HibernateManyToMany.models.crud.StudenteDAO;

public class App 
{
    public static void main( String[] args )
    {
        
    	StudenteDAO stuDao = new StudenteDAO();
    	EsameDAO esaDao = new EsameDAO();
    	
    	
    	/**
    	 * 	 INSERT
    	 */
    	
//    	Studente studenteUno = new Studente("Samanta", "Cristoforetti", "MA0001");
//    	Studente studenteDue = new Studente("Luca", "Parmitano", "MA0002");
//    	Studente studenteTre = new Studente("Paolo", "Nespoli", "MA0003");
//    	
//    	Esame esameUno = new Esame("Fisica", 6, "2021-03-25");
//    	Esame esameDue = new Esame("Matematica", 6, "2021-05-12");
//    	Esame esameTre = new Esame("Chimica", 6, "2021-04-30");
//    	
//    	studenteUno.setElencoEsami(new ArrayList<Esame>());
//    	studenteUno.getElencoEsami().add(esameDue);
//    	
//    	studenteDue.setElencoEsami(new ArrayList<Esame>());
//    	studenteDue.getElencoEsami().add(esameTre);
//    	
//    	studenteTre.setElencoEsami(new ArrayList<Esame>());
//    	studenteTre.getElencoEsami().add(esameUno);
//    	
//    	
//    	
//    	esaDao.insert(esameUno);
//    	esaDao.insert(esameDue);
//    	esaDao.insert(esameTre);
//    	stuDao.insert(studenteUno);
//    	stuDao.insert(studenteDue);
//    	stuDao.insert(studenteTre);
    	
    	
    	
    	//-------- INSERIMENTO Studente ed iscrizione ad esami gia presenti sul DB ----------//
    	
//    	Studente studenteUno = new Studente("Veronica", "Amico", "MA0004");
//    	
//    	Esame esameFisica = esaDao.findById(1);
//    	Esame esameMatematica = esaDao.findById(2);
//    	Esame esameChimica = esaDao.findById(3);
//    
//    	studenteUno.setElencoEsami(new ArrayList<Esame>());
//    	studenteUno.getElencoEsami().add(esameFisica);
//    	studenteUno.getElencoEsami().add(esameMatematica);
//    	studenteUno.getElencoEsami().add(esameChimica);
    	
//    	stuDao.insert(studenteUno);

    	
//!    	//esaDao.insert(esameFisica);				//GLI ESAMI DI FISICA, MATEMATICA E CHIMICA ESISTONO GIA!
//!    	//esaDao.insert(esameMatematica);
//!    	//esaDao.insert(esameChimica);
    	
    	
    	
    	
    	//---------- Penso inversamente, creo un Esame ed iscrivo gli studenti -------------//
    	
    	Esame esameFondInf = new Esame("Fondamenti di Informatica", 6, "2021-07-20");
    	
    	Studente stuNespoli = stuDao.findById(3);
    	Studente stuCristoforetti = stuDao.findById(1);
    	
    	esameFondInf.setElencoStudente(new ArrayList<Studente>());
    	esameFondInf.getElencoStudente().add(stuNespoli);
    	esameFondInf.getElencoStudente().add(stuCristoforetti);
    	
    	esaDao.insert(esameFondInf);

    }
}
