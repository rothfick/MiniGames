package rothfick.minigames;

import rothfick.minigames.logic.LottoGame;
import rothfick.minigames.logic.LottoMiddleware;
import rothfick.minigames.reader.LottoInputReader;
import rothfick.minigames.util.LottoGenerator;
import rothfick.minigames.util.LottoMessageGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MiniGamesApplication {
    public static void main(String[] args) {
        // Create necessary instances
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LottoInputReader inputReader = new LottoInputReader(reader);
        LottoGenerator generator = new LottoGenerator();
        LottoMessageGenerator messageGenerator = new LottoMessageGenerator();

        // Create LottoMiddleware instance with dependencies injected
        LottoMiddleware middleware = new LottoMiddleware(inputReader, generator, messageGenerator);

        // Create LottoGame instance with LottoMiddleware injected
        LottoGame game = new LottoGame(middleware);

        // Play the game
        game.playGame();
    }
}
