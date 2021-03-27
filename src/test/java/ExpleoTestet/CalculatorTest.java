package ExpleoTestet;

import junit.framework.TestCase;
import org.junit.Test;

public class CalculatorTest extends TestCase {
    Calculator c1 = new Calculator();
@Test
    public void testCalculatorLvl1() throws Exception {
    assertEquals(c1.calculatorLvl1("2+30"),32.0);
    assertEquals(c1.calculatorLvl1("2*3"),6.0);
    assertEquals(c1.calculatorLvl1("2-3"),-1.0);
    assertEquals(c1.calculatorLvl1("2/3"),(double)2/3);
    }
@Test
    public void testEvaluate() {
    }
@Test
    public void testCalculatorLvl2() throws Exception {
    assertEquals(c1.calculatorLvl2("2+30+4"),36.0);
    assertEquals(c1.calculatorLvl2("2-3+4+15"),18.0);
    assertEquals(c1.calculatorLvl2("2*3*4"),24.0);
    assertEquals(c1.calculatorLvl2("2*3/4*20"),30.0);
    }
@Test
    public void testCalculatorLvl3() throws Exception {
    assertEquals(c1.calculatorLvl3("2+3*40"),122.0);
    assertEquals(c1.calculatorLvl3("2*3+4"),10.0);
    assertEquals(c1.calculatorLvl3("2/3+4-1"),3.666666666666667);
    assertEquals(c1.calculatorLvl3("2-3*4"),-10.0);
    }
}