package table;
import java.util.Stack;





public class Table {
	public Stack<Integer> asc;
	public Stack<Integer> desc;
	public int carteasc;
	public int cartedesc;
	public static void initialiseTable(Table table) {		
		table.asc = new Stack<Integer>();
		table.desc = new Stack<Integer>();
		table.asc.add(1);
		table.desc.add(60);	
		table.carteasc=0;
		table.cartedesc=0;
	}
	
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
	public static boolean VerifposeInv (int nombre, Table table, boolean asc) {		/**/
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
	public static void Valider (Table table) { /**/
		table.carteasc=0;
		table.cartedesc=0;
	}
	public static void enlevercarte (Table table) { /**/
		for(int i=0; i < table.carteasc; i++) {
			Pioche.piocher(table.asc);
		}
		for(int i=0; i < table.cartedesc; i++) {
			Pioche.piocher(table.desc);
		}
		Valider(table);
	}
}
