package org.insa.algo.utils;

import org.insa.graph.*;

public class Label implements Comparable<Label>{
	private Node sommet_courant;
	private boolean marque;
	private double cout;
	private Node pere;
	
	public Label(Node noeud) {
		this.sommet_courant=noeud;
		this.marque=false;
		this.cout=Float.POSITIVE_INFINITY;
		this.pere = null;
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

		public void setMarque(boolean marque) {
			this.marque = marque;
		}

		public double getCout() {
			return cout;
		}

		public void setCout(double cout) {
			this.cout = cout;
		}

		public Node getPere() {
			return pere;
		}

		public void setPere(Node pere) {
			this.pere = pere;
		}

		public int compareTo(Label autre) {
			int resultat;
			if (this.getCout() < autre.getCout()) {
				resultat = -1;
			}
			else if (this.getCout() == autre.getCout()) {
				resultat = 0;
			}
			else {
				resultat = 1;
			}
			return resultat;
		}
		

	}


