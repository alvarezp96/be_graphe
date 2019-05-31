package org.insa.algo.shortestpath;

import org.junit.Test;
import java.util.concurrent.TimeUnit;

public class Performances {
	@Test
	public void Compare() throws Exception {
		
		System.out.println("#####----- Test de validité sur une carte-----######");
		

		DijkstraTestCode testD = new  DijkstraTestCode();
		long startTime = System.nanoTime();    
		long endTime = System.nanoTime();
		long timeElapsedD = endTime - startTime;
		AStarTestCode testA = new  AStarTestCode();
		long timeElapsedA;
		int origine;
		int destination;
		
		System.out.println();

		System.out.println("#####----- Carte : MIDI-PYRENEES ---------------------------######");
		System.out.println();
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 99259;
		destination = 178923;
		String mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/midi-pyrenees.mapgr";
		
		float moyenne = 0;
		for(int i =0;i<10;i++) {
			testD = new  DijkstraTestCode();
			startTime = System.nanoTime();
			testD.testScenarioSansOraclePerf(mapName,origine,destination);    
			endTime = System.nanoTime();
			timeElapsedD = endTime - startTime;
			testA = new  AStarTestCode();
			startTime = System.nanoTime();
			testA.testScenarioSansOraclePerf(mapName,origine,destination);
			endTime = System.nanoTime();
			timeElapsedA = endTime - startTime;
		    moyenne += ((float)timeElapsedD/(float)timeElapsedA*100-1);
		}
		System.out.println("AStar is " + moyenne/2 + "% faster than Dijkstra in MIDI-PYRENEES");
		System.out.println();
		System.out.println();
		
		
	    System.out.println("#####----- Carte : CARRE DENSE ---------------------------######");
		System.out.println();
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 0;
		destination = 20000;
		mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/carre-dense.mapgr";
		
		moyenne=0;
		for(int i =0;i<2;i++) {
			testD = new  DijkstraTestCode();
			startTime = System.nanoTime();
			testD.testScenarioSansOraclePerf(mapName,origine,destination);    
			endTime = System.nanoTime();
			timeElapsedD = endTime - startTime;
			testA = new  AStarTestCode();
			startTime = System.nanoTime();
			testA.testScenarioSansOraclePerf(mapName,origine,destination);
			endTime = System.nanoTime();
			timeElapsedA = endTime - startTime;
		    moyenne += ((float)timeElapsedD/(float)timeElapsedA*100-1);
		}
		System.out.println("AStar is " + moyenne/2 + "% faster than Dijkstra in CARRE DENSE");
		System.out.println();
		System.out.println();
	    
	    
	    System.out.println("#####----- Carte : Paris ---------------------------######");
		System.out.println();
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 8412;
		destination = 5724;
		mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/paris.mapgr";
		
		moyenne = 0;
		for(int i =0;i<10;i++) {
			testD = new  DijkstraTestCode();
			startTime = System.nanoTime();
			testD.testScenarioSansOraclePerf(mapName,origine,destination);    
			endTime = System.nanoTime();
			timeElapsedD = endTime - startTime;
			testA = new  AStarTestCode();
			startTime = System.nanoTime();
			testA.testScenarioSansOraclePerf(mapName,origine,destination);
			endTime = System.nanoTime();
			timeElapsedA = endTime - startTime;
		    moyenne += ((float)timeElapsedD/(float)timeElapsedA*100-1);
		}
		System.out.println("AStar is " + moyenne/2 + "% faster than Dijkstra in PARIS");
		System.out.println();
		System.out.println();
	}
	 
}