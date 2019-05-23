package org.insa.algo.utils;
import org.insa.algo.shortestpath.ShortestPathData;
import org.insa.graph.*;

public class LabelStar extends Label implements Comparable<Label>{ 
	
	protected double cout_total;
	protected ShortestPathData data;
	
	public LabelStar(Node noeud,ShortestPathData data) {
		super(noeud);
		this.cout_total=this.cout;
	}
	
	@Override
	public void setCout(double cout) {
		this.cout_total = cout+this.sommet_courant.getPoint().distanceTo(data.getDestination().getPoint());
	}
	
	@Override
	public double getCout() {
		if(this.cout==this.cout_total)
		{
			return this.cout;
		}
		else {
			return this.cout_total;
		}
	}
	
	
}
