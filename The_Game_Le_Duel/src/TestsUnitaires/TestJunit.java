package TestsUnitaires;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import joueur.AttributsJoueur;
import table.Jeu;
import table.Pioche;

public class TestJunit {
	
	@Test
	public void testInitPiocheSans1et60() {
		Boolean test = false;
		int[] Pioch = new int[58];
		Pioche.init(Pioch);
		if(Pioch[0]==2 && Pioch[Pioch.length-1]==59) {
			
			test=true;
		}
		Assert.assertTrue(test);
		
	}
	@Test
	public void testMelangePioche() {
		int[] Trié = new int[58];
		int[] melangé = new int[58];
		Boolean égal=false;
		Pioche.init(Trié);	
		Pioche.init(melangé);
		Pioche.melange(melangé);
		if(Arrays.equals(Trié,melangé)) {
			égal=true;
		}
		else
			égal=false;
		
		Assert.assertFalse(égal); // Elles sont differentes
	}

}
