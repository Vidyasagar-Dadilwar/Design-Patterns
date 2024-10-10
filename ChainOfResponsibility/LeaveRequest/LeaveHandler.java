public abstract class LeaveHandler {
    protected LeaveHandler nextHandler = null;
    public void setNextHandler(LeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handleLeaveRequest(LeaveRequest request);
}
