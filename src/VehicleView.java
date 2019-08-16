public class VehicleView {
    private VehicleType vehicleType;
    private int rate;
    VehicleView(VehicleType vehicleType , int rate) {
        this.rate = rate;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getVehicleRate() {
        return rate;
    }
}
