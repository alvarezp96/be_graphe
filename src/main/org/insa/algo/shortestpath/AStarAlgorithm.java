package org.insa.algo.shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.insa.algo.AbstractSolution.Status;
import org.insa.algo.utils.*;
import org.insa.graph.Arc;
import org.insa.graph.Graph;
import org.insa.graph.Node;
import org.insa.graph.Path;

public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }
    
    @Override
    public LabelStar newLabel(Node node, ShortestPathData data) {
    	return new LabelStar(node,data);
    }
    
}
