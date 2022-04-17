package baseball.model;

import baseball.constant.Message;
import baseball.constant.RuleNumber;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    private Map<String, Integer> gameScoreMap;

    public boolean isCorrect(Map<String, Integer> gameScoreMap) {
        return gameScoreMap.get(Message.STRIKE).equals(RuleNumber.MAX);
    }

    public Map<String, Integer> judgeNumberBetween(Computer computer, User user) {
        List<Integer> computerBaseballNumbers = computer.getBaseballNumbers();
        List<Integer> userBaseballNumbers = user.getBaseballNumbers();
        judgeAndSaveResult(computerBaseballNumbers, userBaseballNumbers);
        return this.gameScoreMap;
    }

    private void judgeAndSaveResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        Map<String, Integer> ballAndStrikeCountMap = initiateBallAndStrikeCountMap();
        for (int i = 0; i < userNumbers.size(); i++) {
            putBallCount(computerNumbers, userNumbers, ballAndStrikeCountMap, i);
            putStrikeCount(computerNumbers, userNumbers, ballAndStrikeCountMap, i);
        }
        this.gameScoreMap = ballAndStrikeCountMap;
    }

    private void putStrikeCount(List<Integer> computerNumbers, List<Integer> userNumbers,
                           Map<String, Integer> ballAndStrikeCountMap, int i) {
        if (computerNumbers.contains(userNumbers.get(i)) && !computerNumbers.get(i).equals(userNumbers.get(i))) {
            ballAndStrikeCountMap.put(Message.BALL, ballAndStrikeCountMap.get(Message.BALL) + 1);
        }
    }

    private void putBallCount(List<Integer> computerNumbers, List<Integer> userNumbers,
                           Map<String, Integer> ballAndStrikeCountMap, int i) {
        if (computerNumbers.contains(userNumbers.get(i)) && computerNumbers.get(i).equals(userNumbers.get(i))) {
            ballAndStrikeCountMap.put(Message.STRIKE, ballAndStrikeCountMap.get(Message.STRIKE) + 1);
        }
    }

    private Map<String, Integer> initiateBallAndStrikeCountMap() {
        Map<String, Integer> ballAndStrikeCountMap = new HashMap<>();
        ballAndStrikeCountMap.put(Message.STRIKE, 0);
        ballAndStrikeCountMap.put(Message.BALL, 0);
        return ballAndStrikeCountMap;
    }

}
