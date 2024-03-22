package org.example

import spock.lang.Specification

class ATMSpecification extends Specification {

    def "checkBalance(1234) should fetch 32.0"() {
        given:
            def atm = new ATM()
            atm.balance = 32.0
            atm.pin = 1234
            def testPin = 1234
        when:
            def result = atm.checkBalance(testPin)
        then:
            result.toDouble() == 32.0;
    }
    def "checkBalance(2345) should throw InvalidPinException"() {
        given:
            def atm = new ATM()
            atm.balance = 32.0
            atm.pin = 1234
            def testPin = 2345
        when:
            def result = atm.checkBalance(testPin)
        then:
            thrown(InvalidPinException)
    }

    def "deposit(1234, 40) should return 72"() {
        given:
            def atm = new ATM()
            atm.balance = 32.0
            atm.pin = 1234
            def testPin = 1234
            def amount = 40
        when:
            def result = atm.deposit(testPin, amount)
        then:
            result.toDouble() == 72.0
    }

    def "deposit(2345, 40) should throw InvalidPinException"() {
        given:
            def atm = new ATM()
            atm.balance = 32.0
            atm.pin = 1234
            def testPin = 2345
            def amount = 40
        when:
            def result = atm.deposit(testPin, amount)
        then:
            thrown(InvalidPinException)
    }

    def "withdraw(1234, 20) should return 12"() {
        given:
            def atm = new ATM()
            atm.balance = 32.0
            atm.pin = 1234
            def testPin = 1234
            def amount = 20
        when:
            def result = atm.withdraw(testPin, amount)
        then:
            result.toDouble() == 12.0
    }

    def "withdraw(2345, 20) should throw InvalidPinException"() {
        given:
            def atm = new ATM()
            atm.balance = 32.0
            atm.pin = 1234
            def testPin = 2345
            def amount = 20
        when:
            def result = atm.withdraw(testPin, amount)
        then:
            thrown(InvalidPinException)
    }

    def "withdraw(1234, 20) should throw InsufficientFundsException"() {
        given:
            def atm = new ATM()
            atm.balance = 32.0
            atm.pin = 1234
            def testPin = 1234
            def amount = 40
        when:
            def result = atm.withdraw(testPin, amount)
        then:
            thrown(InsufficientFundsException)
    }
}
