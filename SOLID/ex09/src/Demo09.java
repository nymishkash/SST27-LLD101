public class Demo09 {
    public static void main(String[] args) {
        OrderRepository sqlRepo = new SqlOrderRepository();
        OrderController controller1 = new OrderController(sqlRepo);
        controller1.create("ORD-1");
        
        OrderRepository noSqlRepo = new NoSqlOrderRepository();
        OrderController controller2 = new OrderController(noSqlRepo);
        controller2.create("ORD-2");
    }
}
