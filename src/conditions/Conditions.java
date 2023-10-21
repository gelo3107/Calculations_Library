package conditions;

import exceptions_calcs.*;

/**
 * The class {@code Conditions} is aimed to validate conditions of the motor working as well as
 * calculation parameters ie: motor load, working hours per year, motor lifecycle in years, electricity
 * cost and currency. Each parameter has a limits which is described by exception.
 *
 * <p> The class does not have public setters to avoid misleading in case of conditions parameters
 * changing but recalculation of the payback time was not done. Therefore, the new instance should be
 * created if parameters are changed.
 */
public class Conditions {

    private double motorLoad;
    private  int workingHoursPerYear;
    private  int motorLifecycleYears;
    private double electricityCost;
    private  String currency;

    /**
     * The constructor of the {@code Conditions} class. Creates the instance of the conditions
     * which is using in the further calculations.
     * @param motorLoad set motor load value
     * @param workingHoursPerYear set motor working hours per year value
     * @param motorLifecycleYears set motor life cycle in years value
     * @param electricityCost set electricity cost value
     * @param currency set currency
     * @throws MotorLoadValueException if motorLoad is out of range (0...1]
     * @throws WorkingHoursPerYearValueException if workingHoursPerYear value is out of the range (0...8760]
     * @throws MotorLifecycleYearsValueException if motorLifecycleYears value is out of range (0...+inf)
     * @throws ElectricityCostValueException if electricityCost value is out of range (0...+inf)
     * @throws CurrencyException if length of the currency value is out of the range [1...3]
     */
    public Conditions(double motorLoad, int workingHoursPerYear, int motorLifecycleYears,
                      double electricityCost, String currency)
            throws MotorLoadValueException, WorkingHoursPerYearValueException, MotorLifecycleYearsValueException,
                   CurrencyException, ElectricityCostValueException {

        setMotorLoad(motorLoad);
        setWorkingHoursPerYear(workingHoursPerYear);
        setMotorLifecycleYears(motorLifecycleYears);
        setElectricityCost(electricityCost);
        setCurrency(currency);
    }

    /* Private setters */
    private void setMotorLoad(double motorLoad) throws MotorLoadValueException {
        if (!CheckConditions.motorLoadValueIsCorrect(motorLoad))
            throw new MotorLoadValueException(motorLoad);
        this.motorLoad = motorLoad;
    }
    private void setWorkingHoursPerYear(int workingHoursPerYear) throws WorkingHoursPerYearValueException {
        if (!CheckConditions.workingHoursPerYearValueIsCorrect(workingHoursPerYear))
            throw new WorkingHoursPerYearValueException(workingHoursPerYear);
        this.workingHoursPerYear = workingHoursPerYear;
    }
    private void setMotorLifecycleYears(int motorLifecycleYears) throws MotorLifecycleYearsValueException {
        if (!CheckConditions.motorLifecycleYearsIsCorrect(motorLifecycleYears))
            throw new MotorLifecycleYearsValueException(motorLifecycleYears);
        this.motorLifecycleYears = motorLifecycleYears;
    }
    private void setElectricityCost(double electricityCost) throws ElectricityCostValueException {
        if (!CheckConditions.electricityCostIsCorrect(electricityCost))
            throw new ElectricityCostValueException(electricityCost);
        this.electricityCost = electricityCost;
    }
    private void setCurrency(String currency) throws CurrencyException {
        if(!CheckConditions.currencyIsCorrect(currency)) throw new CurrencyException(currency);
        this.currency = currency;
    }

    /**
     * Get motor load value
     */
    public double getMotorLoad() {
        return motorLoad;
    }
    /**
     * Get working hours per year value
     */
    public int getWorkingHoursPerYear() {
        return workingHoursPerYear;
    }
    /**
     * Get motor lifecycle years value
     */
    public int getMotorLifecycleYears() {
        return motorLifecycleYears;
    }
    /**
     * Get electricity cost value
     */
    public double getElectricityCost() {
        return electricityCost;
    }
    /**
     * Get currency value
     */
    public String getCurrency() {
        return currency;
    }
}
