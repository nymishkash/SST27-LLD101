public class Demo07 {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello");
        
        Machine multiFunctionMachine = new MultiFunctionMachine();
        multiFunctionMachine.print("Hello");
        multiFunctionMachine.scan("/tmp/out");
        multiFunctionMachine.fax("123-456-7890");
    }
}
