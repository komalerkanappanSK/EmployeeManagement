import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    private int headCount = 4; // Maximum direct reports
    private ArrayList<SoftwareEngineer> directReports;

    public TechnicalLead(String name) {
        super(name);
        this.baseSalary *= 1.3; // Increase base salary for TechnicalLead
        this.directReports = new ArrayList<>();
    }

    public boolean hasHeadCount() {
        return this.directReports.size() < headCount;
    }

    public boolean addReport(SoftwareEngineer e) {
        if (this.hasHeadCount()) {
            this.directReports.add(e);
            e.setManager(this); // Assign this TechnicalLead as the manager
            return true;
        }
        return false;
    }

    public ArrayList<SoftwareEngineer> getDirectReports() {
        return this.directReports;
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        return this.directReports.contains(e) && e.getCodeAccess();
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (this.getManager() instanceof BusinessLead) {
            BusinessLead businessLead = (BusinessLead) this.getManager();
            return businessLead.approveBonus(e, bonus);
        }
        return false;
    }

    public String getTeamStatus() {
        StringBuilder status = new StringBuilder(this.employeeStatus());
        if (this.directReports.isEmpty()) {
            status.append(" and has no direct reports yet.");
        } else {
            status.append(" and is managing:\n");
            for (SoftwareEngineer e : directReports) {
                status.append("    ").append(e.employeeStatus()).append("\n");
            }
        }
        return status.toString();
    }
}
