package skiMbeans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Resto;
import tn.esprit.entities.Table;
import tn.esprit.services.GestionRestoLocal;
import tn.esprit.services.GestionTablesLocal;

@ManagedBean(name="tableBean")
@ViewScoped
public class TableBean {
	
	@EJB
	GestionTablesLocal gestionTablesLocal;
	
	@EJB
	GestionRestoLocal gestionRestoLocal;
	
	List<Table> tables = new ArrayList<>();
	Table newTable = new Table();
	boolean visible = false;
	boolean update = false;
	boolean add=false;
	String type = "";
	//a ajoouter 
	int idResto; // hadha bech t7ot fih l'id mta3 resto selectionné par l'utilisateur (de l'app)

	@PostConstruct
    public void init() {
    	tables = gestionTablesLocal.getAll();
    }
	
	public void AddTable(){
		//a ajouter pour la liaison one to many 
		Resto resto = gestionRestoLocal.findById(idResto);
		newTable.setResto(resto);
		gestionTablesLocal.add(newTable);
			init();
			setVisible(false);

			
			}
	
	public void DeleteTable(Table t){
		gestionTablesLocal.delete(t);
		init();
	}
	
	public void InitUpadateTable(Table t){
		newTable=t;
		setAdd(false);
		setUpdate(true);
		setVisible(true);
		
	}
	
	
	public void updateTable(){
		gestionTablesLocal.update(newTable);
		init();
		setVisible(false);
		newTable = new Table();
	}
	
	public void initialiser(){
		newTable = new Table();
		setAdd(true);
		setUpdate(false);
		setVisible(true);
	}
	
	public void cancelSearch(){
		init();
		type = "";
	}

	public void findbyType(){
		tables=gestionTablesLocal.findByType(type);
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public List<Table> getTables() {
		return tables;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	public Table getNewTable() {
		return newTable;
	}
	public void setNewTable(Table newTable) {
		this.newTable = newTable;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

	public String getType() {
		return type;
		
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
