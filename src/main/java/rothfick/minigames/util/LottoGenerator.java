package rothfick.minigames.util;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Utility class for generating Lotto numbers.
 */
public class LottoGenerator {

    /**
     * Generates a set of 6 unique Lotto numbers between 1 and 99 (inclusive).
     *
     * @return a set of 6 unique Lotto numbers
     * @throws IllegalStateException if unable to generate unique numbers within a reasonable number of attempts
     */
    public Set<Integer> generateLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        while (lottoNumbers.size() < 6) {
            int number = random.nextInt(1, 100); // Generates a random number between 1 and 99
            lottoNumbers.add(number);
        }

        if (lottoNumbers.size() != 6) {
            throw new IllegalStateException("Failed to generate 6 unique Lotto numbers");
        }

        return Set.copyOf(lottoNumbers); // Returns an unmodifiable set
    }
}
