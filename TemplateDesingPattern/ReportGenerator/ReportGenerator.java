abstract class ReportGenerator{
    final void generateReport(){
        fetchData();
        processData();
        formatData();
    }
    void fetchData(){
        System.out.println("Fetching the data ...");
    }
    void processData(){
        System.out.println("Processing the data ...");
    }
    abstract void formatData();
}