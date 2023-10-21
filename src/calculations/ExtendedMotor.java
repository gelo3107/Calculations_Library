package calculations;

import conditions.*;
import exceptions.*;
import efficiency.EffClass;
import exceptions_calcs.MotorPriceValueException;
import motor.Motor;

/**
 * The class is aimed to extend the {@code Motor} class from motlib library adding there two additional
 * parameters: conditions - the instance of {@code Conditions} class and {@code double} motor price.
 *
 * Additional outcome parameters are: motor annual energy consumption, motor annual money consumption,
 * motor lifecycle energy consumption, motor lifecycle money consumption - are used in the following
 * calculations in the instance of the {@code Calculations} class.
 */
public class ExtendedMotor extends Motor {

    /* Income parameters */
    private final double motorPrice;
    private Conditions conditions;

    /* Outcome parameters */
    private double motorAnnualEnergyConsumption,    motorAnnualMoneyConsumption,
                   motorLifeCycleEnergyConsumption, motorLifeCycleMoneyConsumption;

    /**
     * The constructor creates ExtendedMotor instance with Motor class parameters and additional external parameter.
     * After all internal parameters setting method {@code setParameters()} invokes to set outcome parameters
     * @param power power value set up
     * @param poles poles value set up
     * @param efficiency efficiency value set up
     * @param motorPrice motor price set up
     * @param conditions {@code Condition} class instance which is used for outcome parameters calculation
     * @throws PowerValueException      if try to set up incorrect power value
     * @throws PolesValueException      if try to set up incorrect poles value
     * @throws EfficiencyValueException if try to set up incorrect efficiency value
     * @throws MotorPriceValueException if try to set up incorrect motor price value
     */
    public ExtendedMotor(double power, int poles, double efficiency, double motorPrice, Conditions conditions)
            throws PowerValueException, PolesValueException, EfficiencyValueException, MotorPriceValueException {
        super(power, poles, efficiency);
        if (motorPrice != 0)
            if(!CheckMotorPrice.motorPriceIsCorrect(motorPrice))
                throw new MotorPriceValueException(motorPrice);
        this.motorPrice = motorPrice;
        setParameters(conditions);
    }

    /**
     * The constructor creates ExtendedMotor instance from existed one. It makes easier to create the motor with
     * similar power and poles but another efficiency class. Motor efficiency sets as a minimal efficiency for
     * provided efficiency class. Method {@code setParameters()} invokes to set outcome parameters.
     * @param motor class {@code Motor} or inheritance classes instance to copy power and poles parameters
     * @param effClass class {@code EffClass} value for motor efficiency set
     * @param motorPrice motor price set up
     * @param conditions {@code Condition} class instance which is used for outcome parameters calculation
     * @throws PowerValueException      if try to set up incorrect power value
     * @throws PolesValueException      if try to set up incorrect poles value
     * @throws MotorPriceValueException if try to set up incorrect motor price value
     */
    public ExtendedMotor(Motor motor, EffClass effClass, double motorPrice, Conditions conditions)
            throws PowerValueException, PolesValueException, MotorPriceValueException {
        super(motor.getPower(), motor.getPoles(), effClass);
        if (motorPrice != 0)
            if(!CheckMotorPrice.motorPriceIsCorrect(motorPrice))
                throw new MotorPriceValueException(motorPrice);
        this.motorPrice = motorPrice;
        setParameters(conditions);
    }

    /* Set all parameters. Method is invoked from constructors */
    private void setParameters (Conditions conditions) {
        this.conditions = conditions;
        setMotorAnnualEnergyConsumption();
        setMotorAnnualMoneyConsumption();
        setMotorLifeCycleMoneyConsumption();
        setMotorLifeCycleEnergyConsumption();
    }

    private void setMotorAnnualEnergyConsumption() {
        this.motorAnnualEnergyConsumption = (this.getPower() / (this.getEfficiency() / 100)) *
                conditions.getMotorLoad() * conditions.getWorkingHoursPerYear();
    }
    private void setMotorAnnualMoneyConsumption() {
        this.motorAnnualMoneyConsumption = this.motorAnnualEnergyConsumption *
                conditions.getElectricityCost();
    }
    private void setMotorLifeCycleEnergyConsumption() {
        this.motorLifeCycleEnergyConsumption = this.motorAnnualEnergyConsumption *
                conditions.getMotorLifecycleYears();
    }
    private void setMotorLifeCycleMoneyConsumption() {
        this.motorLifeCycleMoneyConsumption = this.motorAnnualMoneyConsumption *
                conditions.getMotorLifecycleYears();
    }

    /**
     * Get motor annual energy consumption value
     */
    public double getMotorAnnualEnergyConsumption() {
        return motorAnnualEnergyConsumption;
    }
    /**
     * Get motor annual money consumption value
     */
    public double getMotorAnnualMoneyConsumption() {
        return motorAnnualMoneyConsumption;
    }
    /**
     * Get motor annual energy consumption value
     */
    public double getMotorLifeCycleEnergyConsumption() {
        return motorLifeCycleEnergyConsumption;
    }
    /**
     * Get motor lifecycle energy consumption value
     */
    public double getMotorLifeCycleMoneyConsumption() {
        return motorLifeCycleMoneyConsumption;
    }
    /**
     * Get motor lifecycle money consumption value
     */
    public double getMotorPrice() {
        return motorPrice;
    }
}