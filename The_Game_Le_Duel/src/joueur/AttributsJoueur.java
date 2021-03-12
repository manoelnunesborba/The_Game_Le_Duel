package joueur;

import java.io.IOException;
import java.text.DecimalFormat;
import table.Pioche;
import table.Table;



public class AttributsJoueur {
	private Pioche pioche;
	private Table table;
	private Main main;
	/**
	  * @brief Permet de piocher une carte
	  * @param[in] AttributsJoueur : Le joueur qui pioche
	  * @return	la carte pioché
	  */
	public static int piochenbr(AttributsJoueur AttributsJoueur) {
		return AttributsJoueur.pioche.nmbpioche();
	}
	
	/**
	  * @brief Permet de voir la carte ascendente
	  * @param[in] AttributsJoueur : Le joueur 
	  * @return	la valeur de la carte
	  */
	public static int tableasc(AttributsJoueur AttributsJoueur) {
		return AttributsJoueur.table.ascpeek();
	}
	/**
	  * @brief Permet de voir la carte desscendente
	  * @param[in] AttributsJoueur : Le joueur 
	  * @return	la valeur de la carte
	  */
	public static int tabledesc(AttributsJoueur AttributsJoueur) {
		return AttributsJoueur.table.descpeek();
	}
	
	
	/**
	  * @brief Permet d'avoir la table d'un joueur
	  * @param[in] AttributsJoueur : Le joueur 
	  * @return	la table
	  */
	public static Table table(AttributsJoueur AttributsJoueur) {
		return AttributsJoueur.table;
	}
	
	
	/**
	  * @brief Permet d'avoir la main d'un joueur
	  * @param[in] AttributsJoueur : Le joueur 
	  * @return	la main de ce joueur
	  */
	public static int[] main(AttributsJoueur AttributsJoueur) {
		return AttributsJoueur.main.main();
	}
	
	
	/**
	  * @brief Donne la valeur de main dans l'indice I
	  * @param[in] AttributsJoueur : Le joueur 
	  * @param[in] i: L'indice
	  * @return	la valeur recherché
	  */
	public static int main(AttributsJoueur AttributsJoueur, int i) {
		return AttributsJoueur.main.main(i);
	}
	
	/**
	  * @brief Initialise tout les attributs d'un joueur
	  * @param[in] AttributsJoueur : Le joueur 
	  * @param[in] pioche: la pioche de joueur
	  */
	public static void initialiseAttributsJoueur(AttributsJoueur AttributsJoueur, int[] pioche) {
		AttributsJoueur.table = new Table();
		AttributsJoueur.pioche = new Pioche();
		AttributsJoueur.pioche.nmbpioche(52);
		AttributsJoueur.main = new Main();
		Table.initialiseTable(AttributsJoueur.table);
		Pioche.liste(pioche, AttributsJoueur.pioche.pioche());
		Main.initialiseMain(AttributsJoueur.main.main(), AttributsJoueur.pioche);
	}
	
	
	/**
	  * @brief Lecture clavier
	  * @return Le phrase écrite
	  */
	private static String chaine() throws IOException{
	    String tmp = "";
	    char C='\0';		
			while ((C=(char) System.in.read()) !='\n')
			{
				if (C != '\r')  tmp = tmp+C;
		 
			}
				
		return tmp;
    } 
	
	/**
	  * @brief Si peut poser une carte sur une des piles du joueur qui joue
	  * @param[in] nombre : Le joueur 
	  * @param[in] asc :Si c'est ascendent ou pas
	  * @param[in] AttributsJoueur : Le joueur 
	  * @param[out] True ou false
	  */
	private static boolean poserCarteAttributsJoueur(int nombre, boolean asc, AttributsJoueur AttributsJoueur) {		
		if(!Table.Verifpose(nombre, AttributsJoueur.table, asc)) {			
			return false;
		}		
		if (asc) {			
			AttributsJoueur.table.ascadd(nombre);
			AttributsJoueur.table.Lacarteascadd(1);
			return true;
		}			
		AttributsJoueur.table.descadd(nombre);
		AttributsJoueur.table.Lacartedescadd(1);
		return true;
	}
	
