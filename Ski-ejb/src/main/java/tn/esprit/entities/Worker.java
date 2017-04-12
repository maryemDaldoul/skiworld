package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import tn.esprit.entities.Table;

/**
 * Entity implementation class for Entity: Worker
 *
 */
@Entity

public class Worker implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Idworker;
	private String name;
	private String role;
	
	//one to many entre worker et table 
	@OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
	private List<Table> tables;
	
	@ManyToOne
	@JoinColumn(name = "resto")
	private Resto resto;
	
	private static final long serialVersionUID = 1L;

	public Worker() {
		super();
	}
	

	public Worker(int idworker, String name, String role, Resto resto) {
		super();
		Idworker = idworker;
		this.name = name;
		this.role = role;
		this.resto = resto;
	}


	public int getIdworker() {
		return Idworker;
	}

	public void setIdworker(int idworker) {
		Idworker = idworker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Resto getResto() {
		return resto;
	}

	public void setResto(Resto resto) {
		this.resto = resto;
	}


	public List<Table> getTables() {
		return tables;
	}


	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
   
	
}
