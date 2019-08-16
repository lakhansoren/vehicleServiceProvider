public class Sedan extends Vehicle {
    public static VehicleType vehicleType = VehicleType.Sedan;
    Sedan(int vehicleRate) {
        super(vehicleType, vehicleRate);
    }
}
