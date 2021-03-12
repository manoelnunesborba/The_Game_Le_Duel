package table;
import java.util.Stack;







public class Table {
	private Stack<Integer> asc;
	private Stack<Integer> desc;
	private int carteasc;
	private int cartedesc;
	
	
	
	/**
	  * @brief Initialise une table
	  * @param[in-out] table : La table 
	  */
	public static void initialiseTable(Table table) {		
		table.asc = new Stack<Integer>();
		table.desc = new Stack<Integer>();
		table.asc.add(1);
		table.desc.add(60);	
		table.carteasc=0;
		table.cartedesc=0;
	}
	
	/**
	  * @brief ajoute une valeur à la pile descendante
	  * @param[in] value : la valeur à être ajouté
	  */
	public void descadd(int value) {
		this.desc.add(value);
	}
	
	
	/**
	  * @brief permet de voir la valeur en haut de la pile descendante
	  * @return La valeur en haut de la pile 
	  */
	public int descpeek() {
		return this.desc.peek();
	}
	
	
	/**
	  * @brief ajoute une valeur à la pile ascendente
	  * @param[in] value : la valeur à être ajouté
	  */
	public void ascadd(int value) {
		this.asc.add(value);
	}
	
	/**
	  * @brief permet de voir la valeur en haut de la pile ascendente
	  * @return La valeur en haut de la pile 
	  */
	public int ascpeek() {
		return this.asc.peek();
	}
	
	/**
	  * @brief Carte à être ajouté à la pile ascendente
	  * @param[in] value : la carte à être ajouté
	  */
	public void Lacarteascadd(int value) {
		this.carteasc= +value;
	}
	
	
	/**
	  * @brief Carte à être ajouté à la pile descendente
	  * @param[in] value : la carte à être ajouté
	  */
	public void Lacartedescadd(int value) {
		this.cartedesc= +value;
	}
	
	
	
	/**
	  * @brief Vérifie si on peut poser une carte(+10, ou -10 d'écart) dans une table donné
	  * @param[in] nombre : La carte à être posée
	  * @param[in] table : La table à prendre comme réference
	  * @param[in] asc : Si on cherche à incrémenter ou decrementer, si c'est ascendent ou pas
	  * @return True ou false
	  */
	public static boolean Verifpose (int nombre, Table table, boolean asc) { /**/
		
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
	
	
	
	
	/**
	  * @brief Vérifie si on peut poser une carte dans une table donné
	  * @param[in] nombre : La carte à être posée
	  * @param[in] table : La table à prendre comme réference
	  * @param[in] asc : Si on cherche à incrémenter ou decrementer, si c'est ascendent ou pas
	  * @return True ou false
	  */
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
	
	
	/**
	  * @brief mets les cartes ascendentes et descendentes à 0
	  * @param[in] table : La table à prendre comme réference
	  */
	public static void Valider (Table table) { /**/
		table.carteasc=0;
		table.cartedesc=0;
	}
	
	
	
	/**
	  * @brief Pioche les cartes jouées dans la table
	  * @param[in] table : La table à prendre comme réference
	  */
	public static void enlevercarte (Table table) {
		for(int i=0; i < table.carteasc; i++) {
			Pioche.piocher(table.asc);
		}
		for(int i=0; i < table.cartedesc; i++) {
			Pioche.piocher(table.desc);
		}
		Valider(table);	//Et à la fin on les mets à 0
	}
}
