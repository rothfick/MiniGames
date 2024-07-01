package rothfick.minigames.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import rothfick.minigames.reader.LottoInputReader;
import rothfick.minigames.util.LottoGenerator;
import rothfick.minigames.util.LottoMessageGenerator;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LottoMiddlewareTest {
    private LottoInputReader inputReader;
    private LottoGenerator generator;
    private LottoMessageGenerator messageGenerator;
    private LottoMiddleware lottoMiddleware;

    @BeforeEach
    void setUp() {
        inputReader = mock(LottoInputReader.class);
        generator = mock(LottoGenerator.class);
        messageGenerator = mock(LottoMessageGenerator.class);
        lottoMiddleware = new LottoMiddleware(inputReader, generator, messageGenerator);
    }

    @AfterEach
    void tearDown() {
        inputReader = null;
        generator = null;
        messageGenerator = null;
        lottoMiddleware = null;
    }

    @Test
    void testRunLottoGame_Success() throws IOException {
        // Given
        Set<Integer> inputUserNumbers = new HashSet<>();
        inputUserNumbers.add(1);
        inputUserNumbers.add(2);
        inputUserNumbers.add(3);
        inputUserNumbers.add(4);
        inputUserNumbers.add(5);
        inputUserNumbers.add(6);

        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.add(10);
        lottoNumbers.add(20);
        lottoNumbers.add(30);
        lottoNumbers.add(40);
        lottoNumbers.add(50);
        lottoNumbers.add(60);

        // Mock behavior
        when(inputReader.getSixNumbersFromUser()).thenReturn(inputUserNumbers);
        when(generator.generateLottoNumbers()).thenReturn(lottoNumbers);
        when(messageGenerator.printWinningMessage(lottoNumbers, inputUserNumbers)).thenReturn("Test message");

        // When
        lottoMiddleware.runLottoGame();

        // Then
        verify(inputReader).getSixNumbersFromUser();
        verify(generator).generateLottoNumbers();
        verify(messageGenerator).printWinningMessage(lottoNumbers, inputUserNumbers);
        // Additional assertions based on the actual behavior
    }

    @Test
    void testRunLottoGame_InputIOException() throws IOException {
        // Given
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n3\n4\n5\n6\n".getBytes());
        System.setIn(in);

        // Mock behavior
        when(inputReader.getSixNumbersFromUser()).thenThrow(IOException.class);

        // When
        Executable executable = () -> lottoMiddleware.runLottoGame();

        // Then
        assertThrows(IOException.class, executable);

        // Clean up
        in.close();
        System.setIn(sysInBackup);
    }

    @Test
    void testSeeResultsOfTheLottoGame_Success() {
        // Given
        Set<Integer> inputUserNumbers = new HashSet<>();
        inputUserNumbers.add(1);
        inputUserNumbers.add(2);
        inputUserNumbers.add(3);
        inputUserNumbers.add(4);
        inputUserNumbers.add(5);
        inputUserNumbers.add(6);

        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.add(10);
        lottoNumbers.add(20);
        lottoNumbers.add(30);
        lottoNumbers.add(40);
        lottoNumbers.add(50);
        lottoNumbers.add(60);

        String expectedMessage = "Test message";

        // Mock behavior
        lottoMiddleware.setInputUserNumbers(inputUserNumbers);
        lottoMiddleware.setLottoNumbers(lottoNumbers);
        when(messageGenerator.printWinningMessage(lottoNumbers, inputUserNumbers)).thenReturn(expectedMessage);

        // When
        lottoMiddleware.seeResultsOfTheLottoGame();

        // Then
        assertEquals(expectedMessage, outContent.toString().trim());
    }

    // Helper method to redirect System.out to a string for testing
    private final InputStream sysInBackup = System.in;
    private ByteArrayInputStream in;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(sysInBackup);
        System.setOut(System.out);
    }
}