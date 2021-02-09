package Joueur;

import Table.Pioche;

public class Main {
	public int [] main=new int[6];
	public static void initialiseMain(int[] main, Pioche pioche) {		
		for(int i=0;i<6;i++) {
			main[i]=Pioche.piocher(pioche.pioche);
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
	public static boolean VerifMain (int nombre, int[] main) {
		if (nombre==0) return false;
		for(int i=0; i<6; i++) {
			if(nombre==main[i])
				return true;
		}
		return false;
	}
	public static int defausseCarte(int nombre, int[] main) {
		for(int i=0;i<6;i++)
			if(nombre==main[i])
				return i;
		return 7;
	}
	
}
