package Joueur;

import java.io.IOException;
import java.util.Stack;

import Table.Jeu;
import Table.Pioche;
import Table.Table;


@SuppressWarnings("unused")
public class AttributsJoueur {
	public Pioche pioche;
	public Table table;
	public Main main;
	public static void initialiseAttributsJoueur(AttributsJoueur AttributsJoueur, int[] pioche) {
		AttributsJoueur.table = new Table();
		AttributsJoueur.pioche = new Pioche();
		AttributsJoueur.pioche.nmbpioche =52;
		AttributsJoueur.main = new Main();
		Table.initialiseTable(AttributsJoueur.table);
		Pioche.liste(pioche, AttributsJoueur.pioche.pioche);
		Main.initialiseMain(AttributsJoueur.main.main, AttributsJoueur.pioche);
	}
	public static String chaine() throws IOException{
	    String tmp = "";
	    char C='\0';		
			while ((C=(char) System.in.read()) !='\n')
			{
				if (C != '\r')  tmp = tmp+C;
		 
			}
				
		return tmp;
    } 
	public static boolean poserCarteAttributsJoueur(int nombre, boolean asc, AttributsJoueur AttributsJoueur) {		
		if(!Table.Verifpose(nombre, AttributsJoueur.table, asc)) {			
			return false;
		}		
		if (asc) {			
			AttributsJoueur.table.asc.add(nombre);
			AttributsJoueur.table.carteasc += 1;
			return true;
		}			
		AttributsJoueur.table.desc.add(nombre);
		AttributsJoueur.table.cartedesc += 1;
		return true;
	}
	public static boolean poserCarteAttributsJoueurInv(int nombre, boolean asc, AttributsJoueur AttributsJoueur) {
		
		if(!Table.VerifposeInv(nombre, AttributsJoueur.table, asc)) {			
			return false;
		}		
		if (asc) {
			AttributsJoueur.table.asc.add(nombre);
			AttributsJoueur.table.carteasc += 1;
			return true;
		}		
		AttributsJoueur.table.desc.add(nombre);
		AttributsJoueur.table.cartedesc += 1;
		return true;
	}
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
				if(Jeu.VerifAsc(ligne.charAt(i))) {
					if (ligne.charAt(i)==94)
						asc = true;						
				}
				else {
					fct = false;
					break;
				}
			}
			if (j==1||j==0) {
				if(Jeu.VerifNmb(ligne.charAt(i))) {
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
				if(Jeu.VerifEsp (ligne.charAt(i))|| Jeu.VerifInv (ligne.charAt(i))) {					
					if(Jeu.VerifEsp(ligne.charAt(i))) {						
						if(Main.VerifMain(nombre, AttributsJoueur1.main.main)) {	
							if(!defausse[Main.defausseCarte(nombre, AttributsJoueur1.main.main)]) {
								nmbdefausse += 1;
								defausse[Main.defausseCarte(nombre, AttributsJoueur1.main.main)]=true;
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
				if(Jeu.VerifEsp(ligne.charAt(i))) {
					if(Main.VerifMain(nombre, AttributsJoueur1.main.main)) {
						if(!defausse[Main.defausseCarte(nombre, AttributsJoueur1.main.main)]) {
							nmbdefausse += 1;
							defausse[Main.defausseCarte(nombre, AttributsJoueur1.main.main)]=true;
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
		if (j==3) {									
					if(Main.VerifMain(nombre, AttributsJoueur1.main.main)) {	
						if(!defausse[Main.defausseCarte(nombre, AttributsJoueur1.main.main)] && nmbdefausse > 0) {
							nmbdefausse += 1;
							defausse[Main.defausseCarte(nombre, AttributsJoueur1.main.main)]=true;
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
			
				if(Main.VerifMain(nombre, AttributsJoueur1.main.main)) {
					if(inv) {
						if(!defausse[Main.defausseCarte(nombre, AttributsJoueur1.main.main)] && nmbdefausse > 0) {
							nmbdefausse += 1;
							defausse[Main.defausseCarte(nombre, AttributsJoueur1.main.main)]=true;
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
					AttributsJoueur1.main.main[i]=0;
			}
			if(inv) {
				int nmb = 2;
				if (nmb>AttributsJoueur1.pioche.nmbpioche)nmb= AttributsJoueur1.pioche.nmbpioche;
				for(int i=0;i<2;i++) {	
					if(AttributsJoueur1.pioche.nmbpioche==0) break;
					AttributsJoueur1.main.main[Main.premiervide(AttributsJoueur1.main.main)]=Pioche.piocher(AttributsJoueur1.pioche.pioche);
					AttributsJoueur1.pioche.nmbpioche-=1;
				}
				System.out.println(nmbdefausse + " cartes posées, " + nmb + " cartes piochées");
			}
			else {	
				int nmb = 6 - Main.nmbCarteMain(AttributsJoueur1.main.main);	
				if (nmb>AttributsJoueur1.pioche.nmbpioche)nmb= AttributsJoueur1.pioche.nmbpioche;
				for(int i=0;i<nmb;i++) {	
					if(AttributsJoueur1.pioche.nmbpioche==0) break;
					AttributsJoueur1.main.main[Main.premiervide(AttributsJoueur1.main.main)]=Pioche.piocher(AttributsJoueur1.pioche.pioche);
					AttributsJoueur1.pioche.nmbpioche-=1;					
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

}
