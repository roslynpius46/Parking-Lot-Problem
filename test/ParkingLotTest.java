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

    /**
     * @desc Testing the function to unpark car
     */
    @Test
    public void testUnparkVehicle() {
        // Mock dependencies
        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");

        // Create a ParkingLot with a capacity of 1
        ParkingLot parkingLot = new ParkingLot(1);

        // Park the vehicle
        parkingLot.parkVehicle(mockVehicle);

        // Verify that the vehicle is in the parked vehicles list
        assertTrue(parkingLot.getParkedVehicles().contains(mockVehicle));
        assertEquals(1, parkingLot.getParkedVehicles().size());

        // Unpark the vehicle
        boolean unparked = parkingLot.unparkVehicle(mockVehicle);

        // Verify that the unparkVehicle method was called with the correct vehicle
        verify(mockVehicle, times(1)).getNumberPlate();

        // Verify that the vehicle is no longer in the parked vehicles list
        assertFalse(parkingLot.getParkedVehicles().contains(mockVehicle));
        assertEquals(0, parkingLot.getParkedVehicles().size());

        // Verify that the vehicle was successfully unparked
        assertTrue(unparked);
    }

    /**
     * @desc Testing the function to check if parking lot is full
     */
    @Test
    public void testIsFull() {
        // Mock dependencies
        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");

        // Create a ParkingLot with a capacity of 2
        ParkingLot parkingLot = new ParkingLot(2);

        // Initially, the parking lot should not be full
        assertFalse(parkingLot.isFull());

        // Park a vehicle in the ParkingLot
        parkingLot.parkVehicle(mockVehicle);

        // Now, the parking lot should not be full
        assertFalse(parkingLot.isFull());

        // Park another vehicle in the ParkingLot
        Vehicle anotherMockVehicle = mock(Vehicle.class);
        when(anotherMockVehicle.getNumberPlate()).thenReturn("XYZ789");
        parkingLot.parkVehicle(anotherMockVehicle);

        // Now, the parking lot should be full
        assertTrue(parkingLot.isFull());

        // Unpark a vehicle to free up space
        parkingLot.unparkVehicle(mockVehicle);

        // Now, the parking lot should not be full
        assertFalse(parkingLot.isFull());
    }
}
