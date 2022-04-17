package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @DisplayName("유저 생성 시 input 숫자가 잘못됐을 경우 예외가 발생해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12", "223", "1234", "012", "12a", "hey"})
    void generateUser(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new User(input));
    }
}