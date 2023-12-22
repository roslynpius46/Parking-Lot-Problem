import com.bridgelabz.parkinglot.AirportSecurity;
import com.bridgelabz.parkinglot.ParkingLot;
import com.bridgelabz.parkinglot.ParkingLotOwner;
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

        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");

        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.parkVehicle(mockVehicle);

        verify(mockVehicle, times(1)).getNumberPlate();
        assertTrue(parkingLot.getParkedVehicles().contains(mockVehicle));
        assertEquals(1, parkingLot.getParkedVehicles().size());

    }

    /**
     * @desc Testing the function to unpark car
     */
    @Test
    public void testUnparkVehicle() {

        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");

        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.parkVehicle(mockVehicle);

        assertTrue(parkingLot.getParkedVehicles().contains(mockVehicle));
        assertEquals(1, parkingLot.getParkedVehicles().size());

        boolean unparked = parkingLot.unparkVehicle(mockVehicle);

        verify(mockVehicle, times(1)).getNumberPlate();

        assertFalse(parkingLot.getParkedVehicles().contains(mockVehicle));
        assertEquals(0, parkingLot.getParkedVehicles().size());

        assertTrue(unparked);
    }

    /**
     * @desc Testing the function to check if parking lot is full
     */
    @Test
    public void testIsFull() {
        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");

        ParkingLot parkingLot = new ParkingLot(2);

        assertFalse(parkingLot.isFull());

        parkingLot.parkVehicle(mockVehicle);

        assertFalse(parkingLot.isFull());

        Vehicle anotherMockVehicle = mock(Vehicle.class);
        when(anotherMockVehicle.getNumberPlate()).thenReturn("XYZ789");
        parkingLot.parkVehicle(anotherMockVehicle);

        assertTrue(parkingLot.isFull());

        parkingLot.unparkVehicle(mockVehicle);

        assertFalse(parkingLot.isFull());
    }

    /**
     * @desc Testing if parking lot owner is notified when parking lot is full
     */
    @Test
    public void checkIfNotifyOwner() {

        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");


        ParkingLot parkingLot = new ParkingLot(1);

        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        parkingLot.register(parkingLotOwner);

        parkingLot.parkVehicle(mockVehicle);

        assertFalse(parkingLotOwner.isCapacityFull());

        parkingLot.parkVehicle(mockVehicle);

        assertTrue(parkingLotOwner.isCapacityFull());
    }

    /**
     * @desc Testing if airport security is notified when parking lot is full
     */
    @Test
    public void checkIfNotifyAirportSecurity() {

        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");
        ParkingLot parkingLot = new ParkingLot(1);

        AirportSecurity airportSecurity = new AirportSecurity();
        parkingLot.register(airportSecurity);
        parkingLot.parkVehicle(mockVehicle);

        assertFalse(airportSecurity.isCapacityFull());
        parkingLot.parkVehicle(mockVehicle);
        assertTrue(airportSecurity.isCapacityFull());
    }

    /**
     * @desc Testing if parking lot owner is notified when parking space is available
     */
    @Test
    public void checkIfNotifyOwnerSpaceAvailable() {

        Vehicle mockVehicle1 = mock(Vehicle.class);
        when(mockVehicle1.getNumberPlate()).thenReturn("ABC123");

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        parkingLot.register(parkingLotOwner);

        parkingLot.parkVehicle(mockVehicle1);
        parkingLot.parkVehicle(mockVehicle1);
        assertTrue(parkingLotOwner.isCapacityFull());

        parkingLot.unparkVehicle(mockVehicle1);

        assertFalse(parkingLotOwner.isCapacityFull());
    }
}
