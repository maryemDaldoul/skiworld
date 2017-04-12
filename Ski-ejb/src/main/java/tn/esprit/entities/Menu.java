package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Menu
 *
 */
@Entity

public class Menu implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Idmenu;
	private String price;
	private String description;
	@ManyToOne
	@JoinColumn(name = "table_resto")
	private Table table;
	
	

	
	private static final long serialVersionUID = 1L;

	public Menu() {
		super();
	}

		
	
	//public Menu( String price, String description) {
		//super();
		
		//this.price = price;
		//this.description = description;
	//}


	


	public Menu(int idmenu, String price, String description, Table table) {
		super();
		Idmenu = idmenu;
		this.price = price;
		this.description = description;
		this.table = table;
	}

	public int getIdmenu() {
		return Idmenu;
	}


	public void setIdmenu(int idmenu) {
		Idmenu = idmenu;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Table getTable() {
		return table;
	}



	public void setTable(Table table) {
		this.table = table;
	}
	
	
   
}
