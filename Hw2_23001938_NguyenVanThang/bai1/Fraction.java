package Hw2_23001938_NguyenVanThang.bai1;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public float getNumerator() {
        return numerator;
    }

    public void setNumerator(float numerator) {
        this.numerator = numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setDenominator(float denominator) {
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        float newNumerator = (this.numerator * c.denominator) + (c.numerator * this.denominator);
        float newDenominator = (this.denominator * c.denominator);
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return normalize(newFraction);
    }

    public Fraction minus(Fraction c) {
        float newNumerator = (this.numerator * c.denominator) - (c.numerator * this.denominator);
        float newDenominator = (this.denominator * c.denominator);
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return normalize(newFraction);
    }

    public Fraction multi(Fraction c) {
        float newNumerator = (this.numerator * c.numerator);
        float newDenominator = (this.denominator * c.denominator);
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return normalize(newFraction);
    }

    public Fraction divi(Fraction c) {
        float newNumerator = (this.numerator * c.denominator);
        float newDenominator = (c.numerator * this.denominator);
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return normalize(newFraction);
    }

    // Hàm rút gọn phân số
    public Fraction normalize(Fraction c) {
        float minIndex = Math.min(Math.abs(c.numerator), Math.abs(c.denominator));
        int temp = 1;
        for (int i = 2; i <= minIndex; i++) {
            if ( (c.numerator % i == 0) && (c.denominator % i == 0)) {
                temp = i;
            }
        }
        float newNumerator = c.numerator / temp;
        float newDenominator = c.denominator / temp;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    public String printFraction() {
        if (denominator == 0) {
            throw new ArithmeticException();
        }
        if (numerator == 0) {
            return "0";
        }
        if (denominator < 0 || (denominator < 0 && numerator < 0)) {
            denominator = -denominator;
            numerator = -numerator;
        }
        if (Math.abs(denominator) == 1) {
            return String.valueOf(this.numerator);
        }
        return numerator + "/" + denominator;
    }

    @Override
    public String toString() {
        return printFraction();
    }
}
