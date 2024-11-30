public class TechnicalEmployee extends Employee {
    public TechnicalEmployee(String name) {
        super(name, 75000); // Default salary for a TechnicalEmployee
    }

    @Override
    public String employeeStatus() {
        return this.getEmployeeID() + " " + this.getName();
    }
}
