package appli;

import java.io.IOException;

import joueur.AttributsJoueur;
import table.Jeu;
import table.Pioche;



public class Application {
	/**
	  * @brief affichage d'une table
	  * @see toString des AttributsJoueur
	  * @param[in] NORD : La table appartenant à NORD
	  * @param[in] SUD : La table appartenant à SUD
	  */
	public static void affichageTable(AttributsJoueur NORD, AttributsJoueur SUD) {
		System.out.println("NORD "+ NORD);
		System.out.println("SUD "+ SUD);
	}
	
	
	public static void main(String[] args) throws IOException{	
		
		AttributsJoueur Joueur1 = new AttributsJoueur();
		AttributsJoueur Joueur2 = new AttributsJoueur();
		int[] Pioch = new int[58];
		boolean j=true;
		boolean victoire;
		Pioche.init(Pioch);	
		Pioche.melange(Pioch);
		AttributsJoueur.initialiseAttributsJoueur(Joueur1, Pioch);
		Pioche.melange(Pioch);
		AttributsJoueur.initialiseAttributsJoueur(Joueur2, Pioch);		
		
		do {
			affichageTable(Joueur1, Joueur2);
			if(j) {
				System.out.print("cartes NORD ");
				Pioche.toString(AttributsJoueur.main(Joueur1));
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
				Pioche.toString(AttributsJoueur.main(Joueur2));
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
