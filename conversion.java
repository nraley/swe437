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
********************************************************************* */


// Import Java Libraries
import java.util.*;

public class conversion
{

    public static void main(String[]args){
        System.out.println("(Not So) On-line Measurement Conversion"); // on first run, print menu
        printMenu(); // print menu will ask for number between 1 and 14

        // Known error, check for strings, only allow ints
        Scanner menuInput = new Scanner(System.in); //get user input
        int i = Integer.parseInt(menuInput.nextLine());
        // user should put in a number between 1 and 14, else the while loop is not entered.
        while ((i > 0) && (i < 15))  {
            // once an option chosen, ask the user what number they want to convert
            System.out.println("What number would you like to convert?\n");
            String c = menuInput.nextLine();
            
            switch (i) {
                case 1:
                    System.out.println("Selected option is Fahrenheit to Celsius");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertF2C(c));
                    break;
                case 2:
                    System.out.println("Selected option is Celsius to Fahrenheit");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertC2F(c));;
                    break;
                case 3:
                    System.out.println("Selected option is Inches to Centimeters");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertIn2Cm(c));;
                    break;
                case 4:
                    System.out.println("Selected option is Centimeters to Inches");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertCm2In(c));;
                    break;
                case 5:
                    System.out.println("Selected option is Feet to Meters");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertF2M(c));;
                    break;
                case 6:
                    System.out.println("Selected option is Meters to Feet");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertM2F(c));;
                    break;
                case 7:
                    System.out.println("Selected option is Miles to Kilometers");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertM2K(c));;
                    break;
                case 8:
                    System.out.println("Selected option is Kilometers to Miles");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertK2M(c));;
                    break;
                case 9:
                    System.out.println("Selected option is Gallons to Liters");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertG2L(c));;
                    break;
                case 10:
                    System.out.println("Selected option is Liters to Gallons");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertL2G(c));;
                    break;
                case 11:
                    System.out.println("Selected option is Ounces to Gallons");;
                    System.out.print("Conversion result is: ");
                    System.out.println(convertOz2G(c));;
                    break;
                case 12:
                    System.out.println("Selected option is Gallons to Ounces");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertG2Oz(c));;
                    break;
                case 13:
                    System.out.println("Selected option is Pounds to Kilograms");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertLb2K(c));;
                    break;
                case 14:
                    System.out.println("Selected option is Kilograms to Pounds");
                    System.out.print("Conversion result is: ");
                    System.out.println(convertK2Lb(c));;
                    break;
                default:
                    System.out.println("Please enter a valid menu item.");
                    break;
            }
            System.out.println("\n");
            printMenu();
            i = Integer.parseInt(menuInput.nextLine());
        }
        menuInput.close();
    }

    public static void printMenu() {
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

/** *****************************************************
 *  Conversion methods below
 *  14 methods, 2 for each pair of units
********************************************************* */
private static float convertF2C (String FAsStr)
{  // Convert farenheit to celsius
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf(FAsStr).floatValue());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) ( ( (num1-32.0) * 5.0) / 9.0);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return (num2);
}

private static float convertC2F (String CAsStr)
{  // Convert celsius to farenheit
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (CAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) ( (num1 * 9.0 / 5.0) + 32.0);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

// small distance
private static float convertIn2Cm (String inAsStr)
{  // Convert inches to centimeters
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (inAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 2.54);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

private static float convertCm2In (String cmAsStr)
{  // Convert centimeters to inches
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (cmAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 0.3937);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

// medium distance
private static float convertF2M (String ftAsStr)
{  // Convert feet to meters
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (ftAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 0.3048);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

private static float convertM2F (String mAsStr)
{  // Convert meters to feet
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (mAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 / 0.6048);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

// large distance
private static float convertM2K (String miAsStr)
{  // Convert miles to kilometers
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (miAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 1.609);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

private static float convertK2M (String kmAsStr)
{  // Convert kilometers to miles
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (kmAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 0.6214);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

// volume
private static float convertG2L (String galAsStr)
{  // Convert gallons to liters
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (galAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 3.785);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

private static float convertL2G (String LAsStr)
{  // Convert liters to gallons
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (LAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 / 3.785);
   return(num2);
}

// small weight
private static float convertOz2G (String ozAsStr)
{  // Convert ounces to grams
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (ozAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 28.35);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

private static float convertG2Oz (String gAsStr)
{  // Convert grams to ounces
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (gAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 / 28.35);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

// medium weight
private static float convertLb2K (String lbAsStr)
{  // Convert pounds to kilograms
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (lbAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 0.4536);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}

private static float convertK2Lb (String kgAsStr)
{  // Convert kilograms to pounds
   float num1, num2; // temporary variables
   int n; // temporary variable
   // Round to 2 digits past decimal
   num1 = (Float.valueOf (kgAsStr).floatValue ());
   n    = Math.round(num1 * (float)100.0);
   num1 = (float) (n / (float)100.0);
   // Convert
   num2 = (float) (num1 * 2.205);
   // Back to 2 digits
   n    = Math.round(num2 * (float)100.0);
   num2 = (float) (n / (float)100.0);
   return(num2);
}
}

//.