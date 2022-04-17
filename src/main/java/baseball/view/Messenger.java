package baseball.view;

import baseball.constant.Message;
import java.util.Map;

public class Messenger {

    public void printStart() {
        System.out.print(Message.GAME_START);
    }

    public void printEnd() {
        System.out.println(Message.THE_END);
    }

    public void printSuccessEnd() {
        System.out.println(Message.SUCCESS_END);
    }

    public void printRetry() {
        System.out.println(Message.RETRY_INFO);
    }

    public void printResult(Map<String, Integer> countMap) {
        printIfNothingAndEnd(countMap);
        printBallStrike(countMap);
    }

    private void printIfNothingAndEnd(Map<String, Integer> countMap) {
        if (countMap.get(Message.BALL).equals(0) && countMap.get(Message.STRIKE).equals(0)) {
            System.out.println(Message.NOTHING);
            return;
        }
    }

    private void printBallStrike(Map<String, Integer> countMap) {
        String strikeMessage = "";
        String ballMessage = "";
        if (!countMap.get(Message.BALL).equals(0)) {
            ballMessage = countMap.get(Message.BALL) + Message.BALL + " ";
        }
        if (!countMap.get(Message.STRIKE).equals(0)) {
            strikeMessage = countMap.get(Message.STRIKE) + Message.STRIKE + " ";
        }
        System.out.println(ballMessage + strikeMessage);
    }

}
