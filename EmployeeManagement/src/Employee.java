public class Employee {
    private static int employeeCount = 0;

    private int employeeID;
    private String name;
    protected double baseSalary; // Changed to protected for access by subclasses
    private Employee manager;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        employeeCount++;
        this.employeeID = employeeCount;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee other = (Employee) obj;
            return this.employeeID == other.employeeID;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.employeeID + " " + this.name;
    }

    public String employeeStatus() {
        return this.toString();
    }
}
