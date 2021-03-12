package joueur;
import java.util.Arrays;

import table.Pioche;

public class Main {
	private int [] main=new int[6];
	
	/**
	  * @brief Permet d'avoir les valeurs d'une main
	  * @return la main
	  */
	public int[] main() {
		return this.main;
	}
	
	/**
	  * @brief Permet de savoir une carte donnée d'une main
	  * @param[in] i : indice à changer de valeur
	  * @return	la valeur dans l'indice I
	  */
	public int main(int i) {
		return this.main[i];
	}
	/**
	  * @brief Permet de donner une carte à une main
	  * @param[in] i : indice à changer de valeur
	  * @param[in] value : carte pioché par la main
	  * @return	la main
	  */
	public int main(int i,int value) {
		return this.main[i]=value;
	}
	/**
	  * @brief Initialise une main
	  * @param[in-out] main : la main d'un joueur
	  * @param[in] pioche :  La pioche attribué au joueur
	  */
	public static void initialiseMain(int[] main, Pioche pioche) {		
		for(int i=0;i<6;i++) {
			main[i]=Pioche.piocher(pioche.pioche());
		}
		Arrays.sort(main);
	}
	
	
	/**
	  * @brief Savoir le nombre de cartes dans la main d'un joueur
	  * @param[in] main : la main d'un joueur
	  * @return le nmd de cartes en main
	  */
	public static int nmbCarteMain(int[] main) {
		int nmb = 0;
		for(int i=0;i<main.length;i++) {
			if(main[i]!=0)
				nmb+=1;
		}
		return nmb;
	}
	
	
}
