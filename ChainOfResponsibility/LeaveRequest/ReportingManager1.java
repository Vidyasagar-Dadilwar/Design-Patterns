public class ReportingManager1 extends LeaveHandler {
    @Override
    public void handleLeaveRequest(LeaveRequest request) {
        if (request.getDays() < 5) {
            System.out.println("Approved by Manager 1 for emp name: " + request.getEmpName());
        } else if (nextHandler != null) {
            nextHandler.handleLeaveRequest(request);
        }
    }
}
