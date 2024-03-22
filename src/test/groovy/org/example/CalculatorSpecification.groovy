package org.example

import spock.lang.Specification

class CalculatorSpecification extends Specification {

    def "add(1, 2) should equal 3"() {
        given: "Prep two variables: 1, 2"
            def calc = new Calculator()
            def one = 1
            def two = 2
        when: "Trying to add two variables..."
            def result = calc.add(one, two)
        then: "The result should be 3"
            result.toDouble() == 3.0
    }

    def "sub(3, 4) should equal -1"() {
        given: "Prep two variables: 3, 4"
            def calc = new Calculator()
            def three = 3
            def four = 4
        when: "Trying to subtract two variables..."
            def result = calc.sub(3, 4)
        then: "The result should be -1"
            result.toDouble() == -1.0
    }

    def "performing multiplication tests"(double a, double b, double c) {
        given: "Prepping necessary stuff"
            def calc = new Calculator()
        when: "Performing multiplication..."
            def result = calc.mul(a, b)
        then: "Expecting result"
            result.toDouble() == c
        where:
            a   | b     | c
            1.0 | 2.0   | 2.0
            3.0 | 2.0   | 6.0
            0.0 | 13.7  | 0.0
    }

    def "div(2, 0) should throw IllegalArgumentException"() {
        given:
            def calc = new Calculator()
            def two = 2
            def zero = 0
        when:
            def result = calc.div(2, 0)
        then:
            thrown(IllegalArgumentException)
    }

    def "performing division tests"(double a, double b, double c) {
        given: "Prepping necessary stuff"
            def calc = new Calculator()
        when: "Performing division..."
            def result = calc.div(a, b)
        then: "Expecting result..."
            result.toDouble() == c
        where:
            a   | b     | c
            2   | 1     | 2
            4   | 2     | 2
            15  | 5     | 3

    }
}
