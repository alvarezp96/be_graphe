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
    Graph graph = data.getGraph();
    final int nbNodes = graph.size();

	//Initialisation liste labels
    Label[] liste_labels = new Label[nbNodes];
    for(int i=0;i<nbNodes;i++) {
    	liste_labels[i]=newLabel(graph.get(i),data);
    } 
    liste_labels[data.getOrigin().getId()].setCout(0);
	
	//Creation du premier label
    Label depart = newLabel(data.getOrigin(),data);
    depart.setCout(0);
	liste_labels[depart.getSommet_courant().getId()] = depart;

	//Initialisation du Tas
	BinaryHeap<Label> Tas=new BinaryHeap<Label>();
	Tas.insert(depart);
	depart.setinTas();
	depart.setCout(0);
   
    //Initialisation marque
    liste_labels[data.getOrigin().getId()].setMarque();
   
    // Notify observers about the first event (origin processed).
    notifyOriginProcessed(data.getOrigin());
    
    //Creation liste arcs
    List<Arc> succeseurs;

	//found = true si la destination est atteinte	
    boolean found=false;
    
    if(data.getOrigin().getId()==data.getDestination().getId())
    {
    	solution = new ShortestPathSolution(data, Status.INFEASIBLE);
    	found=true;
    }
    
    // Tant qu'il existe des sommets non marqués 
	while(!Tas.isEmpty() && !found){ 
		//label courant
		Label label_cour=Tas.deleteMin();
		notifyNodeMarked(label_cour.getSommet_courant());
		label_cour.setMarque();
		
		if (label_cour.getSommet_courant() == data.getDestination()) {
			found = true;
		}
		succeseurs = label_cour.getSommet_courant().getSuccessors();
		
		//Pour tous les successeurs de l'arc courant
		for(Arc arc_cour : succeseurs) {
			//Creation label de destination
			Label label_d=liste_labels[arc_cour.getDestination().getId()];
			//On verifie l'autorisation de l'arc
			if(!data.isAllowed(arc_cour))
				continue;
			
			if(!label_d.isMarque())
			{
				notifyNodeReached(label_d.getSommet_courant());
				double cout1=label_d.getCout();
				//nouveau cout
				double cout2=label_cour.getCout() + data.getCost(arc_cour);
				//Si le cout 2 est le plus petit, alors on modifie le label de destination
				if(cout2<cout1) {
					label_d.setCout(cout2);
					label_d.setPere(label_cour.getSommet_courant(),arc_cour);
					liste_labels[label_d.getSommet_courant().getId()]=label_d;
					//Si le label est dans le tas, on l'enleve 
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
					//Dans les deux cas, on ajoute le label actualise dans le tas
					Tas.insert(label_d);
				}
			}
		}
	}
	
	//Cas ou la solution n'a pas ete trouvee
	if (liste_labels[data.getDestination().getId()] == null) {
		solution = new ShortestPathSolution(data, Status.INFEASIBLE);
	} 
	else {
		notifyDestinationReached(data.getDestination());
		
		Label label=liste_labels[data.getDestination().getId()];
		ArrayList<Arc> arcs = new ArrayList<>();

		//On recree le chemin a partir de la liste des labels
		while (label.getPere() != null) {
			arcs.add(label.getArc());
			notifyNodeMarked(label.getPere());
			label=liste_labels[label.getPere().getId()];
		}
		//On met le chemin dans le bon ordre
		Collections.reverse(arcs);

		solution = new ShortestPathSolution(data, Status.OPTIMAL, new Path(graph, arcs));

	}  
    
    return solution;
    }

}
