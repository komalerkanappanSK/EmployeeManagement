public class Accountant extends BusinessEmployee {
    private TechnicalLead teamSupported;

    public Accountant(String name) {
        super(name);
        setBonusBudget(0);
    }

    public TechnicalLead getTeamSupported() {
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead;
        double totalSalary = 0;
        for (SoftwareEngineer se : lead.getDirectReports()) {
            totalSalary += se.getBaseSalary();
        }
        setBonusBudget(totalSalary * 1.1);
    }

    public boolean approveBonus(double bonus) {
        return bonus <= getBonusBudget();
    }

    public String employeeStatus() {
        return getEmployeeID() + " " + getName() + " with a budget of " + getBonusBudget() + " is supporting " +
                (teamSupported != null ? teamSupported.getName() : "no one");
    }
}
