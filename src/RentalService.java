import java.util.List;

public interface RentalService {
    void onBoardVehicle(String branchId, Vehicle vehicle);

    BranchInterface getBranch(List<BranchInterface> branchList, String branchId);

    void bookVehicle(TimeSlot timeSlot, VehicleType vehicleType);

    BranchInterface getCheapestBranch(TimeSlot timeSlot, VehicleType vehicleType);

    BranchInterface getCheapestAmongAvailableBranches(List<BranchInterface> branches, TimeSlot timeSlot, VehicleType vehicleType);

    List<BranchInterface> getAvailableBranches(TimeSlot timeSlot, VehicleType vehicleType);

    void onBoardBranch(BranchInterface branch);

    List<BranchView> getSystemView(TimeSlot timeSlot);

    List<BranchView> createBranchView(TimeSlot timeSlot);

    void printBranchNames();
}
