package firstPack;
public class application {
	
	public static void init(int[] pi) {
		System.out.print("[ ");

		for(int i=0;i<pi.length;i++) {
			pi[i]=i+1;
			System.out.print(pi[i]);
			System.out.print(", ");
		}
		System.out.println("] ");
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
	public static void main(String[] args) {
		int[] Pioche = new int[60];
		init(Pioche);
		melange(Pioche);
		affichage(Pioche);
	}
}
