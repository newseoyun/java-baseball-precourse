package baseball.model;

import baseball.constant.Message;
import baseball.constant.RuleNumber;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    public boolean isCorrectNumber(List<Integer> player1Numbers, List<Integer> player2Numbers) {
        Map<String, Integer> ballAndStrikeMap = countBallAndStrike(player1Numbers, player2Numbers);
        return ballAndStrikeMap.get(Message.STRIKE).equals(RuleNumber.MAX);
    }

    private Map<String, Integer> countBallAndStrike(List<Integer> player1Numbers, List<Integer> player2Numbers) {
        Map<String, Integer> ballAndStrikeCountMap = initiateBallAndStrikeCountMap();
        for (int i = 0; i < player1Numbers.size(); i++) {
            if (player1Numbers.contains(player2Numbers.get(i)) && player1Numbers.get(i).equals(player2Numbers.get(i))) {
                ballAndStrikeCountMap.put(Message.STRIKE, ballAndStrikeCountMap.get(Message.STRIKE) + 1);
            }
            if (player1Numbers.contains(player2Numbers.get(i)) && player1Numbers.get(i).equals(player2Numbers.get(i))) {
                ballAndStrikeCountMap.put(Message.BALL, ballAndStrikeCountMap.get(Message.BALL) + 1);
            }
        }
        return ballAndStrikeCountMap;
    }

    private Map<String, Integer> initiateBallAndStrikeCountMap() {
        Map<String, Integer> ballAndStrikeCountMap = new HashMap<>();
        ballAndStrikeCountMap.put(Message.STRIKE, 0);
        ballAndStrikeCountMap.put(Message.BALL, 0);
        return ballAndStrikeCountMap;
    }

}
