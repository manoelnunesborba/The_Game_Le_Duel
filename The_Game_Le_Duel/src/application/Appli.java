package application;

import java.io.IOException;

import joueur.AttributsJoueur;
import joueur.Main;
import table.Jeu;
import table.Pioche;



public class Appli {
	public static void affichageTable(AttributsJoueur NORD, AttributsJoueur SUD) {
		if(AttributsJoueur.tableasc(NORD)>=10 && AttributsJoueur.tabledesc(NORD)>=10)
			System.out.println("NORD ^[" + AttributsJoueur.tableasc(NORD) + "] v[" + AttributsJoueur.tabledesc(NORD) + "] (m" + Main.nmbCarteMain(AttributsJoueur.main(NORD)) + "p" + AttributsJoueur.piochenbr(NORD) + ")");
		else if(AttributsJoueur.tableasc(NORD)<10 && AttributsJoueur.tableasc(NORD)>=10)
			System.out.println("NORD ^[0" + AttributsJoueur.tableasc(NORD) + "] v[" + AttributsJoueur.tabledesc(NORD) + "] (m" + Main.nmbCarteMain(AttributsJoueur.main(NORD)) + "p" + AttributsJoueur.piochenbr(NORD) + ")");
		else if(AttributsJoueur.tableasc(NORD)>=10 && AttributsJoueur.tableasc(NORD)<10)
			System.out.println("NORD ^[" + AttributsJoueur.tableasc(NORD) + "] v[0" + AttributsJoueur.tabledesc(NORD) + "] (m" + Main.nmbCarteMain(AttributsJoueur.main(NORD)) + "p" + AttributsJoueur.piochenbr(NORD) + ")");
		else 
			System.out.println("NORD ^[0" + AttributsJoueur.tableasc(NORD) + "] v[" + AttributsJoueur.tabledesc(NORD) + "] (m" + Main.nmbCarteMain(AttributsJoueur.main(NORD)) + "p" + AttributsJoueur.piochenbr(NORD) + ")");
		if(AttributsJoueur.tableasc(SUD)>=10 && AttributsJoueur.tableasc(SUD)>=10)
			System.out.println("SUD  ^[" + AttributsJoueur.tableasc(SUD) + "] v[" + AttributsJoueur.tabledesc(SUD) + "] (m" + Main.nmbCarteMain(AttributsJoueur.main(SUD)) + "p" + AttributsJoueur.piochenbr(SUD) + ")");
		else if(AttributsJoueur.tableasc(SUD)<10 && AttributsJoueur.tableasc(SUD)>=10)
			System.out.println("SUD  ^[0" + AttributsJoueur.tableasc(SUD) + "] v[" + AttributsJoueur.tabledesc(SUD) + "] (m" + Main.nmbCarteMain(AttributsJoueur.main(SUD)) + "p" + AttributsJoueur.piochenbr(SUD) + ")");
		else if(AttributsJoueur.tableasc(SUD)>=10 && AttributsJoueur.tableasc(SUD)<10)
			System.out.println("SUD  ^[" + AttributsJoueur.tableasc(SUD) + "] v[0" + AttributsJoueur.tabledesc(SUD) + "] (m" + Main.nmbCarteMain(AttributsJoueur.main(SUD)) + "p" + AttributsJoueur.piochenbr(SUD) + ")");
		else
			System.out.println("SUD ^[0" + AttributsJoueur.tableasc(SUD) + "] v[" + AttributsJoueur.tabledesc(SUD) + "] (m" + Main.nmbCarteMain(AttributsJoueur.main(SUD)) + "p" + AttributsJoueur.piochenbr(SUD) + ")");
	}
	
	
	public static void main(String[] args) throws IOException{	
		
		AttributsJoueur Joueur1 = new AttributsJoueur();
		AttributsJoueur Joueur2 = new AttributsJoueur();
		int[] Pioch = new int[58];
		boolean j=true;
		boolean victoire;
		Pioche.init(Pioch);	
		AttributsJoueur.initialiseAttributsJoueur(Joueur1, Pioch);
		AttributsJoueur.initialiseAttributsJoueur(Joueur2, Pioch);		
		do {
			affichageTable(Joueur1, Joueur2);
			if(j) {
				System.out.print("cartes NORD ");
				Pioche.affichage(AttributsJoueur.main(Joueur1));
				if(Jeu.ConditionDefaite(Joueur1, AttributsJoueur.table(Joueur2))) {
					victoire=false;
					break;
				}
				AttributsJoueur.poserCarte1(Joueur1, Joueur2);
				j=false;
				if(Jeu.ConditionVictoire(Joueur1)) {
					victoire=true;
					break;
				}
			}
			else {
				System.out.print("cartes SUD ");
				Pioche.affichage(AttributsJoueur.main(Joueur2));
				if(Jeu.ConditionDefaite(Joueur2, AttributsJoueur.table(Joueur1))) {
					victoire=true;
					break;
				};
				AttributsJoueur.poserCarte1(Joueur2, Joueur1);
				j=true;
				if(Jeu.ConditionVictoire(Joueur2)) {
					victoire=false;
					break;
				}
			}
		}
		while(true);
		if(victoire)
			System.out.println("partie finie, NORD a gagné");
		else
			System.out.println("partie finie, SUD a gagné");
	}
}
