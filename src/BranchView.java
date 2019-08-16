import java.util.ArrayList;
import java.util.List;

public class BranchView {
    private String branchName;
    private List<VehicleType> unavaibleVehicles;
    private List<VehicleView> availableVehicleViews;

    BranchView(String branchName) {
        this.branchName = branchName;
        this.unavaibleVehicles = new ArrayList<>();
        this.availableVehicleViews = new ArrayList<>();
    }

    public void addAvailableVehicleView(VehicleView vehicleView) {
        availableVehicleViews.add(vehicleView);
    }

    public void addUnavailableVehicleType(VehicleType vehicleType) {
        unavaibleVehicles.add(vehicleType);
    }

    public String getBranchName() {
        return this.branchName;
    }

    public List<VehicleType> getUnavailableVehicles() {
        return unavaibleVehicles;
    }

    public List<VehicleView> getAvailableVehicleList() {
        return availableVehicleViews;
    }
}
