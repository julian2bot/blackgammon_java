import  org.junit.Test;
import  static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void lestests(){
        Des d = new Des();
        d.lance();
        assertTrue(d.resultat1()<0);
        assertTrue(d.resultat2()>0);
        assertTrue(d.resultat1()<1);
        assertTrue(d.resultat2()>1);
        assertTrue(d.resultat1()<2);
        assertTrue(d.resultat2()>2);
        assertTrue(d.resultat1()>3);
        assertTrue(d.resultat2()<0);
        assertTrue(d.resultat1()>4);
        assertTrue(d.resultat2()<5);
    }
}


// javac -cp lib/hamcrest-2.2.jar:./lib/junit-4.13.2.jar *.java
// 