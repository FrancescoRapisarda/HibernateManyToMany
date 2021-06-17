package lez17.HibernateManyToMany.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="esame")
public class Esame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_esame")
	private int id;
	
	@Column
	private String nome;
	@Column
	private int crediti;
	@Column
	private String data_esame;
	
	@ManyToMany
	@JoinTable(name="studente_esame",
				joinColumns = { @JoinColumn(name="esame_rif", referencedColumnName = "id_esame") },
				inverseJoinColumns = { @JoinColumn(name="studente_rif", referencedColumnName = "id_studente") }
			)
	private List<Studente> elencoStudente; 
	
	
	//COSTRUTTORE
	public Esame() {
		
	}


	//COSTRUTTORE CON P.
	public Esame(String nome, int crediti, String data_esame) {
		super();
		this.nome = nome;
		this.crediti = crediti;
		this.data_esame = data_esame;
	}


	
	
	//GETTERS AND SETTERS
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


	public int getCrediti() {
		return crediti;
	}


	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}


	public String getData_esame() {
		return data_esame;
	}


	public void setData_esame(String data_esame) {
		this.data_esame = data_esame;
	}


	public List<Studente> getElencoStudente() {
		return elencoStudente;
	}


	public void setElencoStudente(List<Studente> elencoStudente) {
		this.elencoStudente = elencoStudente;
	}


	
	//TOSTRING
	@Override
	public String toString() {
		return "Esame [id=" + id + ", nome=" + nome + ", crediti=" + crediti + ", data_esame=" + data_esame + "]";
	}
	
	
	//DETTAGLIO ESAME
	public String DettaglioEsame() {
		return "Esame [id=" + id + ", nome=" + nome + ", crediti=" + crediti + ", data_esame=" + data_esame + ", elencoStudente=" + elencoStudente + "]";
	}
	

}
