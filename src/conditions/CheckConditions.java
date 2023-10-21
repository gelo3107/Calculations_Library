package conditions;

import motor.Motor;

/* Check if condition parameters are correct */
class CheckConditions {

    protected static boolean motorLoadValueIsCorrect(double motorLoad) {
        return  motorLoad > 0 && motorLoad <=1 ;
    }
    protected static boolean workingHoursPerYearValueIsCorrect(int workingHoursPerYear) {
        return workingHoursPerYear > 0 && workingHoursPerYear <= 8760;
    }
    protected static boolean motorLifecycleYearsIsCorrect(int motorLifecycleYears) {
        return motorLifecycleYears > 0;
    }
    protected static boolean currencyIsCorrect(String currency) {
        return currency.length() > 0 && currency.length() < 4;
    }
    protected static boolean electricityCostIsCorrect(double elecrtricityCost) {
        return elecrtricityCost > 0;
    }
    protected static boolean newMotorEfficiencyIsLess(Motor installedMotor, Motor newMotor) {
        return newMotor.getEfficiency() < installedMotor.getEfficiency();
    }
}
