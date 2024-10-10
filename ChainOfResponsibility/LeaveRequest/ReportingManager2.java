public class ReportingManager2 extends LeaveHandler {
    @Override
    public void handleLeaveRequest(LeaveRequest request) {
        if (request.getDays() <= 15) {
            System.out.println("Approved by Manager 2 for emp name: " + request.getEmpName());
        } else if (nextHandler != null) {
            nextHandler.handleLeaveRequest(request);
        }
    }
}
