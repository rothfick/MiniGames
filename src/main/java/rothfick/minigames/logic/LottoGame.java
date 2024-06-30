package rothfick.minigames.logic;

import rothfick.minigames.logic.LottoMiddleware;
import rothfick.minigames.controllers.Game;

public class LottoGame implements Game {
    private LottoMiddleware lottoMiddleware;

    /**
     * Constructs a LottoGame object with dependencies injected.
     *
     * @param lottoMiddleware LottoMiddleware instance
     */
    public LottoGame(LottoMiddleware lottoMiddleware) {
        this.lottoMiddleware = lottoMiddleware;
    }

    @Override
    public void playGame() {
        lottoMiddleware.runLottoGame();
    }
}
