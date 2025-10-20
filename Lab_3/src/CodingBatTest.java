import  org.junit.Test;
import static org.junit.Assert.*;

public class CodingBatTest {

    @org.junit.Test
    public void sleepIn() {
        CodingBat s = new CodingBat();
        assertEquals(true,s.sleepIn(false,false));
        assertEquals(false,s.sleepIn(true,false));
        assertEquals(true,s.sleepIn(false,true));
        assertEquals(true,s.sleepIn(true,true));

    }

    @org.junit.Test
    public void monkeyTrouble() {
        CodingBat s = new CodingBat();
        assertEquals(true,s.monkeyTrouble(true,true));
        assertEquals(true,s.monkeyTrouble(false,false));
        assertEquals(false,s.monkeyTrouble(true,false));
        assertEquals(false,s.monkeyTrouble(false,true));
    }

    @org.junit.Test
    public void helloName() {
        CodingBat s = new CodingBat();
        assertEquals("Hello Bob!",s.helloName("Bob"));
        assertEquals("Hello Alice!",s.helloName("Alice"));
        assertEquals("Hello X!",s.helloName("X"));
        assertEquals("Hello Dolly!",s.helloName("Dolly"));
    }

    @org.junit.Test
    public void countEvens() {
        CodingBat s = new CodingBat();

    }
}