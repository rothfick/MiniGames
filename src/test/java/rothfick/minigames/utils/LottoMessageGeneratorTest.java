package rothfick.minigames.utils;

import org.junit.jupiter.api.Test;
import rothfick.minigames.util.LottoMessageGenerator;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class LottoMessageGeneratorTest {

    @Test
    void testPrintWinningMessage_ZeroNumbers() {
        // Given
        Set<Integer> winningNumbers = Set.of(10, 20, 30, 40, 50, 60);
        Set<Integer> userNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // When
        LottoMessageGenerator generator = new LottoMessageGenerator();
        String message = generator.printWinningMessage(winningNumbers, userNumbers);

        // Then
        assertEquals("You didn't guess any numbers", message);
    }

    @Test
    void testPrintWinningMessage_OneNumber() {
        // Given
        Set<Integer> winningNumbers = Set.of(10, 20, 30, 40, 50, 60);
        Set<Integer> userNumbers = Set.of(1, 2, 3, 4, 5, 10);

        // When
        LottoMessageGenerator generator = new LottoMessageGenerator();
        String message = generator.printWinningMessage(winningNumbers, userNumbers);

        // Then
        assertTrue(message.startsWith("You guessed 1 number: "));
        assertTrue(message.contains("10"));
    }

    @Test
    void testPrintWinningMessage_SixNumbers() {
        // Given
        Set<Integer> winningNumbers = Set.of(10, 20, 30, 40, 50, 60);
        Set<Integer> userNumbers = Set.of(10, 20, 30, 40, 50, 60);

        // When
        LottoMessageGenerator generator = new LottoMessageGenerator();
        String message = generator.printWinningMessage(winningNumbers, userNumbers);

        // Then
        assertTrue(message.startsWith("You guessed all 6 numbers: "));
        assertTrue(message.contains("10") && message.contains("20") && message.contains("30") &&
                message.contains("40") && message.contains("50") && message.contains("60"));
    }
}