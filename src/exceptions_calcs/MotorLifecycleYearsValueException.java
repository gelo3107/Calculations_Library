package exceptions_calcs;

/**
 * Exception class for motorLifecycleYears parameter
 */
public class MotorLifecycleYearsValueException extends Exception {

    private final double motorLifecycleYearsException;

    /**
     * The class constructor
     */
    public MotorLifecycleYearsValueException (double motorLifecycleYears) {
        this.motorLifecycleYearsException = motorLifecycleYears;
    }

    /**
     * String message in case of exception
     */
    public String toString() {
        return "Incorrect motor load value: " + motorLifecycleYearsException;
    }
}