import java.util.List;

public class SystemViewPrinter {
    public static void printView(List<BranchView> systemView) {
        for(BranchView branchView : systemView) {
            System.out.println("Branch :  " + branchView.getBranchName());
            List<VehicleType> unavailableVehicleTypeList = branchView.getUnavailableVehicles();
            if(unavailableVehicleTypeList.size() == 0) {
                System.out.println("There are no unavailable vehicles for this time period ");
            }
            else {
                unavailableVehicleTypeList.forEach(vehicleType -> {
                    System.out.println(vehicleType + "  is unavailable");
                });
            }
            List<VehicleView> availableVehicleViewList  = branchView.getAvailableVehicleList();
            if(availableVehicleViewList.size() == 0) {
                System.out.println("There are no available vehicles for this time period.");
            }
            else {
                System.out.println("Printing the available vehicles : ");
                availableVehicleViewList.forEach(vehicleView -> {
                    System.out.println(vehicleView.getVehicleType()
                            + "  is available for this rate " + vehicleView.getVehicleRate());
                });
            }
        }
    }
}
