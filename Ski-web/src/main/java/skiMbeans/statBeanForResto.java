package skiMbeans;


import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import tn.esprit.services.GestionRestoLocal;
import tn.esprit.entities.Resto;

@ManagedBean
public class statBeanForResto {

	@EJB
	GestionRestoLocal csl ;
	
	private BarChartModel barModel;
	

	@PostConstruct
	public void init() {
		createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	////a ajouter

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries stats = new ChartSeries();
		stats.setLabel("Number of Rates");
		List<Resto> ltp = csl.getName();
		for (Resto s : ltp) {
			long number = csl.getNbrParticipationByCathegory(s.getName());
		    stats.set(s.getName(), number);
		}

		model.addSeries(stats);

		return model;
		
//		BarChartModel model = new BarChartModel();
//		 
//        ChartSeries boys = new ChartSeries();
//        boys.setLabel("Boys");
//        List<String> categories = new ArrayList<>();
//        for(Cursus c:csl.getCthegories()){
//        	categories.add(c.getCathegory());
//        }
//        
//        for(String s:categories){
//        	
//        	boys.set(s, csl.getNbrParticipationByCathegory(s));	
//        	
//        }
//        
//       
//        
// 
//        model.addSeries(boys);
//        
//         
//        return model;

	}

	private void createBarModels() {
		createBarModel();

	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("name");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("number of Stars");
		yAxis.setMin(0);
		yAxis.setMax(25);
	}
	
	
}
