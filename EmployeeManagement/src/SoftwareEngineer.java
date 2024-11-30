public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;
    private int successfulCheckIns;

    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false; // Starts without access to code
        this.successfulCheckIns = 0; // Starts with 0 successful check-ins
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return successfulCheckIns;
    }

    public boolean checkInCode() {
        if (this.getManager() instanceof TechnicalLead) {
            TechnicalLead manager = (TechnicalLead) this.getManager();
            if (manager.approveCheckIn(this)) {
                successfulCheckIns++;
                return true;
            } else {
                this.setCodeAccess(false); // If not approved, revoke access
            }
        }
        return false;
    }

    @Override
    public String employeeStatus() {
        return super.employeeStatus() + " has " + this.getSuccessfulCheckIns() + " successful check-ins";
    }
}
