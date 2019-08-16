public class Bike extends Vehicle {
    public static VehicleType vehicleType = VehicleType.Bike;
    Bike(int vehicleRate) {
        super(vehicleType, vehicleRate);
    }
}
