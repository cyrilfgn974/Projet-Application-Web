package entities;

public class Money {
    private long value;
    private String currency;

    public Money(long unnormValue, String currency) {
        this.value = unnormValue;
        this.currency = currency;
    }

    public Money(double value, String currency) {
        this.value = Math.round(value * 100.0);
        this.currency = currency;
    }

    public Money(long intPart, int cents, String currency) {
        this.value = intPart + 100 * cents;
        this.currency = currency;
    }

    public double getValue() {
        return value / 100.0;
    }

    public long getUnnormalizedValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}