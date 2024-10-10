public class LeaveRequest {
    private String empName;
    private int days;
    public LeaveRequest(String empName, int days) {
        this.empName = empName;
        this.days = days;
    }
    public String getEmpName() {
        return this.empName;
    }
    public int getDays() {
        return this.days;
    }
}
