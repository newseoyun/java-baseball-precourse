package baseball.model;

import baseball.constant.Message;
import baseball.constant.RuleNumber;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    private Map<String, Integer> gameScoreMap = new HashMap<>();

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
        initiateGameScoreMap();
        for (int i = 0; i < userNumbers.size(); i++) {
            putBallCount(computerNumbers, userNumbers, i);
            putStrikeCount(computerNumbers, userNumbers, i);
        }
    }

    private void putStrikeCount(List<Integer> computerNumbers, List<Integer> userNumbers, int i) {
        if (computerNumbers.contains(userNumbers.get(i)) && !computerNumbers.get(i).equals(userNumbers.get(i))) {
            gameScoreMap.put(Message.BALL, gameScoreMap.get(Message.BALL) + 1);
        }
    }

    private void putBallCount(List<Integer> computerNumbers, List<Integer> userNumbers, int i) {
        if (computerNumbers.contains(userNumbers.get(i)) && computerNumbers.get(i).equals(userNumbers.get(i))) {
            gameScoreMap.put(Message.STRIKE, gameScoreMap.get(Message.STRIKE) + 1);
        }
    }

    private void initiateGameScoreMap() {
        gameScoreMap.put(Message.STRIKE, 0);
        gameScoreMap.put(Message.BALL, 0);
    }

}
