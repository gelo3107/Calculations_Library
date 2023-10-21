package exceptions_calcs;

/**
 * Exception class for workingHoursPerYear parameter
 */
public class WorkingHoursPerYearValueException extends Exception {

    private final double workingHoursPerYearException;

    /**
     * The class constructor
     */
    public WorkingHoursPerYearValueException( double workingHoursPerYearException) {
        this.workingHoursPerYearException = workingHoursPerYearException;
    }

    /**
     * String message in case of exception
     */
    public String toString() {
        return "Incorrect motor working hours per year value: " + workingHoursPerYearException;
    }
}