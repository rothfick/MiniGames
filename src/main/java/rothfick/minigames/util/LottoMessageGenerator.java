package rothfick.minigames.util;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A utility class to generate winning messages for Lotto games.
 */
public class LottoMessageGenerator {

    /**
     * Enum representing the number of matching numbers.
     */
    private enum WINNING_NUMBERS {
        ZERO_NUMBERS,
        ONE_NUMBER,
        TWO_NUMBERS,
        THREE_NUMBERS,
        FOUR_NUMBERS,
        FIVE_NUMBERS,
        SIX_NUMBERS
    }

    private static final Map<WINNING_NUMBERS, String> WINNING_MESSAGES = new EnumMap<>(WINNING_NUMBERS.class);

    static {
        WINNING_MESSAGES.put(WINNING_NUMBERS.SIX_NUMBERS, "You guessed all 6 numbers: ");
        WINNING_MESSAGES.put(WINNING_NUMBERS.FIVE_NUMBERS, "You guessed 5 numbers: ");
        WINNING_MESSAGES.put(WINNING_NUMBERS.FOUR_NUMBERS, "You guessed 4 numbers: ");
        WINNING_MESSAGES.put(WINNING_NUMBERS.THREE_NUMBERS, "You guessed 3 numbers: ");
        WINNING_MESSAGES.put(WINNING_NUMBERS.TWO_NUMBERS, "You guessed 2 numbers: ");
        WINNING_MESSAGES.put(WINNING_NUMBERS.ONE_NUMBER, "You guessed 1 number: ");
        WINNING_MESSAGES.put(WINNING_NUMBERS.ZERO_NUMBERS, "You didn't guess any numbers");
    }

    /**
     * Generates a message indicating the number of matching numbers.
     *
     * @param winningNumbers the set of winning numbers
     * @param userNumbers    the set of user's numbers
     * @return a message indicating how many numbers the user guessed correctly
     */
    public String printWinningMessage(Set<Integer> winningNumbers, Set<Integer> userNumbers) {
        Set<Integer> commonElements = winningNumbers.stream()
                .filter(userNumbers::contains)
                .collect(Collectors.toSet());

        int sizeOfCommonElements = commonElements.size();

        if (sizeOfCommonElements < 0 || sizeOfCommonElements > 6) {
            throw new IllegalStateException("Unexpected number of common elements: " + sizeOfCommonElements);
        }

        WINNING_NUMBERS numbersCount = WINNING_NUMBERS.values()[sizeOfCommonElements];

        String message = WINNING_MESSAGES.get(numbersCount);
        if (numbersCount == WINNING_NUMBERS.ZERO_NUMBERS) {
            return message;
        } else {
            return message + commonElements;
        }
    }
}