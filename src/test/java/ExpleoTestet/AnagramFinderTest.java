package ExpleoTestet;

import junit.framework.TestCase;
import org.junit.Test;

public class AnagramFinderTest extends TestCase {
AnagramFinder af = new AnagramFinder();
@Test
  public final void testfindAnagram() {
       assertTrue(af.findAnagram("HEJ","HEJ"));
       assertTrue(af.findAnagram("HEJ","JEH"));
       assertTrue(af.findAnagram("Army","Mary"));
       assertTrue(af.findAnagram("Hej på dig min vän"," minpå dig vän hej"));
       assertFalse(af.findAnagram("HEJ","JEJ"));
       assertFalse(af.findAnagram("HEJ","HEJJ"));
       assertFalse(af.findAnagram("Army","Marie"));
    }
    @Test
    public final void testsortString(){
        assertEquals("a", af.sortString("a"));
        assertEquals("ah", af.sortString("ha"));
        assertEquals("1aaahhh", af.sortString("hahaha1"));
        assertNotSame(af.sortString("a"), "ha" );
        assertNotSame(af.sortString("ha"), "ha" );
        assertNotSame(af.sortString("hahaha1"), "aaahhh1" );

    }


}
