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
    // output is a string
    @Test public void testFormatResultHappyPath(){
        oriVal = 1.2345;
        option = 0;
        assertTrue("FormatResult Happy Path Failure", tester.formatResult(oriVal, option).equals("1"));
        option = 1;
        assertTrue("FormatResult Happy Path Failure", tester.formatResult(oriVal, option).equals("1.2"));
        option = 2;
        assertTrue("FormatResult Happy Path Failure", tester.formatResult(oriVal, option).equals("1.23"));
        option = 3;
        // Not 1.234 because String.Format() rounds
        assertTrue("FormatResult Happy Path Failure", tester.formatResult(oriVal, option).equals("1.235"));
        option = 4;
        assertTrue("FormatResult Happy Path Failure", tester.formatResult(oriVal, option).equals("1.2345"));
        option = 5;
        assertTrue("FormatResult Happy Path Failure", tester.formatResult(oriVal, option).equals("ERR"));
    }

    // convertUnits takes a double and int
    // input 1 (double) is the original value
    // input 2 (int) is the conversion option
    @Test public void testConvertUnitsHappyPath() {
        oriVal = 32;
        assertTrue("ConvertUnit Happy Path Failure", tester.convertUnits(oriVal, 1) == 0.0);
    }
}