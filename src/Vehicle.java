import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    List<TimeSlot> bookedTimeSlot;

    int vehicleRate;

    VehicleType vehicleType;

    Vehicle(VehicleType vehicleType , int vehicleRate) {
        this.vehicleType = vehicleType;
        this.vehicleRate = vehicleRate;
        bookedTimeSlot = new ArrayList<>();
    }

    public void bookVehicle(TimeSlot timeSlot) {

        bookedTimeSlot.add(timeSlot);
    }

    public boolean isAvailable(TimeSlot timeSlot) {
        boolean isAvailable = true;
        for(TimeSlot timeSlotItem : bookedTimeSlot) {
            if((timeSlot.getStartTime() >= timeSlotItem.getStartTime() &&
            timeSlot.getStartTime() <= timeSlotItem.getEndTime() ) || (timeSlot.getEndTime() >=
                    timeSlotItem.getStartTime() && timeSlot.getEndTime() <= timeSlotItem.getEndTime())) {
                isAvailable = false;
            }
        }
        return isAvailable;
    }

    public VehicleType getVehicleType() {

        return this.vehicleType;
    }

    public int getVehicleRate() {

        return this.vehicleRate;
    }
}