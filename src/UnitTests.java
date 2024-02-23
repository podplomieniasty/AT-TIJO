import java.util.Objects;

public class UnitTests {

    public static void main(String[] args) {
        //assert(add(1, 2) == 3): "add(1, 2) should return 3.";
        //assert(max(null) == null): "Test: max(null) of null should return null.";
        //assert(max(new Integer[]{}) == null): "Test: max([]) with empty array should return null.";
        //assert(max(new Integer[]{10}) == 10): "Test: max([10]) should return 10.";
        //assert(max(new Integer[]{2, 8, 5, 10, 11, -4}) == 11): "Test: max([2, 8, 5, 10, 11, -4]) should return 11.";

        new ArrayOpsTests().testMaxWithNull();
        new ArrayOpsTests().testMaxWithEmptyArray();
        new ArrayOpsTests().testMaxWithArrayWithSingleValue();
        new ArrayOpsTests().testMaxWithArrayWithManyValues();

        new ArrayOpsTests().testIsPerfectWithNull();
        new ArrayOpsTests().testIsPerfectWithNegativeValue();
        new ArrayOpsTests().testIsPerfectWithOddValue();
        new ArrayOpsTests().testIsPerfectWithNonPerfectValue();
        new ArrayOpsTests().testIsPerfectWithBiggerNonPerfectValue();
        new ArrayOpsTests().testIsPerfectWithPerfectValue();
        new ArrayOpsTests().testIsPerfectWithBiggerPerfectValue();
    }

}

class ArrayOps {

    static Integer max(Integer[] digits) {
        if(Objects.isNull(digits)) return null;
        if(digits.length == 0) return null;
        Integer val = digits[0];
        for(Integer digit : digits) {
            if(digit > val) val = digit;
        }
        return val;
    }

    static Boolean isPerfect(Integer digit) {
        if(digit == null)       return null;
        else if(digit < 1)      return false;
        else if(digit % 2 == 1) return false;

        Integer sum = 1;
        double sq = Math.sqrt(digit);
        for(int i = 2; i <= sq; i++)
            if(digit % i == 0)
                sum += i + digit/i;
        if(digit == sq * sq) sum -= (int)sq;
        if(digit.equals(sum)) return true;
        return false;
    }
}

class ArrayOpsTests {

    void testMaxWithNull() {
        // Given
        Integer[] testArray = null;
        // When
        Integer result = ArrayOps.max(testArray);
        // Then
        assert result == null : "max(null) should return null.";
    }

    void testMaxWithEmptyArray() {
        // Given
        Integer[] testArray = {};
        // When
        Integer result = ArrayOps.max(testArray);
        // Then
        assert result == null : "max([]) should return null.";
    }

    void testMaxWithArrayWithSingleValue() {
        // Given
        Integer[] testArray = {10};
        // When
        Integer result = ArrayOps.max(new Integer[]{10});
        // Then
        assert result == 10 : "max([10]) should return 10.";
    }

    void testMaxWithArrayWithManyValues() {
        // Given
        Integer[] testArray = {2, 8, 5, 10, 11, -4};
        // When
        Integer result = ArrayOps.max(new Integer[]{2, 8, 5, 10, 11, -4});
        // Then
        assert result == 11 : "max([2, 8, 5, 10, 11, -4]) should return 11.";
    }

    void testIsPerfectWithNull() {
        Integer digit = null;
        Boolean result = ArrayOps.isPerfect(digit);
        assert result == null : "isPerfect(null) should return null.";
    }

    void testIsPerfectWithNegativeValue() {
        Integer digit = -5;
        Boolean result = ArrayOps.isPerfect(digit);
        assert !result : "isPerfect(-5) should return false.";
    }

    void testIsPerfectWithOddValue() {
        Integer digit = 5;
        Boolean result = ArrayOps.isPerfect(digit);
        assert !result : "isPerfect(5) should return false.";
    }

    void testIsPerfectWithNonPerfectValue() {
        Integer digit = 8;
        Boolean result = ArrayOps.isPerfect(digit);
        assert !result : "isPerfect(8) should return false.";
    }

    void testIsPerfectWithBiggerNonPerfectValue() {
        Integer digit = 8126;
        Boolean result = ArrayOps.isPerfect(digit);
        assert !result : "isPerfect(8126) should return false.";
    }

    void testIsPerfectWithPerfectValue() {
        Integer digit = 6;
        Boolean result = ArrayOps.isPerfect(digit);
        assert result : "isPerfect(6) should return true.";
    }

    void testIsPerfectWithBiggerPerfectValue() {
        Integer digit = 8128;
        Boolean result = ArrayOps.isPerfect(digit);
        assert result : "isPerfect(8128) should return true.";
    }
}
