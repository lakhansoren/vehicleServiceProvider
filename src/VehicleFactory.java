public class VehicleFactory {
    public static Vehicle getVehicle(VehicleType vehicleType , int rate) {
        switch(vehicleType) {
            case SUV:
                return new SUV(rate);
            case Bike :
                return new Bike(rate);
            case Sedan :
                return new Sedan(rate);
            default :
                throw new IllegalArgumentException();
        }
    }
}
