package Joueur;

import java.io.IOException;
import java.util.Stack;

import Table.Jeu;
import Table.Pioche;
import Table.Table;


public class AttributsJoueur {
	public Pioche pioche;
	public Jeu table;
	public Main main;
	public static void initialiseJoueur(AttributsJoueur joueur, int[] pioche) {
		joueur.table.table = new Table();
		joueur.pioche.pioche = new Stack<Integer>();
		joueur.pioche.nmbpioche =52;
		joueur.main.main = new int [6];
		Table.initialiseTable(joueur.table.table);
		Pioche.liste(pioche, joueur.pioche.pioche);
		Main.initialiseMain(joueur.main.main, joueur.pioche.pioche);
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
	public static boolean poserCarteJoueur(int nombre, boolean asc, AttributsJoueur joueur) {		
		if(!Table.Verifpose(nombre, joueur.table.table, asc)) {			
			return false;
		}		
		if (asc) {			
			joueur.table.table.asc.add(nombre);
			joueur.table.table.carteasc += 1;
			return true;
		}			
		joueur.table.table.desc.add(nombre);
		joueur.table.table.cartedesc += 1;
		return true;
	}
	public static boolean poserCarteJoueurInv(int nombre, boolean asc, AttributsJoueur joueur) {
		
		if(!Table.VerifposeInv(nombre, joueur.table.table, asc)) {			
			return false;
		}		
		if (asc) {
			joueur.table.table.asc.add(nombre);
			joueur.table.table.carteasc += 1;
			return true;
		}		
		joueur.table.table.desc.add(nombre);
		joueur.table.table.cartedesc += 1;
		return true;
	}
	public static void poserCarte1 (AttributsJoueur Joueur1, AttributsJoueur Joueur2) throws IOException{
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
						if(Main.VerifMain(nombre, Joueur1.main.main)) {	
							if(!defausse[Main.defausseCarte(nombre, Joueur1.main.main)]) {
								nmbdefausse += 1;
								defausse[Main.defausseCarte(nombre, Joueur1.main.main)]=true;
							}
							else {
								fct=false;
								break;
							}
							fct=poserCarteJoueur(nombre, asc, Joueur1);
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
					if(Main.VerifMain(nombre, Joueur1.main.main)) {
						if(!defausse[Main.defausseCarte(nombre, Joueur1.main.main)]) {
							nmbdefausse += 1;
							defausse[Main.defausseCarte(nombre, Joueur1.main.main)]=true;
						}
						else {
							fct=false;
							break;
						}
						if(inv) {
							fct=poserCarteJoueurInv(nombre, asc, Joueur2);
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
					if(Main.VerifMain(nombre, Joueur1.main.main)) {	
						if(!defausse[Main.defausseCarte(nombre, Joueur1.main.main)] && nmbdefausse > 0) {
							nmbdefausse += 1;
							defausse[Main.defausseCarte(nombre, Joueur1.main.main)]=true;
							fct=poserCarteJoueur(nombre, asc, Joueur1);							
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
			
				if(Main.VerifMain(nombre, Joueur1.main.main)) {
					if(inv) {
						if(!defausse[Main.defausseCarte(nombre, Joueur1.main.main)] && nmbdefausse > 0) {
							nmbdefausse += 1;
							defausse[Main.defausseCarte(nombre, Joueur1.main.main)]=true;
							fct=poserCarteJoueurInv(nombre, asc, Joueur2);
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
			Table.Valider(Joueur1.table.table);
			Table.Valider(Joueur2.table.table);
			for(int i = 0;i<6;i++) {
				if (defausse[i])
					Joueur1.main.main[i]=0;
			}
			if(inv) {
				int nmb = 2;
				if (nmb>Joueur1.pioche.nmbpioche)nmb= Joueur1.pioche.nmbpioche;
				for(int i=0;i<2;i++) {	
					if(Joueur1.pioche.nmbpioche==0) break;
					Joueur1.main.main[Main.premiervide(Joueur1.main.main)]=Pioche.piocher(Joueur1.pioche.pioche);
					Joueur1.pioche.nmbpioche-=1;
				}
				System.out.println(nmbdefausse + " cartes posées, " + nmb + " cartes piochées");
			}
			else {	
				int nmb = 6 - Main.nmbCarteMain(Joueur1.main.main);	
				if (nmb>Joueur1.pioche.nmbpioche)nmb= Joueur1.pioche.nmbpioche;
				for(int i=0;i<nmb;i++) {	
					if(Joueur1.pioche.nmbpioche==0) break;
					Joueur1.main.main[Main.premiervide(Joueur1.main.main)]=Pioche.piocher(Joueur1.pioche.pioche);
					Joueur1.pioche.nmbpioche-=1;					
				}
				System.out.println(nmbdefausse + " cartes posées, " + nmb + " cartes piochées");
			}
				
		}
		else {
			Table.enlevercarte(Joueur1.table.table);
			Table.enlevercarte(Joueur2.table.table);
			System.out.print('#');
			poserCarte1(Joueur1, Joueur2);
		}
	}
}
