import java.util.ArrayList;
import java.util.List;

public class Branch implements BranchInterface{
    private String name;
    List<Vehicle> vehicleList;
    public Branch(String branchName) {
        this.name = branchName;
        this.vehicleList = new ArrayList<>();
    }

    @Override
    public void onBoardVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    @Override
    public void bookVehicle(TimeSlot timeSlot, VehicleType vehicleType) {
        Vehicle vehicle = getAvailableVehicle(timeSlot , vehicleType);
        vehicle.bookVehicle(timeSlot);
    }

    private Vehicle getAvailableVehicle(TimeSlot timeSlot, VehicleType vehicleType) {
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.isAvailable(timeSlot) && vehicleType == vehicle.getVehicleType()) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public boolean isVehicleAvailable(TimeSlot timeSlot, VehicleType vehicleType) {
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.isAvailable(timeSlot) && vehicleType == vehicle.getVehicleType()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int estimateLowest(TimeSlot timeSlot, VehicleType vehicleType) {
        int price = Integer.MAX_VALUE;
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.getVehicleType() == vehicleType) {
                if(price > vehicle.getVehicleRate()) {
                    price = vehicle.getVehicleRate();
                }
            }
        }
        return price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<VehicleView> getAvailableVehicleView(TimeSlot timeSlot) {
        List<VehicleView> vehicleViewList = new ArrayList<>();
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.isAvailable(timeSlot)) {
                VehicleView vehicleView = new VehicleView(vehicle.getVehicleType() , vehicle.getVehicleRate());
                vehicleViewList.add(vehicleView);
            }
        }
        return vehicleViewList;
    }

    @Override
    public List<VehicleType> getUnavailableVehicleType(TimeSlot timeSlot) {
        List<VehicleType> vehicleTypeList = new ArrayList<>();
        vehicleList.forEach(vehicle -> {
            if(vehicle.isAvailable(timeSlot) == false) {
                vehicleTypeList.add(vehicle.getVehicleType());
            }
        });
        return vehicleTypeList;
    }
}
