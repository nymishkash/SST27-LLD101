public class Demo10 {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger();
        ReportService reportService1 = new ReportService(consoleLogger);
        reportService1.generate();
        
        Logger fileLogger = new FileLogger();
        ReportService reportService2 = new ReportService(fileLogger);
        reportService2.generate();
    }
}
