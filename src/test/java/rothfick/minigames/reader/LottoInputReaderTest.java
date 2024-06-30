package rothfick.minigames.reader;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LottoInputReaderTest {

    @Test
    void testGetSixNumbersFromUser_ValidInput() throws IOException {
        // Given
        String input = "1\n2\n3\n4\n5\n6\n";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));
        LottoInputReader inputReader = new LottoInputReader(reader);

        // When
        Set<Integer> numbers = inputReader.getSixNumbersFromUser();

        // Then
        assertNotNull(numbers);
        assertEquals(6, numbers.size());
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(2));
        assertTrue(numbers.contains(3));
        assertTrue(numbers.contains(4));
        assertTrue(numbers.contains(5));
        assertTrue(numbers.contains(6));
    }
}