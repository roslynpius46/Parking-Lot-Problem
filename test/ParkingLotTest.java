import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.Vehicle;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParkingLotTest {

    /**
     * @desc Testing the function to park car
     */
    @Test
    public void testParkVehicle() {
        // Mock dependencies
        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");

        // Create a ParkingLot with a capacity of 1
        ParkingLot parkingLot = new ParkingLot(1);

        // Park the vehicle
        parkingLot.parkVehicle(mockVehicle);

        // Verify that the parkVehicle method was called with the correct vehicle
        verify(mockVehicle, times(1)).getNumberPlate();
        assertTrue(parkingLot.getParkedVehicles().contains(mockVehicle));
        assertEquals(1, parkingLot.getParkedVehicles().size());

    }
}
