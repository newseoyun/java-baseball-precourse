package baseball.controller;

import baseball.model.Computer;
import baseball.model.Referee;
import baseball.model.User;
import baseball.view.Messenger;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class GameController {

    private Computer computer = new Computer();
    private User user;
    private Referee referee = new Referee();
    private Messenger messenger = new Messenger();

    private GameController() {
        processing();
    }

    public static GameController gameStart() {
        return new GameController();
    }

    private void processing() {
        boolean isCorrect;
        do {
            messenger.printStart();
            String input = Console.readLine();
            user = new User(input);
            Map<String, Integer> gameScore = referee.judgeNumberBetween(computer, user);
            messenger.printResult(gameScore);
            isCorrect = referee.isCorrect(gameScore);
        } while (!isCorrect);
        messenger.printSuccessEnd();
        confirmTryAgain();
    }

    private void confirmTryAgain() {
        messenger.printRetry();
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);
        if (inputNumber == 1) {
            gameStart();
        }
        if (inputNumber == 2) {
            System.exit(0);
        }
    }

}
