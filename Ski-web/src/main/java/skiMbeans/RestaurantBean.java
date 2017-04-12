package skiMbeans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Resto;
import tn.esprit.services.GestionRestoLocal;

@ManagedBean(name="restaurantBean")
@ViewScoped
public class RestaurantBean {
	
	@EJB
	GestionRestoLocal gestionRestoLocal;
	
	List<Resto> restos = new ArrayList<>();
	Resto newResto = new Resto();
	boolean visible = false;
	boolean update = false;
	boolean add=false;
	String name = "";
	
    @PostConstruct
    public void init() {
    	restos = gestionRestoLocal.getAll();
    }
	
	public void AddResto(){
			gestionRestoLocal.add(newResto);
			init();
			setVisible(false);
	}
	
	public void DeleteResto(Resto r){
		gestionRestoLocal.delete(r);
		init();
	}
	
	public void InitUpadateResto(Resto r){
		newResto=r;
		setAdd(false);
		setUpdate(true);
		setVisible(true);
		
	}
	
	public void updateResto(){
		gestionRestoLocal.update(newResto);
		init();
		setVisible(false);
		newResto = new Resto();
	}
	
	public void initialiser(){
		newResto = new Resto();
		setAdd(true);
		setUpdate(false);
		setVisible(true);
	}
	
	public void cancelSearch(){
		init();
		name = "";
	}

	public void findbyName(){
		restos=gestionRestoLocal.findByName(name);
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public List<Resto> getRestos() {
		return restos;
	}
	public void setRestos(List<Resto> restos) {
		this.restos = restos;
	}
	public Resto getNewResto() {
		return newResto;
	}
	public void setNewResto(Resto newResto) {
		this.newResto = newResto;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
