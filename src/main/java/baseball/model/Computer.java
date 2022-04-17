package baseball.model;

import baseball.constant.RuleNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> baseballNumbers = new ArrayList<>();

    public Computer() {
        generateBaseballNumbers();
    }

    private void generateBaseballNumbers() {
        baseballNumbers = Randoms.pickUniqueNumbersInRange(
                RuleNumber.RANGE_START,
                RuleNumber.RANGE_END,
                RuleNumber.MAX);
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "baseballNumbers=" + baseballNumbers +
                '}';
    }
}
