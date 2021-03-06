// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 3; page ??
// JUnit for Thermostat.java
//
// NOT COMPLETE (SEPT 2014)
package app;

import org.junit.*;
import static org.junit.Assert.*;
import app.*;

public class ThermostatTest
{
   private Thermostat thermo;
   private ProgrammedSettings settings;

   @Before // Set up - Called before every test method.
   public void setUp()
   {
      thermo   = new Thermostat();
      settings = new ProgrammedSettings();
      thermo.setThresholdDiff (1);
   }

   // if (((curTemp < dTemp - thresholdDiff) || (Override && curTemp < overTemp - thresholdDiff)) && (timeSinceLastRun > minLag))
   // Predicate: (a || (b && c)) && d

   @Test public void testTTTT()
   {
      settings.setSetting (Period.MORNING, DayType.WEEKDAY, 70);
      thermo.setPeriod (Period.MORNING);
      thermo.setDay (DayType.WEEKDAY);
      thermo.setCurrentTemp (68);
      thermo.setTimeSinceLastRun (10);
      thermo.setMinLag (5);
      thermo.setOverride (true);
      thermo.setOverTemp (72);
      assertTrue (thermo.turnHeaterOn (settings));
   }

   @Test public void testFFFF()
   {
      settings.setSetting (Period.MORNING, DayType.WEEKDAY, 70);
      thermo.setPeriod (Period.MORNING);
      thermo.setDay (DayType.WEEKDAY);
      thermo.setCurrentTemp (70);
      thermo.setTimeSinceLastRun (7);
      thermo.setMinLag (7);
      thermo.setOverride (false);
      thermo.setOverTemp (70);
      assertFalse (thermo.turnHeaterOn (settings));
   }

   @Test public void testPCtrue()
   {
      // Partial test for method turnHeaterOn() in class Thermostat
      // Criterion: PC
      // Value: True
      // Predicate: lines 28-30
      // Expected Output: true

      // Instantiate needed objects
      thermo   = new Thermostat();
      settings = new ProgrammedSettings();
      // Setting internal variable dTemp
      settings.setSetting (Period.MORNING, DayType.WEEKDAY, 69);
      thermo.setPeriod (Period.MORNING);
      thermo.setDay (DayType.WEEKDAY);
      // Clause a: curTemp < dTemp - thresholdDiff : true
      thermo.setCurrentTemp (63);
      thermo.setThresholdDiff (5);
      // Clause b: Override : true
      thermo.setOverride (true);
      // Clause c: curTemp < overTemp - thresholdDiff : true
      thermo.setOverTemp (70);
      // Clause d: timeSinceLastRun.greaterThan (minLag) : true
      thermo.setMinLag (10);
      thermo.setTimeSinceLastRun (12);
      // Run the test
      assertTrue (thermo.turnHeaterOn (settings));
   }

   // Test passes
   @Test public void testoverrideTrue()   //tests override true and regulator true
   {
      // Test for method turnHeaterOn() in class Thermostat
      // Criterion: override, regulator
      // Value: True, True
      // Predicate: lines 37
      // Expected Output: 1

      // Instantiate needed objects
      thermo   = new Thermostat();
      settings = new ProgrammedSettings();
      // Setting internal variable dTemp
      settings.setSetting (Period.MORNING, DayType.WEEKDAY, 78);
      thermo.setPeriod (Period.MORNING);
      thermo.setDay (DayType.WEEKDAY);
      // Clause a: curTemp < dTemp - thresholdDiff : true
      thermo.setCurrentTemp (70);
      thermo.setThresholdDiff (5);
      // Clause b: Override : true
      thermo.setOverride (true);
      thermo.setRegulator (true);
      // Clause c: curTemp < overTemp - thresholdDiff : false
      thermo.setOverTemp (68);
      // Clause d: timeSinceLastRun.greaterThan (minLag) : true
      thermo.setMinLag (10);
      thermo.setTimeSinceLastRun (12);
      // Run the test
      thermo.turnHeaterOn (settings);
      assertTrue (thermo.getRunTime() == 1);
   }


   // Test fails due to line 36, timeNeeded does not use ablsolute values, so negative time is allowed
   @Test public void testoverrideFalse()  //tests override false and regulator true
   {
      // Test for method turnHeaterOn() in class Thermostat
      // Criterion: override, regulator
      // Value: False, True
      // Predicate: lines 37
      // Expected Output: 6

      // Instantiate needed objects
      thermo   = new Thermostat();
      settings = new ProgrammedSettings();
      // Setting internal variable dTemp and getting to line 37
      settings.setSetting (Period.MORNING, DayType.WEEKDAY, 69);
      thermo.setPeriod (Period.MORNING);
      thermo.setDay (DayType.WEEKDAY);
      thermo.setCurrentTemp (63);
      thermo.setThresholdDiff (5);
      thermo.setOverTemp (70);
      thermo.setMinLag (10);
      thermo.setTimeSinceLastRun (12);
      // Clause a: Override : false
      thermo.setOverride (false);
      // Clause b: Regulator : true
      thermo.setRegulator (true);
      // Run the test
      thermo.turnHeaterOn(settings);
      assertTrue (thermo.getRunTime() == 6);
   }
}
