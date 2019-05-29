package org.insa.algo.shortestpath;

import java.util.*;

import org.insa.graph.*;
import org.insa.algo.AbstractSolution.Status;
import org.insa.algo.utils.*;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    public Label newLabel(Node node, ShortestPathData data) {
    	return new Label(node);
    }
    
    @Override
    protected ShortestPathSolution doRun() {
    	
    ShortestPathData data = getInputData();
    ShortestPathSolution solution = null;
    //TODO 
    
    Graph graph = data.getGraph();

    final int nbNodes = graph.size();

    // Initialize array of distances
    Label[] liste_labels = new Label[nbNodes];
    
    for(int i=0;i<nbNodes;i++) {
    	liste_labels[i]=newLabel(graph.get(i),data);
    }
    
   liste_labels[data.getOrigin().getId()].setCout(0);
 
    BinaryHeap<Label> Tas=new BinaryHeap<Label>();
   
    Label deb = newLabel(data.getOrigin(),data);
    deb.setCout(0);
	liste_labels[deb.getSommet_courant().getId()] = deb;
	Tas.insert(deb);
	deb.setinTas();
	deb.setCout(0);
   
   
   //Initialisation marque
   
   liste_labels[data.getOrigin().getId()].setMarque();
   
    // Notify observers about the first event (origin processed).
    notifyOriginProcessed(data.getOrigin());
    
    //Creation liste arcs
    
    List<Arc> succeseurs;
    	
    boolean found=false;
    
    if(data.getOrigin()==data.getDestination())
    {
    	found=true;
    }
    
    
    /* Tant qu'il existe des sommets non marqués */
	while(!Tas.isEmpty() && !found){ 
		Label label_cour=Tas.deleteMin();
		notifyNodeMarked(label_cour.getSommet_courant());
		label_cour.setMarque();
		
		if (label_cour.getSommet_courant() == data.getDestination()) {
			found = true;
		}
		succeseurs = label_cour.getSommet_courant().getSuccessors();
		for(Arc arc_cour : succeseurs) {
			Label label_d=liste_labels[arc_cour.getDestination().getId()];
			
			if(!data.isAllowed(arc_cour))
				continue;
			
			if(!label_d.isMarque())
			{
				notifyNodeReached(label_d.getSommet_courant());
				double cout1=label_d.getCout();
				double cout2=label_cour.getCout()+ data.getCost(arc_cour);
				//cout min
				
				if(cout2<cout1) {
					label_d.setCout(cout2);
					label_d.setPere(label_cour.getSommet_courant(),arc_cour);
					liste_labels[label_d.getSommet_courant().getId()]=label_d;
					if(label_d.getinTas())
					{
						try {
							Tas.remove(label_d);
						}
						catch (ElementNotFoundException e) {}
					}
					else {
						label_d.setinTas();
					}
					Tas.insert(label_d);
				}
				
			
			}
		}
	}
	
	if (liste_labels[data.getDestination().getId()] == null) {
		solution = new ShortestPathSolution(data, Status.INFEASIBLE);
	} else {
		
		notifyDestinationReached(data.getDestination());
		
		Label label=liste_labels[data.getDestination().getId()];
		ArrayList<Arc> arcs = new ArrayList<>();
		while (label.getPere() != null) {
			
			arcs.add(label.getArc());
			notifyNodeMarked(label.getPere());
			label=liste_labels[label.getPere().getId()];
		}

		Collections.reverse(arcs);

		solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, arcs));

	}  
    
    return solution;
    }

}
