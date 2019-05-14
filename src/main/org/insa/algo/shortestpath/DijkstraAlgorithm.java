package org.insa.algo.shortestpath;

import java.util.*;
import java.util.Arrays;
import java.util.List;

import org.insa.graph.*;
import org.insa.algo.AbstractSolution.Status;
import org.insa.algo.utils.*;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {
    ShortestPathData data = getInputData();
    ShortestPathSolution solution = null;
    //TODO 
    
    Graph graph = data.getGraph();

    final int nbNodes = graph.size();

    // Initialize array of distances.
    Label[] liste_labels = new Label[nbNodes];
    
    for(int i=0;i<nbNodes;i++) {
    	liste_labels[i]=new Label(graph.get(i));
    }
    
   liste_labels[data.getOrigin().getId()].setCout(0);
 
   BinaryHeap<Label> Tas=new BinaryHeap<Label>();
   
    Label deb = new Label(data.getOrigin(),true);
	liste_labels[deb.getSommet_courant().getId()] = deb;
	deb.setinTas();
	deb.setCout(0);
	Tas.insert(deb);
   
   
   //Initialisation marque
   
   liste_labels[data.getOrigin().getId()].setMarque();
   
    // Notify observers about the first event (origin processed).
    notifyOriginProcessed(data.getOrigin());
        
    
    //Creation liste arcs
    
    Arc[] list_arcs = new Arc[nbNodes];
    
    List<Arc> succeseurs;
    
    
    boolean found=false;
    
    
    /* Tant qu'il existe des sommets non marqués */
	while(!Tas.isEmpty() && !found){ 
		Label label_cour;
		label_cour=Tas.deleteMin();
		notifyNodeMarked(label_cour.getSommet_courant());
		label_cour.setMarque();
		
		if (label_cour.getSommet_courant() == data.getDestination()) {
			found = true;
		}
    
		succeseurs = label_cour.getSommet_courant().getSuccessors();
		for(Arc arc_cour : succeseurs) {
			boolean change = false;
		
			if(!liste_labels[arc_cour.getDestination().getId()].isMarque())
			{
				double cout1=liste_labels[arc_cour.getDestination().getId()].getCout();
				double cout2=label_cour.getCout()+ arc_cour.getLength();
				//cout min
				
				if(cout2<cout1) {
					liste_labels[arc_cour.getDestination().getId()].setCout(cout2);
					change=true;
					}
			if(change) {
				try {
					Tas.remove(liste_labels[arc_cour.getDestination().getId()]);
				}
				catch (ElementNotFoundException e) {}
			}
			
			Tas.insert(liste_labels[arc_cour.getDestination().getId()]);
			liste_labels[arc_cour.getDestination().getId()].setPere(label_cour.getSommet_courant(),arc_cour);
				
				
			}
		}
	}
	
	if (list_arcs[data.getDestination().getId()] == null) {
		solution = new ShortestPathSolution(data, Status.INFEASIBLE);
	} else {
		
		notifyDestinationReached(data.getDestination());

		ArrayList<Arc> arcs = new ArrayList<>();
		Arc arc = list_arcs[data.getDestination().getId()];

		while (arc != null) {
			arcs.add(arc);
			arc = list_arcs[arc.getOrigin().getId()];
		}

		Collections.reverse(arcs);

		solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, arcs));

	}  
    
    return solution;
    }

}
