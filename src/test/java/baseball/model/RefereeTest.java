package baseball.model;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    Referee referee = new Referee();

    @DisplayName("두 숫자 리스트가 같으면 true를 반환한다")
    @Test
    void isCorrectNumber() {
        Computer computer = new Computer();
        String numbers = "";
        List<Integer> player1Numbers = computer.getBaseballNumbers();
        for (Integer player1Number : player1Numbers) {
            numbers += String.valueOf(player1Number);
        }
        User user = new User(numbers);

        Map<String, Integer> gameScore = referee.judgeNumberBetween(computer, user);
        boolean isCorrectNumber = referee.isCorrect(gameScore);

        Assertions.assertThat(isCorrectNumber).isTrue();
    }

}
