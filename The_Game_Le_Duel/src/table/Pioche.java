package table;

import java.util.Arrays;
import java.util.Stack;

public class Pioche {
	public Stack<Integer> pioche = new Stack<Integer>();
	public int nmbpioche;
	public static void init(int[] pi) {

		for(int i=0;i<pi.length;i++) {
			pi[i]=i+2;
		}
		melange(pi);
	}


	private static void melange(int[] pi) {
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
	public static Stack<Integer> liste(int[] pioche,Stack<Integer> pioche2) {
		
		for(int i=0;i<pioche.length;i++) {
			pioche2.add(pioche[i]);
			
		}
		return pioche2;
		
	}
	public static Integer piocher(Stack<Integer> pioche2) {
		return pioche2.pop();
	}
	public static void affichage(int[] pi) {
		Arrays.sort(pi);
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
}
