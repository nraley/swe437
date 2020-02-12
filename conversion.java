/** *****************************************************************
    conversion.java
    Converts various measures from one unit to another
    
    Original webapp:
    @author Jeff Offutt & Ren Li

        @version 1.0    October 2000
        @version 2.0    June 2015
        @version 2.1    January 2020

    Command line UI modification:
    @author Nelson Raley, Gabriel Bartholomäus-Cabezas, Michael Pham
        @version 1.0 February 6 2020
        @version 1.1 --
********************************************************************* */

/**
 * Known Errors:
 *  - Scanner use only allows ints, another input type will crash
 */

// Import Java Libraries
import java.util.*;

public class conversion
{

    public static void main(String[]args){
        System.out.println("(Not So) On-line Measurement Conversion"); // on first run, print menu
        Scanner menuInput = new Scanner(System.in); //get user input

        System.out.println("For your precision, please Enter a number between 1 and 4:");
        int precision = Integer.parseInt(menuInput.nextLine());

        printMenu(); // print menu will ask for number between 1 and 14
        int i = Integer.parseInt(menuInput.nextLine());

        // user should put in a number between 1 and 14, else the while loop is not entered.
        while ((i > 0) && (i < 15))  {
            // once an option chosen, ask the user what number they want to convert
            System.out.println("What number would you like to convert?\n");
            String c = menuInput.nextLine();
            float userInput = (Float.valueOf(c).floatValue());
            float retVal = (float) 0.0;
            switch (i) {
                case 1:
                    System.out.println("Selected option is Fahrenheit to Celsius");
                    System.out.print("Conversion result is: ");
                    retVal = convertF2C(userInput);
                    break;
                case 2:
                    System.out.println("Selected option is Celsius to Fahrenheit");
                    System.out.print("Conversion result is: ");
                    retVal = convertC2F(userInput);;
                    break;
                case 3:
                    System.out.println("Selected option is Inches to Centimeters");
                    System.out.print("Conversion result is: ");
                    retVal = convertIn2Cm(userInput);
                    break;
                case 4:
                    System.out.println("Selected option is Centimeters to Inches");
                    System.out.print("Conversion result is: ");
                    retVal = convertCm2In(userInput);
                    break;
                case 5:
                    System.out.println("Selected option is Feet to Meters");
                    System.out.print("Conversion result is: ");
                    retVal = convertF2M(userInput);
                    break;
                case 6:
                    System.out.println("Selected option is Meters to Feet");
                    System.out.print("Conversion result is: ");
                    retVal= convertM2F(userInput);
                    break;
                case 7:
                    System.out.println("Selected option is Miles to Kilometers");
                    System.out.print("Conversion result is: ");
                    retVal = convertM2K(userInput);
                    break;
                case 8:
                    System.out.println("Selected option is Kilometers to Miles");
                    System.out.print("Conversion result is: ");
                    retVal = convertK2M(userInput);
                    break;
                case 9:
                    System.out.println("Selected option is Gallons to Liters");
                    System.out.print("Conversion result is: ");
                    retVal = convertG2L(userInput);
                    break;
                case 10:
                    System.out.println("Selected option is Liters to Gallons");
                    System.out.print("Conversion result is: ");
                    retVal = convertL2G(userInput);
                    break;
                case 11:
                    System.out.println("Selected option is Ounces to Gallons");;
                    System.out.print("Conversion result is: ");
                    retVal = convertOz2G(userInput);
                    break;
                case 12:
                    System.out.println("Selected option is Gallons to Ounces");
                    System.out.print("Conversion result is: ");
                    retVal = convertG2Oz(userInput);
                    break;
                case 13:
                    System.out.println("Selected option is Pounds to Kilograms");
                    System.out.print("Conversion result is: ");
                    retVal = convertLb2K(userInput);
                    break;
                case 14:
                    System.out.println("Selected option is Kilograms to Pounds");
                    System.out.print("Conversion result is: ");
                    retVal = convertK2Lb(userInput);
                    break;
                default:
                    System.out.println("Please enter a valid menu item.");
                    break;
            }
            printResult(retVal, precision);
            printMenu();
            i = Integer.parseInt(menuInput.nextLine());
        }
        menuInput.close();
    }

