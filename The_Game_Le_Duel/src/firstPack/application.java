package firstPack;

import java.util.Stack;
import java.io.IOException;


public class application {
	
	public static void init(int[] pi) {

		for(int i=0;i<pi.length;i++) {
			pi[i]=i+2;
		}
	}
	public static int nmbCarteMain(int[] main) {
		int nmb = 0;
		for(int i=0;i<main.length;i++) {
			if(main[i]!=0)
				nmb+=1;
		}
		return nmb;
	}
	public static int premiervide(int[] main) {
		for(int i=0;i<main.length;i++) {
			if(main[i]==0)
				return i;
		}
		return 7;
	}
	public static int CarteJouable(Joueur joueur, Table opposé) {
		int retour = 0;
		boolean inv = true;
		for (int i = 0; i<6; i++) {
			if(joueur.main[i]!=0 && (joueur.main[i]<joueur.table.desc.peek() || joueur.main[i]>joueur.table.asc.peek())) {
				retour += 1;
			}
			else if (joueur.main[i]!=0 && inv && (joueur.main[i]>opposé.desc.peek() || joueur.main[i]<opposé.asc.peek())) {
				inv=false;
				retour += 1;
			}
		}
		return retour;
	}
	
	public static boolean ConditionDefaite(Joueur joueur, Table opposé) {
		int nmbCarte = nmbCarteMain(joueur.main);
		int jouable = 0;
		if (nmbCarte==1) return true;
		jouable += CarteJouable(joueur, opposé);
		if (jouable>1) return false;
		return true;
	}
	
	public static boolean ConditionVictoire(Joueur joueur) {
		if(nmbCarteMain(joueur.main)==0) return true;
		return false;
	}
	
	public static void affichageTable(Joueur NORD, Joueur SUD) {
		if(NORD.table.asc.peek()>=10 && NORD.table.desc.peek()>=10)
			System.out.println("NORD ^[" + NORD.table.asc.peek() + "] v[" + NORD.table.desc.peek() + "] m" + nmbCarteMain(NORD.main) + "p" + NORD.nmbpioche + ")");
		else if(NORD.table.asc.peek()<10 && NORD.table.desc.peek()>=10)
			System.out.println("NORD ^[0" + NORD.table.asc.peek() + "] v[" + NORD.table.desc.peek() + "] m" + nmbCarteMain(NORD.main) + "p" + NORD.nmbpioche + ")");
		else if(NORD.table.asc.peek()>=10 && NORD.table.desc.peek()<10)
			System.out.println("NORD ^[" + NORD.table.asc.peek() + "] v[0" + NORD.table.desc.peek() + "] m" + nmbCarteMain(NORD.main) + "p" + NORD.nmbpioche + ")");
		else 
			System.out.println("NORD ^[0" + NORD.table.asc.peek() + "] v[0" + NORD.table.desc.peek() + "] m" + nmbCarteMain(NORD.main) + "p" + NORD.nmbpioche + ")");
		if(SUD.table.asc.peek()>=10 && SUD.table.desc.peek()>=10)
			System.out.println("SUD  ^[" + SUD.table.asc.peek() + "] v[" + SUD.table.desc.peek() + "] m" + nmbCarteMain(SUD.main) + "p" + SUD.nmbpioche + ")");
		else if(SUD.table.asc.peek()<10 && SUD.table.desc.peek()>=10)
			System.out.println("SUD  ^[0" + SUD.table.asc.peek() + "] v[" + SUD.table.desc.peek() + "] m" + nmbCarteMain(SUD.main) + "p" + SUD.nmbpioche + ")");
		else if(SUD.table.asc.peek()>=10 && SUD.table.desc.peek()<10)
			System.out.println("SUD  ^[" + SUD.table.asc.peek() + "] v[0" + SUD.table.desc.peek() + "] m" + nmbCarteMain(SUD.main) + "p" + SUD.nmbpioche + ")");
		else
			System.out.println("SUD ^[0" + SUD.table.asc.peek() + "] v[0" + SUD.table.desc.peek() + "] m" + nmbCarteMain(SUD.main) + "p" + SUD.nmbpioche + ")");
	}
	public static void affichage(int[] pi) {
		System.out.print("{ ");

		for(int i=0;i<pi.length;i++) {			
			if(pi[i]!=0) {
				if(pi[i]<10)
					System.out.print("0");
				System.out.print(pi[i] + " ");
			}
			
		}
		System.out.println("}");		
	}
	
