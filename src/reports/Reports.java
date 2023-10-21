package reports;

import calculations.*;
import conditions.Conditions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/**
 * The class define the text for the report. There are several methods which
 * set the text depending on various payback periods. Class contains only open
 * static methods to redefine them in case if it is required.
 */
public class Reports {

    /**
     * Create the report if {@code payBackPeriod} is negative
     */
    public static String negativePayBackPeriod() {
        return getAdvise("negativeRespond.txt");
    }

    /**
     * Create the report if {@code payBackPeriod} is in range (0 ... 3] years
     */
    public static String payBackPeriodLess3Years(Conditions conditions, Calculation calculation) {
        return generalAnswer(conditions, calculation) +
               getAdvise("payBackPeriodLess3Years.txt");
    }

    /**
     * Create the report if {@code payBackPeriod} is in range (3 ... 7] years
     */
    public static String payBackPeriodLess7Years(Conditions conditions, Calculation calculation) {
        return generalAnswer(conditions, calculation) +
               getAdvise("payBackPeriodLess7Years.txt");
    }

    /**
     * Create the report if {@code payBackPeriod} is in range (7 ... 15] years
     */
    public static String payBackPeriodLess15Years(Conditions conditions, Calculation calculation) {
        return generalAnswer(conditions, calculation) +
               getAdvise("payBackPeriodLess15Years.txt");
    }

    /**
     * Create the report if {@code payBackPeriod} is over 15 years
     */
    public static String payBackPeriodOver15Years(Conditions conditions, Calculation calculation) {
        return generalAnswer(conditions, calculation) +
               getAdvise("payBackPeriodOver15Years.txt");
    }

    /**
     * Method which generates calculations report
     */
    public static String generalAnswer(Conditions conditions, Calculation calculation) {
        return String.format(Locale.US,
     "========== %n" +
            "Preliminary conditions: %n" +
            "     Annual working hours:   %d %n" +
            "     Motor lifecycle:        %d %n" +
            "     Load:                   %.2f %n" +
            "     kWh cost:               %.3f %s %n" +
            "     Old motor eff. class:   %s (eff. %.2f)%n" +
            "     New motor eff. class:   %s (eff. %.2f)%n" +
            "     Old motor price:        %.0f %s %n" +
            "     New motor price:        %.0f %s %n" +
            "========== %n" +
            "Calculations: %n" +
            "     Installed motor annual energy consumption:      %,10.0f kWh %n" +
            "     Installed motor lifecycle energy consumption:   %,10.0f kWh %n%n" +
            "     Efficient motor annual energy consumption:      %,10.0f kWh %n" +
            "     Efficient motor lifecycle energy consumption:   %,10.0f kWh %n" +
            "     Payback period:                                 %10.1f years %n%n" +
            "     Saved money for motor lifecycle:                %,10.0f %s %n" +
            "     Saved energy for motor lifecycle:               %,10.0f kWh %n"

            ,conditions.getWorkingHoursPerYear(),
            conditions.getMotorLifecycleYears(),
            conditions.getMotorLoad(),
            conditions.getElectricityCost(),conditions.getCurrency(),

            calculation.getInstalledMotor().getEffClass(), calculation.getInstalledMotor().getEfficiency(),
            calculation.getNewMotor().getEffClass(), calculation.getNewMotor().getEfficiency(),
            calculation.getInstalledMotor().getMotorPrice(),conditions.getCurrency(),
            calculation.getNewMotor().getMotorPrice(),conditions.getCurrency(),

            calculation.getInstalledMotor().getMotorAnnualEnergyConsumption(),
            calculation.getInstalledMotor().getMotorLifeCycleEnergyConsumption(),
            calculation.getNewMotor().getMotorAnnualEnergyConsumption(),
            calculation.getNewMotor().getMotorLifeCycleEnergyConsumption(),

            calculation.getNewMotorPayBackPeriod(),
            calculation.getSavedMoney(),conditions.getCurrency(),
            calculation.getLifeCycleConsumedEnergyDifference()
        );
    }

    /* Read advice information from the file*/
    private static String getAdvise(String fileName) {

        File file = new File(fileName);
        StringBuilder advice = new StringBuilder();
        String string= "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            while ((string = bufferedReader.readLine()) != null)
                advice.append(string).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return advice.toString();
    }
}