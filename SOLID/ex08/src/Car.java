public class Car implements Vehicle, EngineVehicle {
    @Override
    public void startEngine() {
        System.out.println("Engine started");
    }
}
