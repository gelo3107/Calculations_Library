package exceptions_calcs;

/**
 * Exception class for currency parameter
 */
public class CurrencyException extends Exception {

    private final String currencyException;

    /**
     * The class constructor
     */
    public CurrencyException (String currencyException) {
        this.currencyException = currencyException;
    }

    /**
     * String message in case of exception
     */
    public String toString() {
        return "Incorrect currency setup (currency must contain from 1 to 3 symbols): " + currencyException;
    }
}