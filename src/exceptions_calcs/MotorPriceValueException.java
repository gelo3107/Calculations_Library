package exceptions_calcs;

/**
 * Exception class for motorPrice parameter
 */
public class MotorPriceValueException extends Exception {

    private final double priceValueException;

    /**
     * The class constructor
     */
    public MotorPriceValueException( double priceValueException) {
        this.priceValueException = priceValueException;
    }

    /**
     * String message in case of exception
     */
    public String toString() {
        return "Incorrect motor price: " + priceValueException;
    }
}