package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class StringTest {

    @Order(1)
    @Test
    void 콤마로_구분된_문자를_split() {
        String oneTwo = "1,2";

        String[] oneTwoArray = oneTwo.split(",");

        assertThat(oneTwoArray).contains("1", "2");
    }

    @Order(1)
    @Test
    void 구분값이_없는_하나의_문자를_split() {
        String one = "1";

        String[] oneCommaArray = one.split(",");

        assertThat(oneCommaArray).containsExactly("1");
    }

    @Order(2)
    @Test
    void 문자의_괄호_제거() {
        String target = "(1,2)";

        String substringTarget = target.substring(1, target.length() - 1);

        assertThat(substringTarget).isEqualTo("1,2");
    }

    @Order(3)
    @DisplayName("문자열 범위를 넘은 charAt() 실행 시의 예외 발생 확인")
    @Test
    void getCharAt() {
        String target = "abc";
        int outOfRangeForTarget = target.length();

        assertThatThrownBy(() -> target.charAt(outOfRangeForTarget))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("index out of range: %d", outOfRangeForTarget));

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> target.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }

}
