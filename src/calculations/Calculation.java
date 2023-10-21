package calculations;

/**
 * The class gets two instances of the {@code ExtendedMotor} class: installed motor and new motor (with higher)
 * efficiency and calculates payback period and other data.
 */
public class Calculation {

    /* Input parameters */
    private final ExtendedMotor installedMotor, newMotor;

    /* Output parameters*/
    private double annualMoneyDifferenceConsuming, motorsPricesDifference,
                   lifeCycleConsumedMoneyDifference, lifeCycleConsumedEnergyDifference,
                   newMotorPayBackPeriod, savedMoney;

    /**
     * The constructor for {@code Calculation} class instance creation.
     * @param installedMotor -  installed motor: the instance of the {@code ExtendedMotor} class
     * @param newMotor       - new motor: the instance of the {@code ExtendedMotor} class
     * Method {@code makeCalculations()} sets up output parameters of the instance.
     */
    public Calculation(ExtendedMotor installedMotor, ExtendedMotor newMotor) {
        this.installedMotor = installedMotor;
        this.newMotor = newMotor;
        makeCalculations();
    }

    /* Calculates all output parameters */
    private void makeCalculations() {
        setAnnualMoneyDifferenceConsuming();
        setMotorsPricesDifference();
        setLifeCycleConsumedMoneyDifference();
        setLifeCycleConsumedEnergyDifference();
        setNewMotorPayBackPeriod();
        setSavedMoney();
    }

    private void setAnnualMoneyDifferenceConsuming() {
        this.annualMoneyDifferenceConsuming = installedMotor.getMotorAnnualMoneyConsumption() -
                                              newMotor.getMotorAnnualMoneyConsumption();
    }
    private void setMotorsPricesDifference() {
        this.motorsPricesDifference = newMotor.getMotorPrice() - installedMotor.getMotorPrice();
    }
    private void setLifeCycleConsumedMoneyDifference() {
        this.lifeCycleConsumedMoneyDifference = installedMotor.getMotorLifeCycleMoneyConsumption() -
                                                newMotor.getMotorLifeCycleMoneyConsumption();
    }
    private void setLifeCycleConsumedEnergyDifference() {
        this.lifeCycleConsumedEnergyDifference = installedMotor.getMotorLifeCycleEnergyConsumption() -
                                                 newMotor.getMotorLifeCycleEnergyConsumption();
    }
    private void setNewMotorPayBackPeriod() {
        this.newMotorPayBackPeriod = this.motorsPricesDifference / this.annualMoneyDifferenceConsuming;
    }
    private void setSavedMoney() {
        this.savedMoney = this.lifeCycleConsumedMoneyDifference - this.motorsPricesDifference;
    }

    /**
     * Get annual money difference consuming value
     */
    public double getAnnualMoneyDifferenceConsuming() {
        return annualMoneyDifferenceConsuming;
    }
    /**
     * Get motors price difference value
     */
    public double getMotorsPricesDifference() {
        return motorsPricesDifference;
    }
    /**
     * Get life cycle consumed money difference value
     */
    public double getLifeCycleConsumedMoneyDifference() {
        return lifeCycleConsumedMoneyDifference;
    }
    /**
     * Get life cycle consumed energy difference value
     */
    public double getLifeCycleConsumedEnergyDifference() {
        return lifeCycleConsumedEnergyDifference;
    }
    /**
     * Get new motor payback period value
     */
    public double getNewMotorPayBackPeriod() {
        return newMotorPayBackPeriod;
    }
    /**
     * Get saved money value
     */
    public double getSavedMoney() {
        return savedMoney;
    }
    /**
     * Get installedMotor - instance of the {@code ExtendedMotor} class
     */
    public ExtendedMotor getInstalledMotor() {
        return installedMotor;
    }
    /**
     * Get newMotor - instance of the {@code ExtendedMotor} class
     */
    public ExtendedMotor getNewMotor() {
        return newMotor;
    }
}