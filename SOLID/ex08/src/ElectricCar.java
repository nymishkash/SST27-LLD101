public class ElectricCar implements Vehicle, ElectricVehicle {
    @Override
    public void recharge(int kWh) {
        System.out.println("Recharged with " + kWh + " kWh");
    }
}