	/**
	  * @brief Si peut poser une carte sur une des piles du joueur qui joue (La pile inverse)
	  * @param[in] nombre : Le joueur 
	  * @param[in] asc :Si c'est ascendent ou pas
	  * @param[in] AttributsJoueur : Le joueur 
	  * @param[out] True ou false
	  */
	private static boolean poserCarteAttributsJoueurInv(int nombre, boolean asc, AttributsJoueur AttributsJoueur) {
		
		if(!Table.VerifposeInv(nombre, AttributsJoueur.table, asc)) {			
			return false;
		}		
		if (asc) {
			AttributsJoueur.table.ascadd(nombre);
			AttributsJoueur.table.Lacarteascadd(1);
			return true;
		}		
		AttributsJoueur.table.descadd(nombre);
		AttributsJoueur.table.Lacartedescadd(1);
		return true;
	}
	
	
	
	/**
	  * @brief A voir
	  * @param[in] AttributsJoueur1 : Le joueur1 
	  * @param[in] AttributsJoueur2 : Le joueur2
	  */
	public static void poserCarte1 (AttributsJoueur AttributsJoueur1, AttributsJoueur AttributsJoueur2) throws IOException{
		System.out.print("> ");		
		String ligne =chaine();
		int nmbdefausse = 0;
		boolean [] defausse = new boolean [6];
		for(int i = 0; i<6;i++) {
			defausse[i]=false;
		}
		boolean fct = true;
		boolean asc = false;
		boolean inv = true;
		int nombre = 0;
		int j = 0;
		for(int i = 0; i<ligne.length(); i++) {
			
			if(j==2) {				
				if(VerifAsc(ligne.charAt(i))) {
					if (ligne.charAt(i)==94)
						asc = true;						
				}
				else {
					fct = false;
					break;
				}
			}
			if (j==1||j==0) {
				if(VerifNmb(ligne.charAt(i))) {
					if(j==0)
						nombre = (ligne.charAt(i)-48)*10;
					if(j==1)
						nombre += ligne.charAt(i)-48;
				}
				else {
					fct = false;
					break;
				}
			}
			if (j==3) {
				if(VerifEsp (ligne.charAt(i))|| VerifInv (ligne.charAt(i))) {					
					if(VerifEsp(ligne.charAt(i))) {						
						if(VerifMain(nombre, AttributsJoueur1.main.main())) {	
							if(!defausse[defausseCarte(nombre, AttributsJoueur1.main.main())]) {
								nmbdefausse += 1;
								defausse[defausseCarte(nombre, AttributsJoueur1.main.main())]=true;
							}
							else {
								fct=false;
								break;
							}
							fct=poserCarteAttributsJoueur(nombre, asc, AttributsJoueur1);
							j=0;
							asc=false;
							continue;
						}
						else {
							fct = false;
							break;
						}
					}					
				}
				else {
					fct = false;
					break;
				}
			}
			if (j==4) {				
				if(VerifEsp(ligne.charAt(i))) {
					if(VerifMain(nombre, AttributsJoueur1.main.main())) {
						if(!defausse[defausseCarte(nombre, AttributsJoueur1.main.main())]) {
							nmbdefausse += 1;
							defausse[defausseCarte(nombre, AttributsJoueur1.main.main())]=true;
						}
						else {
							fct=false;
							break;
						}
						if(inv) {
							fct=poserCarteAttributsJoueurInv(nombre, asc, AttributsJoueur2);
							j=0;
							asc=false;
							inv=false;
							continue;
						}
						else {
							fct = false;
							break;
						}
					}
					else {
						fct = false;
						break;
					}
				}
				else {
					fct = false;
					break;
				}
			}
			if(!fct) break;
			j++;
		}
		if (j<3)fct=false;
		if (j==3) {									
					if(VerifMain(nombre, AttributsJoueur1.main.main())) {	
						if(!defausse[defausseCarte(nombre, AttributsJoueur1.main.main())] && nmbdefausse > 0) {
							nmbdefausse += 1;
							defausse[defausseCarte(nombre, AttributsJoueur1.main.main())]=true;
							fct=poserCarteAttributsJoueur(nombre, asc, AttributsJoueur1);							
							j=0;
						}
						else {
							fct=false;							
						}
												
					}
					else {
						fct = false;						
					}
				
			
		}
		if (j==4) {	
			
				if(VerifMain(nombre, AttributsJoueur1.main.main())) {
					if(inv) {
						if(!defausse[defausseCarte(nombre, AttributsJoueur1.main.main())] && nmbdefausse > 0) {
							nmbdefausse += 1;
							defausse[defausseCarte(nombre, AttributsJoueur1.main.main())]=true;
							fct=poserCarteAttributsJoueurInv(nombre, asc, AttributsJoueur2);
							inv=false;
							j=0;	
						}
						else {
							fct=false;							
						}
					}
					else {
						fct = false;						
					}
				}
				else {
					fct = false;					
				}
			
		}				
		if(fct) {
			Table.Valider(AttributsJoueur1.table);
			Table.Valider(AttributsJoueur2.table);
			for(int i = 0;i<6;i++) {
				if (defausse[i])
					AttributsJoueur1.main.main(i,0);
			}
			if(inv) {
				int nmb = 2;
				if (nmb>AttributsJoueur1.pioche.nmbpioche())nmb= AttributsJoueur1.pioche.nmbpioche();
				for(int i=0;i<2;i++) {	
					if(AttributsJoueur1.pioche.nmbpioche()==0) break;
					AttributsJoueur1.main.main()[premiervide(AttributsJoueur1.main.main())]=Pioche.piocher(AttributsJoueur1.pioche.pioche());
					AttributsJoueur1.pioche.nmbpiocheD(1);
				}
				System.out.println(nmbdefausse + " cartes posées, " + nmb + " cartes piochées");
			}
			else {	
				int nmb = 6 - Main.nmbCarteMain(AttributsJoueur1.main.main());	
				if (nmb>AttributsJoueur1.pioche.nmbpioche())nmb= AttributsJoueur1.pioche.nmbpioche();
				for(int i=0;i<nmb;i++) {	
					if(AttributsJoueur1.pioche.nmbpioche()==0) break;
					AttributsJoueur1.main.main(premiervide(AttributsJoueur1.main.main()),Pioche.piocher(AttributsJoueur1.pioche.pioche()));
					AttributsJoueur1.pioche.nmbpiocheD(1);					
				}
				System.out.println(nmbdefausse + " cartes posées, " + nmb + " cartes piochées");
			}
				
		}
		else {
			Table.enlevercarte(AttributsJoueur1.table);
			Table.enlevercarte(AttributsJoueur2.table);
			System.out.print('#');
			poserCarte1(AttributsJoueur1, AttributsJoueur2);
		}
	}
	
	
	/**
	  * @brief Donne l'indice si une carte de la main est à 0
	  * @param[in] main : Le joueur 
	  * @return i pour l'indice en question
	  * @return 7 si la main est pleine
	  */
	private static int premiervide(int[] main) {
		for(int i=0;i<main.length;i++) {
			if(main[i]==0)
				return i;
		}
		return 7;
	}
	
	
	/**
	  * @brief verifie si un nombre donné est présent dans la main
	  * @param[in] main : Le joueur 
	  * @param[in] nombre : une carte
	  * @return true ou false
	  */
	private static boolean VerifMain (int nombre, int[] main) { /**/
		if (nombre==0) return false;
		for(int i=0; i<6; i++) {
			if(nombre==main[i])
				return true;
		}
		return false;
	}
	
