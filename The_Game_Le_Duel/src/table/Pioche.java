package table;

import java.util.Arrays;
import java.util.Stack;

public class Pioche {
	private Stack<Integer> pioche = new Stack<Integer>();
	

	private int nmbpioche;
	
	/**
	  * @brief Permet d'avoir accès à la variable nmbpioche
	  * @return sa valeur
	  */
	public int nmbpioche(){
		return this.nmbpioche;
	}
	
	/**
	  * @brief Permet de donner une valeur de nmbpioche
	  * @param [in]valeur: valeur à être donné
	  */
	public void nmbpioche(int valeur){
		this.nmbpioche=valeur;
	}
	/**
	  * @brief Permet de diminuer la valeur de nmbpioche
	  * @param [in]valeur: valeur à être minué
	  */
	public void nmbpiocheD(int valeur){
		this.nmbpioche-=valeur;
	}
	
	/**
	  * @brief Permet d'avoir accès à la pioche
	  * @return cette pioche
	  */
	public Stack<Integer> pioche(){
		return this.pioche;
	}
	
	
	/**
	  * @brief Initialise une pioche
	  * @param[in] pi : la pioche
	  */
	public static void init(int[] pi) {

		for(int i=0;i<pi.length;i++) {
			pi[i]=i+2;
		}
	}

	/**
	  * @brief melange une pioche
	  * @param[in-out] pi : la pioche melangé
	  */
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
	
	
	
	/**
	  * @brief transforme une pioche en une Pile
	  * @param[in] pi : la pioche 
	  * @param[out] pioche2 : la pioche empilé
	  */
	public static Stack<Integer> liste(int[] pioche,Stack<Integer> pioche2) {
		
		for(int i=0;i<pioche.length;i++) {
			pioche2.add(pioche[i]);
			
		}
		return pioche2;
		
	}
	
	/**
	  * @brief Pioche la carte en haut de la pile
	  * @param[in-out] pioche2 : la pioche empilé
	  * @return La carte en haut de la pile
	  */
	public static Integer piocher(Stack<Integer> pioche2) {
		return pioche2.pop();
	}
	
	
	
	/**
	  * @brief Affiche une pioche
	  * @param[in] pi : Pile à être affiché
	  */
	public static void toString(int[] pi) {
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
