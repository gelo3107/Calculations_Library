package reports;

import calculations.Calculation;
import conditions.Conditions;

/**
 * The class creates the report of the energy calculations and payback period as a String field.
 * The methods are public to redefine in case if it is required.
 */
public class Report {

    String report;

    /**
     * The {@code Report} class instance constructor.
     * @param calculation set the {@code Calculation} class instance
     * @param conditions set the {@code Conditions} class instance
     */
    public Report(Conditions conditions, Calculation calculation) {
        setReport(conditions, calculation);
    }

    /**
     * Set report, select text depending on payback value
     */
    public void setReport(Conditions conditions, Calculation calculation) {
        if (calculation.getNewMotorPayBackPeriod()<= 0)
            report = Reports.negativePayBackPeriod();
        else if (calculation.getNewMotorPayBackPeriod()> 0 && calculation.getNewMotorPayBackPeriod()<=3)
            report = Reports.payBackPeriodLess3Years(conditions, calculation);
        else if (calculation.getNewMotorPayBackPeriod()>3 && calculation.getNewMotorPayBackPeriod()<=7)
            report = Reports.payBackPeriodLess7Years(conditions, calculation);
        else if (calculation.getNewMotorPayBackPeriod()>7 && calculation.getNewMotorPayBackPeriod()<=15)
            report = Reports.payBackPeriodLess15Years(conditions, calculation);
        else report = Reports.payBackPeriodOver15Years(conditions,calculation);
    }

    /**
     * Get report
     */
    public String getReport() {
        return report;
    }
}