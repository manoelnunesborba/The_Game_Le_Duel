package Table;


import Joueur.AttributsJoueur;
import Joueur.Main;



public class Jeu {
	public static int CarteJouable(AttributsJoueur joueur, Table opposé) {
		int retour = 0;
		boolean inv = true;
		for (int i = 0; i<6; i++) {
			if(joueur.main.main[i]!=0 && (joueur.main.main[i]<joueur.table.desc.peek() || joueur.main.main[i]>joueur.table.asc.peek())) {
				retour += 1;
			}
			else if (joueur.main.main[i]!=0 && inv && (joueur.main.main[i]>opposé.desc.peek() || joueur.main.main[i]<opposé.asc.peek())) {
				inv=false;
				retour += 1;
			}
		}
		return retour;
		
	}
	public static boolean ConditionDefaite(AttributsJoueur joueur, Table opposé) {
		int nmbCarte = Main.nmbCarteMain(joueur.main.main);
		int jouable = 0;
		if (nmbCarte==1) return true;
		jouable += CarteJouable(joueur, opposé);
		if (jouable>1) return false;
		return true;
	}
	
	public static boolean ConditionVictoire(AttributsJoueur joueur) { /*Et la pioche vide ?*/
		if(Main.nmbCarteMain(joueur.main.main)==0) return true;
		return false;
	}
	
	/*Verif des ASCII*/
	public static boolean VerifAsc (char signe) {
		if (signe == 94 || signe == 118)
			return true;
		return false;
	}
	
	public static boolean VerifNmb (char signe) {
		if (signe > 47 && signe < 58)
			return true;
		return false;
	}
	
	public static boolean VerifEsp (char signe) {
		if (signe == 32)
			return true;
		return false;
	}
	
	public static boolean VerifInv (char signe) {		
		if (signe == 39) {			
			return true;			
			}
		return false;
	}
}
