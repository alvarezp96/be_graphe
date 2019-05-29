package org.insa.algo.utils;
import org.insa.algo.AbstractInputData;
import org.insa.algo.shortestpath.ShortestPathData;
import org.insa.graph.*;

public class LabelStar extends Label implements Comparable<Label>{ 
	
	private float estimation;
	
	public LabelStar(Node noeud,ShortestPathData data) {
		super(noeud);
		if(data.getMode()==AbstractInputData.Mode.LENGTH){
			this.estimation=(float) this.sommet_courant.getPoint().distanceTo(data.getDestination().getPoint());
		}
		else{
			int vitesse= Math.max(data.getMaximumSpeed(),data.getGraph().getGraphInformation().getMaximumSpeed());
			this.estimation=((float) this.sommet_courant.getPoint().distanceTo(data.getDestination().getPoint()))/(vitesse*1000.0f/3600.0f);
		}
	}
		
	@Override
	public double getTotalCost(){
		return this.estimation*1f+this.cout*1f;
	}
}