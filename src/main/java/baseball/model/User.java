package baseball.model;

import baseball.constant.RuleNumber;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> baseballNumbers = new ArrayList<>();

    public User(String input) {
        setBaseballNumbers(input);
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }

    private void setBaseballNumbers(String input) {
        validateTotalSize(input);
        validateDuplication(input);
        String[] splitInput = input.split("");
        for (String s : splitInput) {
            Integer number = convertToInteger(s);
            validateNumberRange(number);
            baseballNumbers.add(number);
        }
    }

    private void validateTotalSize(String input) {
        if (input.length() < RuleNumber.MAX) {
            throw new IllegalArgumentException("숫자가 부족합니다. 세자리여야합니다.");
        }
        if (input.length() > RuleNumber.MAX) {
            throw new IllegalArgumentException("숫자가 너무 많습니다. 세자리여야합니다.");
        }
    }

    private void validateDuplication(String input) {
        String[] splitInput = input.split("");
        if (splitInput[0].equals(splitInput[1])
                || splitInput[0].equals(splitInput[2])
                || splitInput[1].equals(splitInput[2])
        ) {
            throw new IllegalArgumentException("숫자는 중복되지 않아야합니다.");
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < RuleNumber.RANGE_START || number > RuleNumber.RANGE_END) {
            throw new IllegalArgumentException("1에서 9 사이의 값이어야합니다.");
        }
    }

    private Integer convertToInteger(String input) {
        Integer number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        return number;
    }

    @Override
    public String toString() {
        return "User{" +
                "baseballNumbers=" + baseballNumbers +
                '}';
    }
}
