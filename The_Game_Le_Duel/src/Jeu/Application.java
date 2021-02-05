package Jeu;

import java.io.IOException;
import Table.Jeu;
import Table.Pioche;
import Joueur.AttributsJoueur;
import Joueur.Main;



public class Application {
	public static void affichageTable(AttributsJoueur NORD, AttributsJoueur SUD) {
		if(NORD.table.table.asc.peek()>=10 && NORD.table.table.desc.peek()>=10)
			System.out.println("NORD ^[" + NORD.table.table.asc.peek() + "] v[" + NORD.table.table.desc.peek() + "] m" + Main.nmbCarteMain(NORD.main.main) + "p" + NORD.pioche.nmbpioche + ")");
		else if(NORD.table.table.asc.peek()<10 && NORD.table.table.desc.peek()>=10)
			System.out.println("NORD ^[0" + NORD.table.table.asc.peek() + "] v[" + NORD.table.table.desc.peek() + "] m" + Main.nmbCarteMain(NORD.main.main) + "p" + NORD.pioche.nmbpioche + ")");
		else if(NORD.table.table.asc.peek()>=10 && NORD.table.table.desc.peek()<10)
			System.out.println("NORD ^[" + NORD.table.table.asc.peek() + "] v[0" + NORD.table.table.desc.peek() + "] m" + Main.nmbCarteMain(NORD.main.main) + "p" + NORD.pioche.nmbpioche + ")");
		else 
			System.out.println("NORD ^[0" + NORD.table.table.asc.peek() + "] v[0" + NORD.table.table.desc.peek() + "] m" + Main.nmbCarteMain(NORD.main.main) + "p" + NORD.pioche.nmbpioche + ")");
		if(SUD.table.table.asc.peek()>=10 && SUD.table.table.desc.peek()>=10)
			System.out.println("SUD  ^[" + SUD.table.table.asc.peek() + "] v[" + SUD.table.table.desc.peek() + "] m" + Main.nmbCarteMain(SUD.main.main) + "p" + SUD.pioche.nmbpioche + ")");
		else if(SUD.table.table.asc.peek()<10 && SUD.table.table.desc.peek()>=10)
			System.out.println("SUD  ^[0" + SUD.table.table.asc.peek() + "] v[" + SUD.table.table.desc.peek() + "] m" + Main.nmbCarteMain(SUD.main.main) + "p" + SUD.pioche.nmbpioche + ")");
		else if(SUD.table.table.asc.peek()>=10 && SUD.table.table.desc.peek()<10)
			System.out.println("SUD  ^[" + SUD.table.table.asc.peek() + "] v[0" + SUD.table.table.desc.peek() + "] m" + Main.nmbCarteMain(SUD.main.main) + "p" + SUD.pioche.nmbpioche + ")");
		else
			System.out.println("SUD ^[0" + SUD.table.table.asc.peek() + "] v[0" + SUD.table.table.desc.peek() + "] m" + Main.nmbCarteMain(SUD.main.main) + "p" + SUD.pioche.nmbpioche + ")");
	}
	
	
	public static void main(String[] args) throws IOException{		
		AttributsJoueur Joueur1 = new AttributsJoueur();
		AttributsJoueur Joueur2 = new AttributsJoueur();
		int[] Pioch = new int[58];
		boolean j=true;
		boolean victoire;
		Pioche.init(Pioch);
		Pioche.melange(Pioch);		
		AttributsJoueur.initialiseJoueur(Joueur1, Pioch);
		Pioche.melange(Pioch);
		AttributsJoueur.initialiseJoueur(Joueur2, Pioch);		
		do {
			affichageTable(Joueur1, Joueur2);
			if(j) {
				System.out.print("cartes NORD ");
				Pioche.affichage(Joueur1.main.main);
				if(Jeu.ConditionDefaite(Joueur1, Joueur2.table.table)) {
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
				Pioche.affichage(Joueur2.main.main);
				if(Jeu.ConditionDefaite(Joueur2, Joueur1.table.table)) {
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
