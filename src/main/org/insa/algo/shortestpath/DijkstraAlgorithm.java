package org.insa.algo.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.insa.graph.Arc;
import org.insa.graph.Graph;
import org.insa.graph.Node;
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
    for(int i=0;i<nbNodes;i++)
    	liste_labels[i].setCout(Double.POSITIVE_INFINITY);
   liste_labels[data.getOrigin().getId()].setCout(0);
 
   BinaryHeap<Label> Tas=new BinaryHeap<Label>();
   
   //Initialisation marque
   for(int i=0;i<nbNodes;i++)
   		liste_labels[i].setMarque(false);
   liste_labels[data.getOrigin().getId()].setMarque(true);
   
    // Notify observers about the first event (origin processed).
    notifyOriginProcessed(data.getOrigin());
        
    
    //Creation liste arcs
    Label label_cour;
    List<Arc> list_arcs = new ArrayList<>();
    list_arcs=sommet_cour.getSuccessors();
    
    boolean found=false;
    //boucle 
    while(!found)
    {
    		
    	label_cour=Tas.findMin();
    	Tas.deleteMin();
    	label_cour.setMarque(true);
    	for(Arc arc: label_cour.getSommet_courant().getSuccessors())
    	{
    		if(!label.isMarque())
    	}
    }
    
    
    
    
    
    
    list_arcs=sommet_cour.getSuccessors();
    
    for(int i=0;i<liste_labels.length;i++)
    {
    	for(int j=0;j<list_arcs.size();j++)
    	{
    		if(list_arcs.get(j).getDestination()==liste_labels[i].getSommet_courant())
    		{
    			//calcul du cout pere
    			Node pere = liste_labels[i].getPere();
    			double cout_pere=0;
    			for(int k=0;k<liste_labels.length;k++)
    			{
    				if(liste_labels[i].getSommet_courant()==pere)
    					cout_pere=liste_labels[i].getCout();
    			}
    			//Modification du cout et du pere
    			if(list_arcs.get(j).getLength()+cout_pere<liste_labels[i].getCout())
    			{
    				liste_labels[i].setCout(list_arcs.get(j).getLength()+liste_labels[i].getCout());
    				liste_labels[i].setPere(pere);
    			}
    			
    		}
    	}
    	
    }
    //Recherche du cout minimum
    
    //Modification sommet courant et marque
    
    sommet_cour=liste_labels[i].getSommet_courant();
    
    
    return solution;
    }

}
