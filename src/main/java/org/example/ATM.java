package org.example;

public class ATM implements ATMInterface {

    public double balance;
    public double pin;

    @Override
    public double checkBalance(int pin) throws InvalidPinException {
        if(checkIfPinIsCorrect(pin)) return this.balance;
        throw new InvalidPinException("Provided PIN doesn't match registered PIN.");
    }

    @Override
    public double deposit(int pin, double amount) throws InvalidPinException {
        if(!checkIfPinIsCorrect(pin)) throw new InvalidPinException("Provided PIN doesn't match registered PIN.");
        this.balance += amount;
        return this.balance;
    }

    @Override
    public double withdraw(int pin, double amount) throws InsufficientFundsException, InvalidPinException {
        if(!checkIfPinIsCorrect(pin)) throw new InvalidPinException("Provided PIN doesn't match registered PIN");
        if(this.balance < amount) throw new InsufficientFundsException("Can't withdraw money because this account doesn't have necessary funds.");
        this.balance -= amount;
        return this.balance;
    }

    private boolean checkIfPinIsCorrect(int pin) {
        return this.pin == pin;
    }
}
