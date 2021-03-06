package lez17.HibernateManyToMany.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="studente")
public class Studente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_studente")
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String matricola;
	
	@ManyToMany
	@JoinTable(name="studente_esame",
				joinColumns = { @JoinColumn(name="studente_rif", referencedColumnName = "id_studente") },
				inverseJoinColumns = { @JoinColumn(name="esame_rif", referencedColumnName = "id_esame") }
			)
	private List<Esame> elencoEsami;
	
	//COSTRUTTORE
	public Studente() {
	
	}

	
	
	//COSTRUTTORE CON P.
	public Studente(String nome, String cognome, String matricola) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}


	
	
	//GETTERS END SETTERS
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public List<Esame> getElencoEsami() {
		return elencoEsami;
	}

	
	public void setElencoEsami(List<Esame> elencoEsami) {
		this.elencoEsami = elencoEsami;
	}



	//TO STRING
	@Override
	public String toString() {
		return "Studente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + "]";
	}
	
	
	//DETTAGLIO STUDENTE
	public String dettaglioStudente() {
		return "Studente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", elencoEsami=" + elencoEsami + "]";
	}
	
}
