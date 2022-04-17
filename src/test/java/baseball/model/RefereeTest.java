package baseball.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    Referee referee = new Referee();

    @DisplayName("두 숫자 리스트가 같으면 true를 반환한다")
    @Test
    void isCorrectNumber() {
        Computer computer = new Computer();
        List<Integer> player1Numbers = computer.getBaseballNumbers();
        List<Integer> player2Numbers = player1Numbers;

        boolean isCorrectNumber = referee.isCorrectNumber(player1Numbers, player2Numbers);

        Assertions.assertThat(isCorrectNumber).isTrue();
    }

}
