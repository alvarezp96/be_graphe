package org.insa.algo.shortestpath;

import org.junit.Test;

public class AStarTest {

	@Test
	public void testDoScenarioDistanceParis() throws Exception {
		String mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/paris.mapgr";
		
		AStarTestCode test = new  AStarTestCode();
		int origine;
		int destination;
		
		System.out.println("---- Carte : Paris -------------------------");
		System.out.println("---- Mode : Distance ---------------------------");
		System.out.println();
		
		System.out.println("---- Cas d'un chemin nul ------");
		origine = 0 ;
		destination = 0;
		test.testScenario(mapName, 1,origine,destination);    
		
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 8412;
		destination = 5724;
		test.testScenario(mapName, 1,origine,destination);    	
	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : Existe ------------");
		origine = -1;
		destination = 5724;
		test.testScenario(mapName, 1,origine,destination);    	

		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : Existe ----------------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = 8412;
		destination = 100000;
		test.testScenario(mapName, 1,origine,destination);    	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = -1;
		destination = 100000;
		test.testScenario(mapName, 1,origine,destination);    	
	}

	
	@Test
	public void testDoScenarioTempsParis() throws Exception {
		String mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/paris.mapgr";

		AStarTestCode test = new  AStarTestCode();
		int origine;
		int destination;
		
		System.out.println("---- Carte : Paris -------------------------");
		System.out.println("---- Mode : Temps ---------------------------");
		System.out.println();
		
		System.out.println("---- Cas d'un chemin nul ------");
		origine = 0 ;
		destination = 0;
		test.testScenario(mapName, 0,origine,destination);    
		
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 8412;
		destination = 5724;
		test.testScenario(mapName, 0,origine,destination);    	
	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : Existe ------------");
		origine = -1;
		destination = 5724;
		test.testScenario(mapName, 0,origine,destination);    	

		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : Existe ----------------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = 8412;
		destination = 100000;
		test.testScenario(mapName, 0,origine,destination);    	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = -1;
		destination = 100000;
		test.testScenario(mapName, 0,origine,destination);
	}

	@Test
	public void testDoScenarioDistanceMidi_Pyrenees() throws Exception {

		String mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/midi-pyrenees.mapgr";

		AStarTestCode test = new  AStarTestCode();
		int origine;
		int destination;
		
		System.out.println("---- Carte : Midi-Pyrénées -------------------------");
		System.out.println("---- Mode : Distance ---------------------------");
		System.out.println();
		
		System.out.println("---- Cas d'un chemin nul ------");
		origine = 0 ;
		destination = 0;
		test.testScenario(mapName, 1,origine,destination);    
		
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 99259;
		destination = 178923;
		test.testScenario(mapName, 1,origine,destination);   
	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : Existe ------------");
		origine = -1;
		destination = 178923;
		test.testScenario(mapName, 1,origine,destination);    	

		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : Existe ----------------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = 99259;
		destination = 800000;
		test.testScenario(mapName, 1,origine,destination);    	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = -1;
		destination = 800000;
		test.testScenario(mapName, 1,origine,destination);
	}

	@Test
	public void testDoScenarioTempsMidi_Pyrenees() throws Exception {
		String mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/insa.mapgr";

		AStarTestCode test = new  AStarTestCode();
		int origine;
		int destination;
		
		System.out.println("---- Carte : Midi-Pyrénées -------------------------");
		System.out.println("---- Mode : Temps ---------------------------");
		System.out.println();
		
		System.out.println("---- Cas d'un chemin nul ------");
		origine = 0 ;
		destination = 0;
		test.testScenario(mapName, 0,origine,destination);    
		
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 99259;
		destination = 178923;
		test.testScenario(mapName, 0,origine,destination);    	
	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : Existe ------------");
		origine = -1;
		destination = 178923;
		test.testScenario(mapName, 0,origine,destination);    	

		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : Existe ----------------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = 99259;
		destination = 800000;
		test.testScenario(mapName, 0,origine,destination);    	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = -1;
		destination = 800000;
		test.testScenario(mapName, 0,origine,destination);
	}
	
	@Test
	public void testDoScenarioDistanceCarreDense() throws Exception {

		String mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/carre-dense.mapgr";

		AStarTestCode test = new  AStarTestCode();
		int origine;
		int destination;
		
		System.out.println("---- Carte : Carré Dense -------------------------");
		System.out.println("---- Mode : Distance ---------------------------");
		System.out.println();
		
		System.out.println("---- Cas d'un chemin nul ------");
		origine = 0 ;
		destination = 0;
		test.testScenario(mapName, 1,origine,destination);    
		
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 323949;
		destination = 342678;
		test.testScenario(mapName, 1,origine,destination);    	
	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : Existe ------------");
		origine = -1;
		destination = 342678;
		test.testScenario(mapName, 1,origine,destination);    	

		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : Existe ----------------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = 323949;
		destination = 800000;
		test.testScenario(mapName, 1,origine,destination);    	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = -1;
		destination = 800000;
		test.testScenario(mapName, 1,origine,destination);	
	}

	@Test
	public void testDoScenarioTempsCarreDense() throws Exception {
		String mapName = "/home/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/carre-dense.mapgr";
		

		AStarTestCode test = new  AStarTestCode();
		int origine;
		int destination;
		
		System.out.println("---- Carte : Carré Dense -------------------------");
		System.out.println("---- Mode : Temps ---------------------------");
		System.out.println();

		System.out.println("---- Cas d'un chemin nul ------");
		origine = 0 ;
		destination = 0;
		test.testScenario(mapName, 0,origine,destination);    
		
		System.out.println("----- Cas d'un chemin simple ------");
		origine = 323949;
		destination = 342678;
		test.testScenario(mapName, 0,origine,destination);    	
	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : Existe ------------");
		origine = -1;
		destination = 342678;
		test.testScenario(mapName, 0,origine,destination);    	

		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : Existe ----------------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = 323949;
		destination = 800000;
		test.testScenario(mapName, 0,origine,destination);    	
		
		System.out.println("----- Cas de sommets inexistants ------");
		System.out.println("----- Origine : N'existe pas ----------");
		System.out.println("----- Destination : N'existe pas ------");
		origine = -1;
		destination = 800000;
		test.testScenario(mapName, 0,origine,destination);		
	}
}