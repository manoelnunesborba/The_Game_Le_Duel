package firstPack;

import java.util.Stack;

public class application {
	
	public static void init(int[] pi) {

		for(int i=0;i<pi.length;i++) {
			pi[i]=i+1;
		}
	}
	public static void affichage(int[] pi) {
		System.out.print("[ ");

		for(int i=0;i<pi.length;i++) {
			System.out.print(pi[i]);
			System.out.print(", ");
		}
		System.out.println("] ");
		System.out.println(pi.length);
	}
	public static void melange(int[] pi) {
		for(int i=pi.length-2;i>=1;i--) {		/*Le pi.length-2 empeche de bouger le 60 de la fin de la piche*/
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
	public static void initialiseTable(Stack<Integer> pioche1) {
		Stack<Integer> table = new Stack<Integer>();
		
	}


	public static void main(String[] args) {
		Stack<Integer> pioche1 = new Stack<Integer>();
		
		int[] Pioche = new int[60];
		int tmp = 0;
		init(Pioche);
		melange(Pioche);
		liste(Pioche, pioche1);
		do {
			tmp=piocher(pioche1);
			System.out.println(tmp);
			
		}while(!pioche1.isEmpty());

	}
}
