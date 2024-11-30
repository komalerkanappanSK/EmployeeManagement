import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee {
    private List<Accountant> accountants;
    private double budget;

    public BusinessLead(String name) {
        super(name);
        accountants = new ArrayList<>();
        budget = 0;
    }

    public boolean hasHeadCount() {
        return accountants.size() < 10;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount()) {
            accountants.add(e);
            e.supportTeam(supportTeam);
            budget += e.getBaseSalary() * 1.1;
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus <= budget) {
            budget -= bonus;
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (Accountant a : accountants) {
            if (a.getTeamSupported() == e.getManager() && a.approveBonus(bonus)) {
                return a.approveBonus(bonus);
            }
        }
        return false;
    }

    public String getTeamStatus() {
        StringBuilder status = new StringBuilder(getEmployeeID() + " " + getName() + " with a budget of " + budget);
        for (Accountant a : accountants) {
            status.append("\n").append(a.employeeStatus());
        }
        return status.toString();
    }

    @Override
    public String employeeStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'employeeStatus'");
    }
}
