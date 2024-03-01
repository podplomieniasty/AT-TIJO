public class UnitTests {

    public static void main(String[] args) {

        MathOpsTests.testIsPrimeWithNull();
        MathOpsTests.testIsPrimeWithNegativeValue();
        MathOpsTests.testIsPrimeWith0();
        MathOpsTests.testIsPrimeWith1();
        MathOpsTests.testIsPrimeWith2();
        MathOpsTests.testIsPrimeWith13();
        MathOpsTests.testIsPrimeWith97();
    }
}

class MathOps {

    static Boolean isPrime(Integer digit) {
        if(digit == null) return null;
        else if(digit < 2) return false;

        // zgadza się, ukradłem, ale tylko głupi by nie skorzystał
        // trzeba było pilnować
        for (int i = 2; i < digit; i++)
            if (digit % i == 0)
                return false;
        return true;
    }
}

class MathOpsTests {

    static void testIsPrimeWithNull() {

        Integer digit = null;
        Boolean result = MathOps.isPrime(digit);
        assert result == null : "isPrime(null) should be null";
    }

    static void testIsPrimeWithNegativeValue() {

        Integer digit = -10;
        Boolean result = MathOps.isPrime(digit);
        assert !result : "isPrime(-10) should return false";
    }

    static void testIsPrimeWith0() {

        Integer digit = 0;
        Boolean result = MathOps.isPrime(digit);
        assert !result : "isPrime(0) should return false";
    }

    static void testIsPrimeWith1() {

        Integer digit = 1;
        Boolean result = MathOps.isPrime(digit);
        assert !result : "isPrime(1) should return false";
    }

    static void testIsPrimeWith2() {

        Integer digit = 2;
        Boolean result = MathOps.isPrime(digit);
        assert result : "isPrime(2) should return true";
    }

    static void testIsPrimeWith13() {

        Integer digit = 13;
        Boolean result = MathOps.isPrime(digit);
        assert result : "isPrime(2) should return true";
    }

    static void testIsPrimeWith97() {

        Integer digit = 97;
        Boolean result = MathOps.isPrime(digit);
        assert result : "isPrime(2) should return true";
    }
}