package org.insa.algo.shortestpath;

import org.insa.algo.utils.*;
import org.insa.graph.Node;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    @Override
    public LabelStar newLabel(Node node, ShortestPathData data) {
    	return new LabelStar(node,data);
    }
    
}