    public static void printMenu()
    {
        System.out.println("Please choose between options 1 to 14 to convert a value:");
        System.out.println(
                "1. Fahrenheit (Fº)     ----->     Celsius (Cº) \n" +
                "2. Celsius (Cº)        ----->     Fahrenheit (Fº) \n" +
                "3. Inch (in)           ----->     Centimeter (cm) \n" +
                "4. Centimeter (cm)     ----->     Inch (in) \n" +
                "5. Feet (ft)           ----->     Meter (m) \n" +
                "6. Meter (m)           ----->     Feet (ft) \n" +
                "7. Mile (mi)           ----->     Kilometer (km) \n" +
                "8. Kilometer (km)      ----->     Mile (mi) \n" +
                "9. Gallon (gal)        ----->     Liter (L) \n" +
                "10. Liter (L)          ----->     Gallon (gal) \n" +
                "11. Ounce (oz)         ----->     Gram (g) \n" +
                "12. Gram (g)           ----->     Ounce (oz) \n" +
                "13. Pound (lb)         ----->     Kilogram (kg) \n" +
                "14. Kilogram (kg)      ----->     Pound (lb) \n" +
                "15. Quit\n");

    }

    // Prints the result of conversion with a level of precision specified by the user
    public static void printResult(float input, float precision)
    {
        if (precision == 4) {
            System.out.println(String.format("%.4f", input));
        } else if (precision == 3) {
            System.out.println(String.format("%.3f", input));
        } else if (precision == 2) {
            System.out.println(String.format("%.2f", input));
        } else if (precision == 1) {
            System.out.println(String.format("%.1f", input));
        } else {
            System.out.println("Precision not properly set. Please exit and reset.");
        }
        System.out.println('\n');
    }

/** *****************************************************
 *  Conversion methods below
 *  14 methods, 2 for each pair of units
********************************************************* */
    private static float convertF2C (float input)
    {  // Convert farenheit to celsius
        return (float) ( ( (input-32.0) * 5.0) / 9.0);
    }

    private static float convertC2F (float input)
    {  // Convert celsius to farenheit
        return (float) ( (input * 9.0 / 5.0) + 32.0);
    }

    // small distance
    private static float convertIn2Cm (float input)
    {  // Convert inches to centimeters
        return (float) (input * 2.54);
    }

    private static float convertCm2In (float input)
    {  // Convert centimeters to inches
        return (float) (input * 0.3937);
    }

    // medium distance
    private static float convertF2M (float input)
    {  // Convert feet to meters
        return (float) (input * 0.3048);
    }

    private static float convertM2F (float input)
    {  // Convert meters to feet
        return (float) (input / 0.6048);
    }

    // large distance
    private static float convertM2K (float input)
    {  // Convert miles to kilometers
        return(float) (input * 1.609);
    }

    private static float convertK2M (float input)
    {  // Convert kilometers to miles
        return (float) (input * 0.6214);
    }

    // volume
    private static float convertG2L (float input)
    {  // Convert gallons to liters
        return (float) (input * 3.785);
    }

    private static float convertL2G (float input)
    {  // Convert liters to gallons
        return (float) (input / 3.785);
    }

    // small weight
    private static float convertOz2G (float input)
    {  // Convert ounces to grams
        return (float) (input * 28.35);
    }

    private static float convertG2Oz (float input)
    {  // Convert grams to ounces
        return (float) (input / 28.35);
    }

    // medium weight
    private static float convertLb2K (float input)
    {  // Convert pounds to kilograms
        return (float) (input * 0.4536);
    }

    private static float convertK2Lb (float input)
    {  // Convert kilograms to pounds
        return (float) (input * 2.205);
    }

    private static float convertMphKmph (String inputAsStr)
    {
//        String Mph = "Mph";
//        String Kmph = "Kmph";
        float num1, num2; // temporary variables
        num2 = 1;
        int n;

        return (num2);
    }

//    private static float directionHandler (String unitA, String unitB)    //method for determining which conversion direction is desired,
//    {                                                                     //assuming we halve the number of conversion methods and make each do both directions
//        System.out.println("Please select your desired conversion direction:");
//        System.out.println("1." + unitA + "to" + unitB);
//        System.out.println("2." + unitB + "to" + unitA);
//
//        Scanner menuInput = new Scanner(System.in); //get user input
//        int i = Integer.parseInt(menuInput.nextLine());
//
//    }
}