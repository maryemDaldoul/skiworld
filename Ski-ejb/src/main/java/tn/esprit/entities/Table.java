package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import tn.esprit.entities.Table;

/**
 * S Entity implementation class for Entity: Tables
 *
 */
@Entity(name="table_resto")

public class Table implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Idtable;
	private String type;
	private String numChair;

	@ManyToOne
	@JoinColumn(name = "resto")
	private Resto resto;
	
	@ManyToOne
	@JoinColumn(name = "worker")
	private Worker worker;
	// liason one to many entre table et menu 
	@OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
	private List<Menu> menus;
	private static final long serialVersionUID = 1L;

	public Table() {
		super();
	}
	

	public Table(int idtable, String type, String numChair, Resto resto,Worker worker) {
		super();
		Idtable = idtable;
		this.type = type;
		this.numChair = numChair;
		this.resto = resto;
		this.worker = worker;
		
	}


	public int getIdtable() {
		return Idtable;
	}

	public void setIdtable(int idtable) {
		Idtable = idtable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Resto getResto() {
		return resto;
	}

	public void setResto(Resto resto) {
		this.resto = resto;
	}

	public String getNumChair() {
		return numChair;
	}

	public void setNumChair(String numChair) {
		this.numChair = numChair;
	}


	public Worker getWorker() {
		return worker;
	}


	public void setWorker(Worker worker) {
		this.worker = worker;
	}


	public List<Menu> getMenus() {
		return menus;
	}


	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	

}
