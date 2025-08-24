public class Demo08 {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.pedal(5);
        
        Car car = new Car();
        car.startEngine();
        
        ElectricCar electricCar = new ElectricCar();
        electricCar.recharge(50);
    }
}
