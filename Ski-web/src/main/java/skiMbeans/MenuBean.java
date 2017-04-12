package skiMbeans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Menu;
import tn.esprit.entities.Table;
import tn.esprit.services.GestionMenuLocal;

@ManagedBean(name="menuBean")
@ViewScoped// tous c qui est viw 
public class MenuBean {
	
	@EJB
	GestionMenuLocal gestionMenuLocal;
	
	List<Menu> menus = new ArrayList<>();
	Menu newMenu = new Menu();
	boolean visible = false;
	boolean update = false;
	boolean add=false;
	String price = "";
	
	
    @PostConstruct
    public void init() {
    	menus = gestionMenuLocal.getAll();
    }
	
	public void AddMenu(){
		gestionMenuLocal.add(newMenu);
			init();
			setVisible(false);
	}
	
	public void DeleteMenu(Menu m){
		gestionMenuLocal.delete(m);
		init();
	}
	
	public void InitUpadateMenu(Menu m){
		newMenu=m;
		setAdd(false);
		setUpdate(true);
		setVisible(true);
		
	}
	
	public void updateMenu(){
		gestionMenuLocal.update(newMenu);
		init();
		setVisible(false);
		newMenu = new Menu();
	}
	
	public void initialiser(){
		newMenu = new Menu();
		setAdd(true);
		setUpdate(false);
		setVisible(true);
	}
	
	public void cancelSearch(){
		init();
		price = "";
	}

	public void findbyPrice(){
		menus=gestionMenuLocal.findByPrice(price);
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public Menu getNewMenu() {
		return newMenu;
	}
	public void setNewMenu(Menu newMenu) {
		this.newMenu = newMenu;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	
	

	
}



