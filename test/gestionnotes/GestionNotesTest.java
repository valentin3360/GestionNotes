package gestionnotes;

import static gestionnotes.GestionNotes.remplirTableauAleatoire;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests unitaires de la classe GestionNotes.
 */
public class GestionNotesTest {

        @Test
    public void testremplisTableauAleatoire() {
    }
    
    
    @Test
    public void testmin() {
        int[] UEStest = {2,9,2,1};
        int rep= GestionNotes.min(UEStest);
        assertEquals(1, rep);
        
    }
    
    
    @Test
    public void testmax() {
        int[] UEStest = {2,9,2,1};
        int rep= GestionNotes.max(UEStest);
        assertEquals(9, rep);
        
        int[] UEStest2 = {0,0,0,1};
        rep= GestionNotes.max(UEStest2);
        assertEquals(1, rep);
    }
    
    @Test
    public void testmoyenne() {
        double delta = 0.000;
    int[] UE = {5,15,10}; 
        double rep;
        rep = GestionNotes.moyenne(UE);
        
        assertEquals(10.0,rep,delta);
        
    }
    
    @Test
    public void testdecalage() {
        int[] tab = {2,0,2,1};
        System.out.println("debut");
        for (int i = 0; i < tab.length; i++) {
            
            System.out.print(tab[i]);
        }
        System.out.println("après");
        GestionNotes.decalageGaucheAPartirPoint(0, tab);
        for (int i = 0; i < tab.length; i++) {
            
            System.out.print(tab[i]);
        }
        
        
        
    }
    
    @Test
    public void testminusTutrice() {
       int[] tab = {1,8,6,9,0,0,0,0,0,0,0,0};
       
       GestionNotes.minusTutrice(tab);
       
       for (int i = 0; i < tab.length; i++) {
            
            System.out.print(tab[i]);
        }
        
    }
    @Test
    public void testplusTutrice() {
       int[] tab = {1,8,6,9,0,0,0,0,0,0,0,0};
       
       GestionNotes.plusTutrice(tab);
       
       for (int i = 0; i < tab.length; i++) {
            
            System.out.print(tab[i]);
        }
        
    }
    
    
    
    
}
