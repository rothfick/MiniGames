package rothfick.minigames.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rothfick.minigames.reader.LottoInputReader;
import rothfick.minigames.util.LottoGenerator;
import rothfick.minigames.util.LottoMessageGenerator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LottoMiddlewareTest {
    @Mock
    private LottoInputReader inputReader;

    @Mock
    private LottoGenerator generator;

    @Mock
    private LottoMessageGenerator messageGenerator;

    @InjectMocks
    private LottoMiddleware lottoMiddleware;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); // Inicjalizacja mocków

        // Ustawienie inputReader w lottoMiddleware na mock
        lottoMiddleware.setInputReader(inputReader);
    }

    @AfterEach
    void tearDown() {
        // Czyszczenie po każdym teście
        reset(inputReader, generator, messageGenerator);
    }

    @Test
    void testRunLottoGame_Success() throws IOException {
        // Given
        Set<Integer> inputUserNumbers = Set.of(1, 2, 3, 4, 5, 6);
        Set<Integer> lottoNumbers = Set.of(10, 20, 30, 40, 50, 60);

        // Mockowanie zachowania inputReader, generatora i messageGeneratora
        when(inputReader.getSixNumbersFromUser()).thenReturn(inputUserNumbers);
        when(generator.generateLottoNumbers()).thenReturn(lottoNumbers);
        when(messageGenerator.printWinningMessage(lottoNumbers, inputUserNumbers)).thenReturn("Test message");

        // When
        lottoMiddleware.runLottoGame();

        // Then
        verify(inputReader).getSixNumbersFromUser(); // Sprawdzenie czy getSixNumbersFromUser zostało wywołane
        verify(generator).generateLottoNumbers(); // Sprawdzenie czy generateLottoNumbers zostało wywołane
        verify(messageGenerator).printWinningMessage(lottoNumbers, inputUserNumbers); // Sprawdzenie czy printWinningMessage zostało wywołane

        // Dodatkowe asercje na podstawie rzeczywistego zachowania aplikacji
    }

    @Test
    void testRunLottoGame_InputIOException() throws IOException {
        // Given
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n3\n4\n5\n6\n".getBytes());
        System.setIn(in);

        // Mockowanie rzucenia IOException przez inputReader
        when(inputReader.getSixNumbersFromUser()).thenThrow(IOException.class);

        // When
        Executable executable = () -> lottoMiddleware.runLottoGame();

        // Then
        assertThrows(IOException.class, executable); // Sprawdzenie czy metoda rzuciła IOException

        // Sprzątanie po sobie
        in.close();
        System.setIn(sysInBackup);
    }
}