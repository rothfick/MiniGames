package rothfick.minigames.logic;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;


public class LottoGeneratorTest {

    LottoGenerator lottoGenerator;
    private final int SIZE_OF_SET_WITH_WINNING_NUMBERS = 6;

    @BeforeEach
    public void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    void shouldLottoGeneratorGenerate6numbers() {
        //given
        Set<Integer> winningNumbers = lottoGenerator.lottoNumbers;

        //when
        int size = winningNumbers.size();

        //then
        assertThat(size).isEqualTo(SIZE_OF_SET_WITH_WINNING_NUMBERS);
    }

    @Test
    void shouldLottoGeneratorGenerateNumbersBetween1and99() {
        //given
        Set<Integer> winningNumbers = lottoGenerator.lottoNumbers;

        //when
        for (int number : winningNumbers) {
            //then
            assertTrue(number >= 1 && number <= 99, "Number " + number + " is not between 1 and 99");
        }

    }
}
