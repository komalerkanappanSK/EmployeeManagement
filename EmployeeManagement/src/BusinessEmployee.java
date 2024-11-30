public abstract class BusinessEmployee extends Employee {
    private double bonusBudget;

    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void setBonusBudget(double budget) {
        this.bonusBudget = budget;
    }

    public abstract String employeeStatus();
}
