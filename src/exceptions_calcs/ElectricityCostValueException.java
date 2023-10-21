package exceptions_calcs;

/**
 * Exception class for electricityCost parameter
 */
public class ElectricityCostValueException extends Exception{

    private final double electricityCostException;

    /**
     * The class constructor
     */
    public ElectricityCostValueException (double electricityCost) {
        this.electricityCostException = electricityCost;
    }

    /**
     * String message in case of exception
     */
    public String toString() {
        return "Incorrect electricity cost value: " + electricityCostException;
    }
}