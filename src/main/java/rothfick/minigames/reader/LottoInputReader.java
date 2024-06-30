package rothfick.minigames.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for reading Lotto numbers from user input.
 */
public class LottoInputReader {
    private final BufferedReader reader;
    private static final int MAX_ATTEMPTS = 10; // Max attempts to read valid input

    /**
     * Constructs a LottoInputReader with the specified BufferedReader.
     *
     * @param reader the BufferedReader to read user input
     */
    public LottoInputReader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * Reads and returns a set of 6 unique numbers entered by the user.
     *
     * @return a set of 6 unique numbers entered by the user
     * @throws IOException if an I/O error occurs while reading input
     * @throws IllegalStateException if unable to read valid input within MAX_ATTEMPTS attempts
     */
    public Set<Integer> getSixNumbersFromUser() throws IOException {
        Set<Integer> sixNumbers = new HashSet<>();
        int attempts = 0;

        while (sixNumbers.size() < 6 && attempts < MAX_ATTEMPTS) {
            Integer number = readUserInput();
            if (number != null) {
                if (!sixNumbers.add(number)) {
                    System.out.println("This number has already been entered. Please try again.");
                } else {
                    System.out.println("You entered numbers: " + sixNumbers.size());
                    System.out.println("Entered numbers: " + sixNumbers + "\n");
                }
            }
            attempts++;
        }

        if (attempts >= MAX_ATTEMPTS) {
            throw new IllegalStateException("Exceeded maximum attempts to read valid input.");
        }

        return sixNumbers;
    }

    /**
     * Reads an integer from user input and validates it.
     *
     * @return the integer entered by the user, or null if input is invalid
     * @throws IOException if an I/O error occurs while reading input
     */
    private Integer readUserInput() throws IOException {
        System.out.println("Enter a number from 0 to 99:");
        String input = reader.readLine();
        try {
            int number = Integer.parseInt(input);
            if (number >= 0 && number <= 99) {
                return number;
            } else {
                System.out.println("Number out of range. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please try again.");
        }
        return null;
    }
}