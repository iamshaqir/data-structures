package utility;

import org.junit.jupiter.api.Test;

public class Utils {

    @Test
    void test() {
        String numberAsString = "1548523";
        int parsedNumber = parseNumber(numberAsString);

        int number = 1254753;
        divideNumber(number);
    }

    int parseNumber(String number) {
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            char charAt = number.charAt(i);
            int digit = charAt - '0';
            result = result * 10 + digit;
        }
        System.out.println("Number: " + result);
        return result;
    }

    /**
     * The modulo operator (%) gives you the last digit of a number.
     * For example, 123 % 10 equals 3.
     * <p>
     * Integer division (/) removes the last digit of a number.
     * For example, 123 / 10 equals 12.
     *
     * @param number input number
     */
    void divideNumber(int number) {
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            System.out.println("Digit: " + digit);
        }
    }
}
