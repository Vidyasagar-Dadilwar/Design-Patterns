public class Main {
    public static void main(String[] args) {
        ReportGenerator pdf = new PDF();
        pdf.generateReport();

        ReportGenerator html = new HTML();
        html.generateReport();
    }
}
