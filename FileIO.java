import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
* The program  is to read and then print on a file 
*
* @author Titwech Wal
* @version 1.0
* @since   2023-02-27
*/

public final class FileIO {

    /**
    * This is a private constructor used to satisfy
    * the style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */
    public static void main(String[] args) {
        // Import & output file as parameter
        final File fileIn = new File("Unit1-06-input.txt");
        final File fileOut = new File("Unit1-06-output.txt");

        try {

            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(fileIn);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {

                // Read as string
                final String line = sc.nextLine();

                // Split the pieces and return to array
                final String[] arrOfString = line.split(" ");
                int sum = 0;
                final int number = 0;

                if (line.isEmpty()) {
                    write.println("Not a number");

                } else {
                    for (String numberStr: arrOfString) {

                        try {
                            // Convert the string to a int
                            final int numberInt = Integer.parseInt(numberStr);
                            sum += numberInt;
                            // or sum = sum + number ^

                        } catch (NumberFormatException error) {
                            write.println("No integers were found on this line."
                                + error.getMessage());
                        }
                    }
                    // Display the sum
                    write.println("The sum of all numbers is " + sum);
                }
            }

            // Close scanner
            sc.close();
            write.close();

        } catch (IOException error) {
            System.out.println("An error occurred: "
                + error.getMessage());
        }
    }
}
