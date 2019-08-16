import java.util.List;

public interface  BranchInterface {
    public void onBoardVehicle(Vehicle vehicle);

    public void bookVehicle(TimeSlot timeSlot , VehicleType vehicleType);

    public boolean isVehicleAvailable(TimeSlot timeSlot , VehicleType vehicleType);

    public int estimateLowest(TimeSlot timeSlot, VehicleType vehicleType);

    String getName();

    public List<VehicleView> getAvailableVehicleView(TimeSlot timeSlot);

    List<VehicleType> getUnavailableVehicleType(TimeSlot timeSlot);
}
