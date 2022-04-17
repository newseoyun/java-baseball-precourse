package baseball.model;

import java.util.List;

public class User {

    private final List<Integer> baseballNumbers;

    public User(List<Integer> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }
}
