package rothfick.minigames.util;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LottoGeneratorTest {

    @Test
    void testGenerateLottoNumbers() {
        LottoGenerator generator = new LottoGenerator();

        // When
        Set<Integer> lottoNumbers = generator.generateLottoNumbers();

        // Then
        assertNotNull(lottoNumbers);
        assertEquals(6, lottoNumbers.size(), "Expected exactly 6 numbers");

        // Check if all numbers are between 1 and 99
        for (int number : lottoNumbers) {
            assertTrue(number >= 1 && number <= 99, "Number " + number + " is out of range");
        }

        // Check uniqueness of numbers
        assertEquals(lottoNumbers.size(), lottoNumbers.stream().distinct().count(),
                "Expected all numbers to be unique");
    }
}
