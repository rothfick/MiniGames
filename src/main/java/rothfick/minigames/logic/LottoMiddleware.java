package rothfick.minigames.logic;

import lombok.Getter;
import lombok.Setter;
import rothfick.minigames.reader.LottoInputReader;
import rothfick.minigames.util.LottoGenerator;
import rothfick.minigames.util.LottoMessageGenerator;

import java.io.IOException;
import java.util.Set;

public class LottoMiddleware {
    /**
     * -- GETTER --
     * Getter for inputReader.
     * <p>
     * <p>
     * -- SETTER --
     * Setter for inputReader to facilitate dependency injection in tests.
     *
     * @return LottoInputReader instance
     * @param inputReader LottoInputReader instance
     */
    @Setter
    @Getter
    private LottoInputReader inputReader;
    private LottoGenerator generator;
    private LottoMessageGenerator lottoMessageGenerator;
    @Setter
    @Getter
    private Set<Integer> inputUserNumbers;
    @Setter
    @Getter
    private Set<Integer> lottoNumbers;

    /**
     * Constructs a LottoMiddleware object with dependencies injected.
     *
     * @param inputReader           LottoInputReader instance
     * @param generator             LottoGenerator instance
     * @param lottoMessageGenerator LottoMessageGenerator instance
     */
    public LottoMiddleware(LottoInputReader inputReader, LottoGenerator generator, LottoMessageGenerator lottoMessageGenerator) {
        this.inputReader = inputReader;
        this.generator = generator;
        this.lottoMessageGenerator = lottoMessageGenerator;
    }

    /**
     * Runs the Lotto game.
     */
    public void runLottoGame() {
        try {
            inputUserNumbers = inputReader.getSixNumbersFromUser();
            lottoNumbers = generator.generateLottoNumbers();
            seeResultsOfTheLottoGame();
        } catch (IOException e) {
            System.err.println("An error occurred while reading user input or generating lotto numbers.");
            e.printStackTrace();
        }
    }

    /**
     * Prints the results of the Lotto game.
     */
    void seeResultsOfTheLottoGame() {
        if (inputUserNumbers != null && lottoNumbers != null) {
            System.out.println(lottoMessageGenerator.printWinningMessage(lottoNumbers, inputUserNumbers));
        } else {
            System.err.println("Initialization failed. Unable to display results.");
        }
    }
}