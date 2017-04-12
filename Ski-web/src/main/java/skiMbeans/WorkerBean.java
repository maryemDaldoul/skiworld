package skiMbeans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Worker;

import tn.esprit.services.GestionWorkerLocal;

@ManagedBean(name="workerBean")
@ViewScoped
public class WorkerBean {
	
	@EJB
	GestionWorkerLocal gestionWorkerLocal;
	
	List<Worker> workers = new ArrayList<>();
	Worker newWorker = new Worker();
	boolean visible = false;
	boolean update = false;
	boolean add=false;
	String name = "";
	
    @PostConstruct
    public void init() {
    	workers = gestionWorkerLocal.getAll();
    }
	
	public void AddWorker(){
		gestionWorkerLocal.add(newWorker);
			init();
			setVisible(false);
	}
	
	public void DeleteWorker(Worker w){
		gestionWorkerLocal.delete(w);
		init();
	}
	
	public void InitUpadateWorker(Worker w){
		newWorker=w;
		setAdd(false);
		setUpdate(true);
		setVisible(true);
		
	}
	
	public void updateWorker(){
		gestionWorkerLocal.update(newWorker);
		init();
		setVisible(false);
		newWorker = new Worker();
	}
	
	public void initialiser(){
		newWorker = new Worker();
		setAdd(true);
		setUpdate(false);
		setVisible(true);
	}
	
	public void cancelSearch(){
		init();
		name = "";
	}

	public void findbyName(){
		workers=gestionWorkerLocal.findByName(name);
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public List<Worker> getWorkers() {
		return workers;
	}
	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}
	public Worker getNewWorker() {
		return newWorker;
	}
	public void setNewWorker(Worker newWorker) {
		this.newWorker = newWorker;
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
