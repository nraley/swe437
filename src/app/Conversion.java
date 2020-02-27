/**
*********************************************************************
    Conversion.java
    Converts various measures from one unit to another

    Original webapp:
    @author Jeff Offutt & Ren Li
        @version 1.0    October 2000
        @version 2.0    June 2015
        @version 2.1    January 2020 - https://cs.gmu.edu:8443/offutt/servlet/conversion

    Command line UI modification:
    @author Nelson Raley, Gabriel Bartholomäus-Cabezas, Michael Pham
        @version 1.0 February 6 2020
        @version 1.1 February 13 2020
        @version 1.2 February 19 2020
        @version 1.3 March X 2020
*********************************************************************
*/
package app;
import java.util.Scanner;

public class Conversion {

    public static void main(String[] args) {
        Scanner menuInput;
        int precision;
        int i;
        double userInput;
        double retVal;
        String print;
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
        System.out.println(
                    "Please enter a number between 0 and 4 to set the number of digits after the decimal mark:");
        precision = (int) Math.round(getUserInput(menuInput));

        printMenu(); // print menu will ask for number between 1 and 17
        i = (int) Math.round(getUserInput(menuInput));

        // user should put in a number between 1 and 17, else the while loop is not
        // entered.
        while ((i > 0) && (i < 17)) {
            // once an option chosen, ask the user what number they want to convert
            System.out.println("What number would you like to convert?\n");
            userInput = getUserInput(menuInput);
            retVal = 0.0;
            switch (i) {
            case 1:
                System.out.println("Selected option is Fahrenheit to Celsius");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 1);
                break;
            case 2:
                System.out.println("Selected option is Celsius to Fahrenheit");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 2);
                break;
            case 3:
                System.out.println("Selected option is Inches to Centimeters");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 3);
                break;
            case 4:
                System.out.println("Selected option is Centimeters to Inches");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 4);
                break;
            case 5:
                System.out.println("Selected option is Feet to Meters");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 5);
                break;
            case 6:
                System.out.println("Selected option is Meters to Feet");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 6);
                break;
            case 7:
                System.out.println("Selected option is Miles to Kilometers");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 7);
                break;
            case 8:
                System.out.println("Selected option is Kilometers to Miles");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 8);
                break;
            case 9:
                System.out.println("Selected option is Gallons to Liters");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 9);
                break;
            case 10:
                System.out.println("Selected option is Liters to Gallons");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 10);
                break;
            case 11:
                System.out.println("Selected option is Ounces to Gallons");
                ;
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 11);
                break;
            case 12:
                System.out.println("Selected option is Gallons to Ounces");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 12);
                break;
            case 13:
                System.out.println("Selected option is Pounds to Kilograms");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 13);
                break;
            case 14:
                System.out.println("Selected option is Kilograms to Pounds");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 14);
                break;
            case 15:
                System.out.println("Selected option is Miles per hour to Kilometer per hour");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 15);
                break;
            case 16:
                System.out.println("Selected option is Kilometer per hour to Miles per hour");
                System.out.print("Conversion result is: ");
                retVal = convertUnits(userInput, 16);
                break;
            default:
                System.out.println("Please enter a valid menu item.");
                break;
            }

            // Formats result and prints it
            print = formatResult(retVal, precision);
            if (!print.equals("ERR")) {
                System.out.println(print);
            } else {
                System.out.println("Precision not properly set. Result not returned.");
            }
            
            // after printing result, ask to choose accuracy level again
            System.out.println(
                    "Please enter a number between 0 and 4 to set the number of digits after the decimal mark:");
            precision = (int) Math.round(getUserInput(menuInput));
            // print menu again and restart conversion process
            printMenu();
            i = (int) Math.round(getUserInput(menuInput));
        }
        menuInput.close();
    }

    public static double getUserInput(Scanner inputMethod) {
        double result = (double) 0.0;
        String userInput = "";
        boolean properInput = false;
        while (!properInput) {
            userInput = inputMethod.nextLine();
            try {
                result = Float.parseFloat(userInput);
                properInput = true;
            } catch (Exception e) {
                System.out.println("Please input a number");
            }
        }
        return result;
    }

    public static void printMenu() {
        System.out.println("Please choose between options 1 to 17 to convert a value:");
        System.out.println(
                  "1.  Fahrenheit (Fº)           --->     Celsius (Cº)\n"
                + "2.  Celsius (Cº)              --->     Fahrenheit (Fº)\n"
                + "3.  Inch (in)                 --->     Centimeter (cm)\n"
                + "4.  Centimeter (cm)           --->     Inch (in)\n"
                + "5.  Feet (ft)                 --->     Meter (m)\n"
                + "6.  Meter (m)                 --->     Feet (ft)\n"
                + "7.  Mile (mi)                 --->     Kilometer (km)\n"
                + "8.  Kilometer (km)            --->     Mile (mi)\n"
                + "9.  Gallon (gal)              --->     Liter (L)\n"
                + "10. Liter (L)                 --->     Gallon (gal)\n"
                + "11. Ounce (oz)                --->     Gram (g)\n"
                + "12. Gram (g)                  --->     Ounce (oz)\n"
                + "13. Pound (lb)                --->     Kilogram (kg)\n"
                + "14. Kilogram (kg)             --->     Pound (lb)\n"
                + "15. Miles per hour (mph)      --->     Kilometer per hour (km/h)\n"
                + "16. Kilometer per hour (km/h) --->     Miles per hour (mph)\n"
                + "17. Quit\n");
    }

    // Formats the result of conversion with a level of precision specified by the
    // user
    public static String formatResult(double input, int precision) {
        String result;

        if (precision == 4) {
            result = String.format("%.4f", input);
        } else if (precision == 3) {
            result = String.format("%.3f", input);
        } else if (precision == 2) {
            result = String.format("%.2f", input);
        } else if (precision == 1) {
            result = String.format("%.1f", input);
        } else if (precision == 0) {
            result = String.format("%.0f", input);
        } else {
            result = "ERR";
        }

        return result;
    }

    public static double convertUnits(double original, int conversionOption) {
        double newNum;

        switch (conversionOption) {
            case 1:
                newNum = (original - 32.0) * 5.0 / 9.0; // Fahrenheit to Celsius
                break;
            case 2:
                newNum = (original * 9.0 / 5.0) + 32.0; // Celsius to Fahrenheit
                break;
            case 3:
                newNum = original * 2.54; // Inch to Centimeter
                break;
            case 4:
                newNum = original / 2.54; // Centimeter to Inch
                break;
            case 5:
                newNum = original / 3.281; // Foot to Meter
                break;
            case 6:
                newNum = original * 3.281; // Meter to Foot
                break;
            case 7:
                newNum = original * 1.609; // Mile to Kilometer
                break;
            case 8:
                newNum = original / 1.609; // Kilometer to Mile
                break;
            case 9:
                newNum = original * 3.785; // Gallon to Liter
                break;
            case 10:
                newNum = original / 3.785; // Liter to Gallon
                break;
            case 11:
                newNum = original * 28.35; // Ounce to Gram
                break;
            case 12:
                newNum = original / 28.35; // Gram to Ounce
                break;
            case 13:
                newNum = original / 2.205; // Pound to Kilogram
                break;
            case 14:
                newNum = original * 2.205; // Kilogram to Pound
                break;
            case 15:
                newNum = original * 1.609; // Miles per hour to Kilometer per hour
                break;
            case 16:
                newNum = original / 1.609; // Kilometer per hour to Miles per hour
                break;
            default:
                System.out.println("Invalid conversion option. Giving back original without converting");
                newNum = original; // No conversion
                break;
        }

        return newNum;
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
    // } //
}