package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("컴퓨터는 서로 다른 세자리의 수를 가져야 한다")
    @Test
    void generateComputer() {
        Computer computer = new Computer();
        List<Integer> baseballNumbers = computer.getBaseballNumbers();

        System.out.println("baseballNumbers = " + baseballNumbers);
        assertThat(baseballNumbers).containsOnlyOnce(baseballNumbers.get(0), baseballNumbers.get(1));
    }
}