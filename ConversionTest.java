/**
 * ConversionTest.java
 * JUnit tests for Conversion.java
 * 
 * @author Nelson Raley, Gabriel Bartholomäus-Cabezas, Michael Pham
 *      @version 1.0 --
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class ConversionTest {
    Conversion tester = new Conversion();
    double oriVal = (double) 0.0;
    int option = 0;
    // Runs before every test
    @Before public void startUp() {

    }

    // Runs after every test
    @After public void tearDown() {

    }

    // printResult takes a double and int
    // input 1 (double) is the result
    // input 2 (int) is the precision level
    // output is a string printed to screen
    @Test public void testPrintResult(){
        
    }

    // convertUnits takes a double and int
    // input 1 (double) is the original value
    // input 2 (int) is the conversion option
    @Test public void testConvertUnits() {
        oriVal = 32;
        assertTrue("F2C Conversion Failed",tester.convertUnits(oriVal, 1) == 0.0);
    }
}