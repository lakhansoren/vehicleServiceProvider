import java.util.ArrayList;
import java.util.List;

public class RentalServiceImpl implements RentalService {
    List<BranchInterface> branchList;
    RentalServiceImpl() {
        branchList = new ArrayList<>();
    }
    @Override
    public void onBoardVehicle(String branchId, Vehicle vehicle) {
        BranchInterface branch = getBranch(branchList , branchId);
        branch.onBoardVehicle(vehicle);
    }

    @Override
    public BranchInterface getBranch(List<BranchInterface> branchList, String branchId) {
        for(BranchInterface branch : branchList) {
            if(branch.getName().equals(branchId)) {
                return branch;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void bookVehicle(TimeSlot timeSlot, VehicleType vehicleType) {
        BranchInterface branch = getCheapestBranch(timeSlot, vehicleType);
        branch.bookVehicle(timeSlot, vehicleType);
    }

    @Override
    public BranchInterface getCheapestBranch(TimeSlot timeSlot, VehicleType vehicleType) {
        List<BranchInterface> branches = getAvailableBranches(timeSlot , vehicleType);
        return getCheapestAmongAvailableBranches(branches, timeSlot , vehicleType);
    }

    @Override
    public BranchInterface getCheapestAmongAvailableBranches(List<BranchInterface> branches, TimeSlot timeSlot, VehicleType vehicleType) {
        BranchInterface ansBranch = null;
        int lowestPrice = Integer.MAX_VALUE;
        for(BranchInterface branch : branches) {
            int price = branch.estimateLowest(timeSlot, vehicleType);
            if(price < lowestPrice) {
                ansBranch = branch;
                lowestPrice = price;
            }
        }
        return ansBranch;
    }

    @Override
    public List<BranchInterface> getAvailableBranches(TimeSlot timeSlot, VehicleType vehicleType) {
        List<BranchInterface> branches = new ArrayList<>();
        branchList.forEach(branch -> {
            if(branch.isVehicleAvailable(timeSlot, vehicleType)) {
                branches.add(branch);
            }
        });
        return branches;
    }

    @Override
    public void onBoardBranch(BranchInterface branch) {
        branchList.add(branch);
    }

    @Override
    public List<BranchView> getSystemView(TimeSlot timeSlot) {
        return createBranchView(timeSlot);
    }

    @Override
    public List<BranchView> createBranchView(TimeSlot timeSlot) {
        List<BranchView> branchViews = new ArrayList<>();
        branchList.forEach(branch -> {
            BranchView branchView = new BranchView(branch.getName());
            branch.getAvailableVehicleView(timeSlot).forEach(vehicleView -> {
                branchView.addAvailableVehicleView(vehicleView);
            });
            branch.getUnavailableVehicleType(timeSlot).forEach(vehicleType -> {
                branchView.addUnavailableVehicleType(vehicleType);
            });
            branchViews.add(branchView);
        });
        return branchViews;
    }

    @Override
    public void printBranchNames() {
        branchList.forEach(branchInterface -> {
            System.out.println(branchInterface.getName());
        });
    }
}
