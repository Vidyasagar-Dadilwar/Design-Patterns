public class Director extends LeaveHandler {
    @Override
    public void handleLeaveRequest(LeaveRequest request) {
        if (request.getDays() > 15) {
            System.out.println("Approved by Director for emp name: " + request.getEmpName());
        }
    }
}