	public static void melange(int[] pi) {
		for(int i=pi.length-1;i>=1;i--) {		
			int hasard=(int) Math.floor(Math.random()*(i+1));
			int tmp=pi[i];
			pi[i]=pi[hasard];
			pi[hasard]=tmp;
		}
		for(int i=0;i<pi.length;i++) {
			if(pi[i]==1) {
				int temp=pi[0];
				pi[0]=1;
				pi[i]=temp;
			}
		}
	}
	
	public static Stack<Integer> liste(int[] pioche,Stack<Integer> pioche1) {
		
		for(int i=0;i<pioche.length;i++) {
			pioche1.add(pioche[i]);
		}
		return pioche1;
		
	}
	
	public static Integer piocher(Stack<Integer> pioche1) {
		return pioche1.pop();
	}
	
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
	
	public static boolean VerifMain (int nombre, int[] main) {
		if (nombre==0) return false;
		for(int i=0; i<6; i++) {
			if(nombre==main[i])
				return true;
		}
		return false;
	}
	
	public static boolean Verifpose (int nombre, Table table, boolean asc) {
		
		if (asc) {
			int nombreverif = table.asc.peek();
			if(nombre>nombreverif || nombre==nombreverif-10) {
				return true;
			}
			return false;
		}
		int nombreverif = table.desc.peek();
		
		if(nombre<nombreverif || nombre==nombreverif+10) {
			
			return true;
		}
		return false;
	}
	
	public static boolean VerifposeInv (int nombre, Table table, boolean asc) {		
		if (asc) {			
			int nombreverif = table.asc.peek();			
			if(nombre<nombreverif) {				
				return true;
			}
			return false;
		}
		int nombreverif = table.desc.peek();			
		if(nombre>nombreverif) {			
			return true;
		}
		return false;
	}
	
	public static void Valider (Table table) {
		table.carteasc=0;
		table.cartedesc=0;
	}
	public static int defausseCarte(int nombre, int[] main) {
		for(int i=0;i<6;i++)
			if(nombre==main[i])
				return i;
		return 7;
	}
	public static void enlevercarte (Table table) {
		for(int i=0; i < table.carteasc; i++) {
			piocher(table.asc);
		}
		for(int i=0; i < table.cartedesc; i++) {
			piocher(table.desc);
		}
		Valider(table);
	}
	
	public static boolean poserCarteJoueur(int nombre, boolean asc, Joueur joueur) {		
		if(!Verifpose(nombre, joueur.table, asc)) {			
			return false;
		}		
		if (asc) {			
			joueur.table.asc.add(nombre);
			joueur.table.carteasc += 1;
			return true;
		}			
		joueur.table.desc.add(nombre);
		joueur.table.cartedesc += 1;
		return true;
	}

