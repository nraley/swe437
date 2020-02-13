/**
*********************************************************************
    Conversion.java
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
*********************************************************************
*/

/**
 * Known Errors:
 *  - Scanner use only allows ints, another input type will crash
 */

// Only thing we need to import is Scanner
import java.util.Scanner;

public class Conversion {

    public static void main(String[] args) {
        Scanner menuInput;
        int precision;
        int i;
        double userInput;
        double retVal;

        // on first run, print menu
        System.out.println(
                            "\n"
                            + "*****************************************\n"
                            + "*(Not So) On-line Measurement Conversion*\n"
                            + "*****************************************\n");

        menuInput = new Scanner(System.in); // get user input

        // The instructions say the accuracy levels are from 0 to 4
        // 0 would just be an int like 212
        // 1 would be like 212.6
        // 2 would produce 212.65 and so on for 3 and 4
        System.out.println("Please enter a number between 0 and 4 to set the number of digits after the decimal mark:");
        precision = Integer.parseInt(menuInput.nextLine());

        printMenu(); // print menu will ask for number between 1 and 14
        i = Integer.parseInt(menuInput.nextLine());

        // user should put in a number between 1 and 14, else the while loop is not
        // entered.
        while ((i > 0) && (i < 15)) {
            // once an option chosen, ask the user what number they want to convert
            System.out.println("What number would you like to convert?\n");
            userInput = (Float.parseFloat(menuInput.nextLine()));
            retVal = 0.0;
            switch (i) {
            case 1:
                System.out.println("Selected option is Fahrenheit to Celsius");
                System.out.print("Conversion result is: ");
                retVal = convertF2C(userInput);
                break;
            case 2:
                System.out.println("Selected option is Celsius to Fahrenheit");
                System.out.print("Conversion result is: ");
                retVal = convertC2F(userInput);
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
                retVal = convertM2F(userInput);
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
                System.out.println("Selected option is Ounces to Gallons");
                ;
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
            // after printing result, ask to choose accuracy level again
            System.out.println(
                    "Please enter a number between 0 and 4 to set the number of digits after the decimal mark:");
            precision = Integer.parseInt(menuInput.nextLine());
            // print menu again and restart conversion process
            printMenu();
            i = Integer.parseInt(menuInput.nextLine());
        }
        menuInput.close();
    }

    public static void printMenu() {
        System.out.println("Please choose between options 1 to 14 to convert a value:");
        System.out.println(
                  "1. Fahrenheit (Fº)     ----->     Celsius (Cº)\n"
                + "2. Celsius (Cº)        ----->     Fahrenheit (Fº)\n"
                + "3. Inch (in)           ----->     Centimeter (cm)\n"
                + "4. Centimeter (cm)     ----->     Inch (in)\n"
                + "5. Feet (ft)           ----->     Meter (m)\n"
                + "6. Meter (m)           ----->     Feet (ft)\n"
                + "7. Mile (mi)           ----->     Kilometer (km)\n"
                + "8. Kilometer (km)      ----->     Mile (mi)\n"
                + "9. Gallon (gal)        ----->     Liter (L)\n"
                + "10. Liter (L)          ----->     Gallon (gal)\n"
                + "11. Ounce (oz)         ----->     Gram (g)\n"
                + "12. Gram (g)           ----->     Ounce (oz)\n"
                + "13. Pound (lb)         ----->     Kilogram (kg)\n"
                + "14. Kilogram (kg)      ----->     Pound (lb)\n"
                + "15. Quit\n");
    }

    // Prints the result of conversion with a level of precision specified by the
    // user
    public static void printResult(double input, double precision) {
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

    /**
     * ***************************************************** Conversion methods
     * below 14 methods, 2 for each pair of units
     */
    private static double convertF2C(double input) { // Convert farenheit to celsius
        return (((input - 32.0) * 5.0) / 9.0);
    }

    private static double convertC2F(double input) { // Convert celsius to farenheit
        return ((input * 9.0 / 5.0) + 32.0);
    }

    // small distance
    private static double convertIn2Cm(double input) { // Convert inches to centimeters
        return (input * 2.54);
    }

    private static double convertCm2In(double input) { // Convert centimeters to inches
        return (input * 0.3937);
    }

    // medium distance
    private static double convertF2M(double input) { // Convert feet to meters
        return (input * 0.3048);
    }

    private static double convertM2F(double input) { // Convert meters to feet
        return (input / 0.6048);
    }

    // large distance
    private static double convertM2K(double input) { // Convert miles to kilometers
        return (input * 1.609);
    }

    private static double convertK2M(double input) { // Convert kilometers to miles
        return (input * 0.6214);
    }

    // volume
    private static double convertG2L(double input) { // Convert gallons to liters
        return (input * 3.785);
    }

    private static double convertL2G(double input) { // Convert liters to gallons
        return (input / 3.785);
    }

    // small weight
    private static double convertOz2G(double input) { // Convert ounces to grams
        return (input * 28.35);
    }

    private static double convertG2Oz(double input) { // Convert grams to ounces
        return (input / 28.35);
    }

    // medium weight
    private static double convertLb2K(double input) { // Convert pounds to kilograms
        return (input * 0.4536);
    }

    private static double convertK2Lb(double input) { // Convert kilograms to pounds
        return (input * 2.205);
    }

    private static double convertMphKmph(double input) {
        // String Mph = "Mph";
        // String Kmph = "Kmph";
        // placeholder
        double num2 = input; // temporary variables

        return (num2);
    }

    // private static float directionHandler (String unitA, String unitB) //method
    // for determining which conversion direction is desired,
    // { //assuming we halve the number of conversion methods and make each do both
    // directions
    // System.out.println("Please select your desired conversion direction:");
    // System.out.println("1." + unitA + "to" + unitB);
    // System.out.println("2." + unitB + "to" + unitA);
    //
    // Scanner menuInput = new Scanner(System.in); //get user input
    // int i = Integer.parseInt(menuInput.nextLine());
    //
    // }
}
