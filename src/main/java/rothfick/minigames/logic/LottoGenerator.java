package rothfick.minigames.logic;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public final Set<Integer> lottoNumbers = generateLottoNumbers();

    private Set<Integer> generateLottoNumbers(){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.ints(1,99).limit(6).boxed().collect(Collectors.toSet());
    }
}