	public static boolean poserCarteJoueurInv(int nombre, boolean asc, Joueur joueur) {
		
		if(!VerifposeInv(nombre, joueur.table, asc)) {			
			return false;
		}		
		if (asc) {
			joueur.table.asc.add(nombre);
			joueur.table.carteasc += 1;
			return true;
		}		
		joueur.table.desc.add(nombre);
		joueur.table.cartedesc += 1;
		return true;
	}
	public static String chaine() throws IOException
    {
	    String tmp = "";
	    char C='\0';		
			while ((C=(char) System.in.read()) !='\n')
			{
				if (C != '\r')  tmp = tmp+C;
		 
			}
				
		return tmp;
    } 
	public static void poserCarte1 (Joueur Joueur1, Joueur Joueur2) throws IOException{
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
						if(VerifMain(nombre, Joueur1.main)) {	
							if(!defausse[defausseCarte(nombre, Joueur1.main)]) {
								nmbdefausse += 1;
								defausse[defausseCarte(nombre, Joueur1.main)]=true;
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
				if(VerifEsp(ligne.charAt(i))) {
					if(VerifMain(nombre, Joueur1.main)) {
						if(!defausse[defausseCarte(nombre, Joueur1.main)]) {
							nmbdefausse += 1;
							defausse[defausseCarte(nombre, Joueur1.main)]=true;
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
					if(VerifMain(nombre, Joueur1.main)) {	
						if(!defausse[defausseCarte(nombre, Joueur1.main)] && nmbdefausse > 0) {
							nmbdefausse += 1;
							defausse[defausseCarte(nombre, Joueur1.main)]=true;
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
			
				if(VerifMain(nombre, Joueur1.main)) {
					if(inv) {
						if(!defausse[defausseCarte(nombre, Joueur1.main)] && nmbdefausse > 0) {
							nmbdefausse += 1;
							defausse[defausseCarte(nombre, Joueur1.main)]=true;
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
			Valider(Joueur1.table);
			Valider(Joueur2.table);
			for(int i = 0;i<6;i++) {
				if (defausse[i])
					Joueur1.main[i]=0;
			}
			if(inv) {
				int nmb = 2;
				if (nmb>Joueur1.nmbpioche)nmb= Joueur1.nmbpioche;
				for(int i=0;i<2;i++) {	
					if(Joueur1.nmbpioche==0) break;
					Joueur1.main[premiervide(Joueur1.main)]=piocher(Joueur1.pioche);
					Joueur1.nmbpioche-=1;
				}
				System.out.println(nmbdefausse + " cartes posées, " + nmb + " cartes piochées");
			}
			else {	
				int nmb = 6 - nmbCarteMain(Joueur1.main);	
				if (nmb>Joueur1.nmbpioche)nmb= Joueur1.nmbpioche;
				for(int i=0;i<nmb;i++) {	
					if(Joueur1.nmbpioche==0) break;
					Joueur1.main[premiervide(Joueur1.main)]=piocher(Joueur1.pioche);
					Joueur1.nmbpioche-=1;					
				}
				System.out.println(nmbdefausse + " cartes posées, " + nmb + " cartes piochées");
			}
				
		}
		else {
			enlevercarte(Joueur1.table);
			enlevercarte(Joueur2.table);
			System.out.print('#');
			poserCarte1(Joueur1, Joueur2);
		}
	}
	
	public static void initialiseJoueur(Joueur joueur, int[] pioche) {
		joueur.table = new Table();
		joueur.pioche = new Stack<Integer>();
		joueur.nmbpioche=52;
		joueur.main = new int [6];
		initialiseTable(joueur.table);
		liste(pioche, joueur.pioche);
		initialiseMain(joueur.main, joueur.pioche);
	}
	
	
	public static void initialiseTable(Table table) {		
		table.asc = new Stack<Integer>();
		table.desc = new Stack<Integer>();
		table.asc.add(1);
		table.desc.add(60);	
		table.carteasc=0;
		table.cartedesc=0;
	}
	
	public static void initialiseMain(int[] main, Stack<Integer> pioche) {		
		for(int i=0;i<6;i++) {
			main[i]=piocher(pioche);
		}
	}

	public static void main(String[] args) throws IOException{		
		Joueur Joueur1 = new Joueur();
		Joueur Joueur2 = new Joueur();
		int[] Pioche = new int[58];
		boolean j=true;
		boolean victoire;
		init(Pioche);
		melange(Pioche);		
		initialiseJoueur(Joueur1, Pioche);
		melange(Pioche);
		initialiseJoueur(Joueur2, Pioche);		
		do {
			affichageTable(Joueur1, Joueur2);
			if(j) {
				System.out.print("cartes NORD ");
				affichage(Joueur1.main);
				if(ConditionDefaite(Joueur1, Joueur2.table)) {
					victoire=false;
					break;
				}
				poserCarte1(Joueur1, Joueur2);
				j=false;
				if(ConditionVictoire(Joueur1)) {
					victoire=true;
					break;
				}
			}
			else {
				System.out.print("cartes SUD ");
				affichage(Joueur2.main);
				if(ConditionDefaite(Joueur2, Joueur1.table)) {
					victoire=true;
					break;
				};
				poserCarte1(Joueur2, Joueur1);
				j=true;
				if(ConditionVictoire(Joueur2)) {
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