	/**
	  * @brief vérifie si une carte donné est presente dans la main
	  * @param[in] main : Le joueur 
	  * @param[in] nombre : une carte
	  * @return I :l'indice ou nombre==main
	  * @return 7 :  main est pleine
	  */
	private static int defausseCarte(int nombre, int[] main) {
		for(int i=0;i<6;i++)
			if(nombre==main[i])
				return i;
		return 7;
	}
	
	
	
	public String  toString() {
			DecimalFormat df = new DecimalFormat("00");
			return "^[" + df.format(AttributsJoueur.tableasc(this)) + "] v[" + df.format(AttributsJoueur.tabledesc(this)) + "] (m" + df.format(Main.nmbCarteMain(AttributsJoueur.main(this))) + "p" + df.format(AttributsJoueur.piochenbr(this)) + ")";
	}

	/*Verif des ASCII*/
	
	
	/**
	  * @brief Vérifie le signe "^" ou "v" est présent
	  * @param[in-out] signe : le char à être examiné
	  * @return true et false
	  */
	public static boolean VerifAsc (char signe) {
		if (signe == 94 || signe == 118)
			return true;
		return false;
	}
	
	
	/**
	  * @brief Vérifie des nombres sont présentes (0-9)
	  * @param[in-out] signe : le char à être examiné
	  * @return true et false
	  */
	public static boolean VerifNmb (char signe) {
		if (signe > 47 && signe < 58)
			return true;
		return false;
	}
	/**
	  * @brief Vérifie le signe " "(espace) est présent
	  * @param[in-out] signe : le char à être examiné
	  * @return true et false
	  */
	public static boolean VerifEsp (char signe) {
		if (signe == 32)
			return true;
		return false;
	}
	/**
	  * @brief Vérifie le signe ' est présent
	  * @param[in-out] signe : le char à être examiné
	  * @return true et false
	  */
	public static boolean VerifInv (char signe) {		
		if (signe == 39) {			
			return true;			
			}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
