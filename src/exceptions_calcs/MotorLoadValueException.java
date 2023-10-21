package exceptions_calcs;

/**
 * Exception class for motorLoad parameter
 */
public class MotorLoadValueException  extends  Exception{

    private final double motorLoadException;

    /**
     * The class constructor
     */
    public MotorLoadValueException( double motorLoadException) {
        this.motorLoadException = motorLoadException;
    }

    /**
     * String message in case of exception
     */
    public String toString() {
        return "Incorrect motor load value: " + motorLoadException;
    }
}