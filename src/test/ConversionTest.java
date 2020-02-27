/**
 * ConversionTest.java
 * JUnit tests for Conversion.java
 * 
 * @author Nelson Raley, Gabriel Bartholomäus-Cabezas, Michael Pham
 *      @version 1.0 February 19 2020
 *      @version 1.1 February 25 2020
 *      @version 1.2 March X 2020
 */

package test;
import static org.junit.Assert.*;
import org.junit.*;
import app.*;

public class ConversionTest {
    double oriVal = (double) 0.0;
    int option = 0;
    // Runs before every test
    @Before public void startUp() {
        oriVal = (double) 0.0;
        option = 0;
    }

    // Runs after every test
    @After public void tearDown() {

    }

    // printResult takes a double and int
    // input 1 (double) is the result
    // input 2 (int) is the precision level
    // output is a string
    // All of these tests directly test observability as they will be sent to the user after this
    @Test public void testFormatResultHappyPath(){
        oriVal = 1.2345;
        option = 0;
        assertTrue("FormatResult Happy Path Failure", Conversion.formatResult(oriVal, option).equals("1"));
        option = 1;
        assertTrue("FormatResult Happy Path Failure", Conversion.formatResult(oriVal, option).equals("1.2"));
        option = 2;
        assertTrue("FormatResult Happy Path Failure", Conversion.formatResult(oriVal, option).equals("1.23"));
        option = 3;
        // Not 1.234 because String.Format() rounds
        assertTrue("FormatResult Happy Path Failure", Conversion.formatResult(oriVal, option).equals("1.235"));
        option = 4;
        assertTrue("FormatResult Happy Path Failure", Conversion.formatResult(oriVal, option).equals("1.2345"));
        option = 5;
        assertTrue("FormatResult Happy Path Failure", Conversion.formatResult(oriVal, option).equals("ERR"));
    }

    // floats and ints cannot take null values, as such the compiler will not allow these tests
    @Test public void testFormatResultNullInputs() {
        // assertTrue("FormatResult First Arguement Null Fail", Conversion.formatResult(null, option).equals("ERR"));
        // assertTrue("FormatResult Second Arguement Null Fail", Conversion.formatResult(oriVal, null).equals("ERR"));
    }

    // tests against nonproper inputs like strings
    // out of bound results, backwards inputs
    // As with the previous FormatResult tests, these test observability
    @Test public void testFormatResultUnexpectedInputs() {
        option = -1;
        assertTrue("FormatResult", Conversion.formatResult(oriVal, option).equals("ERR"));
        oriVal = Float.MAX_VALUE;
        option = 0;
        assertTrue("FormatResult Max Float Failure", Conversion.formatResult(oriVal, option).equals("340282346638528860000000000000000000000"));
    }

    // convertUnits takes a double and int
    // input 1 (double) is the original value
    // input 2 (int) is the conversion option
    // These test check for control flow of the program and what is expected at each branch
    @Test public void testConvertUnitsHappyPath() {
        oriVal = 32;
        assertTrue("ConvertUnit F2C Happy Path Failure", Conversion.convertUnits(oriVal, 1) == 0.0);
        oriVal = 100;
        assertTrue("ConvertUnit C2F Happy Path Failure", Conversion.convertUnits(oriVal, 2) == 212);
        oriVal = 1;
        assertTrue("ConvertUnit In2Cm Happy Path Failure", Conversion.convertUnits(oriVal, 3) == 2.54);
        assertTrue("ConvertUnit Cm2In Happy Path Failure", Conversion.convertUnits(oriVal, 4) == 0.39370078740157477);
        assertTrue("ConvertUnit Ft2Mt Happy Path Failure", Conversion.convertUnits(oriVal, 5) == 0.30478512648582745);
        assertTrue("ConvertUnit Mt2Ft Happy Path Failure", Conversion.convertUnits(oriVal, 6) == 3.281);
        assertTrue("ConvertUnit Mi2Km Happy Path Failure", Conversion.convertUnits(oriVal, 7) == 1.609);
        assertTrue("ConvertUnit Km2Mi Happy Path Failure", Conversion.convertUnits(oriVal, 8) == 0.6215040397762586);
        assertTrue("ConvertUnit Gal2L Happy Path Failure", Conversion.convertUnits(oriVal, 9) == 3.785);
        assertTrue("ConvertUnit L2Gal Happy Path Failure", Conversion.convertUnits(oriVal, 10) == 0.2642007926023778);
        assertTrue("ConvertUnit Oz2G Happy Path Failure", Conversion.convertUnits(oriVal, 11) == 28.35);
        assertTrue("ConvertUnit G2Oz Happy Path Failure", Conversion.convertUnits(oriVal, 12) == 0.03527336860670194);
        assertTrue("ConvertUnit Lb2Kg Happy Path Failure", Conversion.convertUnits(oriVal, 13) == 0.4535147392290249);
        assertTrue("ConvertUnit Kg2Lb Happy Path Failure", Conversion.convertUnits(oriVal, 14) == 2.205);
        assertTrue("ConvertUnit Mph2Kph Happy Path Failure", Conversion.convertUnits(oriVal, 15) == 1.609);
        assertTrue("ConvertUnit Kph2Mph Happy Path Failure", Conversion.convertUnits(oriVal, 16) == 0.6215040397762586);
        assertTrue("ConvertUnit Default Happy Path Failure", Conversion.convertUnits(oriVal, 17) == 1);
    }

    @Test public void testConvertUnitsNullInputs() {
        // option = null;
        // assertTrue("ConvertUnits null failure", Conversion.convertUnits(option, 1) == null);
    }

    @Test public void testConvertUnitsUnexpectedInputs() {
        //assertTrue("ConvertUnit ")
    }
}