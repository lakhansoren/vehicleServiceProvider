import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    private static RentalService rentalService = new RentalServiceImpl();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {
        while(true) {
            String input = null;
            try {
                System.out.println("Enter your choice. The choices are : ");
                for(int i = 0 ; i < DriverChoices.values().length ; i++) {
                    System.out.println(DriverChoices.values()[i]);
                }
                input = readString();
                choiceMaker(DriverChoices.valueOf(input));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static void choiceMaker(DriverChoices input) throws IOException {
        switch(input) {
            case addBranch :
                addBranch();
                break;
            case addVehicle :
                addVehicle();
                break;
            case rentVehicle :
                rentVehicle();
                break;
            case systemView :
                printSystemView();
                break;
            default :
                throw new IllegalArgumentException();
        }
    }

    public static void addBranch() throws IOException {
        BranchInterface branch = getBranch();
        rentalService.onBoardBranch(branch);
    }

    private static BranchInterface getBranch() throws IOException {
        String branchName = getBranchName();
        return new Branch(branchName);
    }

    public static void addVehicle() throws IOException {
        System.out.println("The choices for branches are ");
        rentalService.printBranchNames();
        String branchName = getBranchName();
        Vehicle vehicle = getVehicle();
        rentalService.onBoardVehicle(branchName , vehicle);
    }

    private static String getBranchName() throws IOException {
        System.out.println("Enter the branch name  :  ");
        return readString();
    }

    private static Vehicle getVehicle() throws IOException {
        VehicleType vehicleTypeEnum = getVehicleType();
        System.out.println("Enter the rate per hours of the vehicle :  ");
        int rate = readInt();
        return VehicleFactory.getVehicle(vehicleTypeEnum , rate);
    }

    private static VehicleType getVehicleType() throws IOException {
        System.out.println("Enter the choice of vehicle. The choices are  ");
        for(int i = 0 ; i < VehicleType.values().length ; i++) {
            System.out.println(VehicleType.values()[i]);
        }
        String vehicleType = readString();
        return VehicleType.valueOf(vehicleType);
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public static void rentVehicle() throws IOException {
        TimeSlot timeSlot = getTimeSlot();
        VehicleType vehicleType = getVehicleType();
        rentalService.bookVehicle(timeSlot, vehicleType);
    }

    private static TimeSlot getTimeSlot() throws IOException {
        System.out.println("Enter the start time of the time slot :  ");
        int startTime = readInt();
        System.out.println("Enter the end time of the time slot :  ");
        int endTime = readInt();
        TimeSlot timeSlot = new TimeSlot(startTime , endTime);
        return timeSlot;
    }

    public static void printSystemView() throws IOException {
        TimeSlot timeSlot = getTimeSlot();
        System.out.println("Printing the system view for the start time slot " + timeSlot.getStartTime());
        System.out.println("And end time " + timeSlot.getEndTime());
        SystemViewPrinter.printView(rentalService.getSystemView(timeSlot));
    }
}
