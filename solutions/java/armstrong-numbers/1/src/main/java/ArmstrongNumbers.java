import java.util.ArrayList;
import java.util.List;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        int num = numberToCheck;
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            int digit = num % 10;
            list.add(digit);
            num /= 10;
        }

        int sum = list.stream().reduce(0, (acc, value) -> acc + Math.powExact(value, list.size()));

        return sum == numberToCheck;
    }

}
