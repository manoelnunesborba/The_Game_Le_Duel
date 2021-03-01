package joueur;
import java.util.Arrays;

import table.Pioche;

public class Main {
	public int [] main=new int[6];
	public static void initialiseMain(int[] main, Pioche pioche) {		
		for(int i=0;i<6;i++) {
			main[i]=Pioche.piocher(pioche.pioche);
		}
		Arrays.sort(main);
	}
	public static int nmbCarteMain(int[] main) {
		int nmb = 0;
		for(int i=0;i<main.length;i++) {
			if(main[i]!=0)
				nmb+=1;
		}
		return nmb;
	}
	
	
}
