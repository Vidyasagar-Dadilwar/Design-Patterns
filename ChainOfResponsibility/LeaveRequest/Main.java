public class Main {
    public static void main(String[] args) {
        ReportingManager1 manager1 = new ReportingManager1();
        ReportingManager2 manager2 = new ReportingManager2();
        Director director = new Director();

        manager1.setNextHandler(manager2);
        manager2.setNextHandler(director);

        LeaveRequest req1 = new LeaveRequest("ABC", 3);
        manager1.handleLeaveRequest(req1);

        LeaveRequest req2 = new LeaveRequest("DEF", 7);
        manager1.handleLeaveRequest(req2);

        LeaveRequest req3 = new LeaveRequest("GHI", 33);
        manager1.handleLeaveRequest(req3);
    }
}