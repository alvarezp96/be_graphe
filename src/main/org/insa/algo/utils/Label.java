package org.insa.algo.utils;

import org.insa.graph.*;

public class Label implements Comparable<Label>{
	protected Node sommet_courant;
	protected boolean marque;
	protected double cout;
	protected Node pere;
	protected Arc arc;
	protected boolean inTas;
	
	public Label(Node noeud) {
		this.sommet_courant=noeud;
		this.marque=false;
		this.cout=Float.POSITIVE_INFINITY;
		this.pere = null;
		this.arc=null;
		this.inTas=false;
		}

		
		public Node getSommet_courant() {
			return sommet_courant;
		}

		public void setSommet_courant(Node sommet_courant) {
			this.sommet_courant = sommet_courant;
		}

		public boolean isMarque() {
			return marque;
		}

		public void setMarque() {
			marque = true;
		}

		public double getCout() {
			return cout;
		}
		
		public double getTotalCost() {
			return this.cout;
		}
		
		public void setTotalCost(double cout) {
			this.cout = cout;
		}

		public void setCout(double cout) {
			this.cout = cout;
		}

		public Node getPere() {
			return pere;
		}
		public Arc getArc() {
			return arc;
		}

		public void setPere(Node pere, Arc arc) {
			this.pere = pere;
			this.arc=arc;
			
		}
		
		public void setinTas() {
			this.inTas=true;
		}
		
		public boolean getinTas() {
			return this.inTas;
		}
		
		

		public int compareTo(Label autre) {
			int resultat;
			if (this.getTotalCost() < autre.getTotalCost()) {
				resultat = -1;
			}
			else if (this.getTotalCost() == autre.getTotalCost()) {
				resultat = 0;
			}
			else {
				resultat = 1;
			}
			return resultat;
		}
		

	}


