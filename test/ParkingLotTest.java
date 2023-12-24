import com.bridgelabz.parkinglot.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * @desc Check if parking attendant parks the cars
     */
    @Test
    public void testParkingByParkingAttendant() {
        Vehicle mockVehicle = mock(Vehicle.class);
        when(mockVehicle.getNumberPlate()).thenReturn("ABC123");

        ParkingLot parkingLot = new ParkingLot(2);
        ParkingAttendant parkingAttendant = new ParkingAttendant();

        assertTrue(parkingAttendant.parkVehicle(parkingLot, mockVehicle));
        assertFalse(parkingLot.isFull());

        Vehicle anotherMockVehicle = mock(Vehicle.class);
        when(anotherMockVehicle.getNumberPlate()).thenReturn("XYZ789");

        assertTrue(parkingAttendant.parkVehicle(parkingLot, anotherMockVehicle));
        assertTrue(parkingLot.isFull());
    }

    /**
     * @desc Test case for finding a vehicle by number plate
     */
    @Test
    public void testFindVehicleByNumberPlate() {
        Vehicle mockVehicle1 = mock(Vehicle.class);
        when(mockVehicle1.getNumberPlate()).thenReturn("ABC123");

        Vehicle mockVehicle2 = mock(Vehicle.class);
        when(mockVehicle2.getNumberPlate()).thenReturn("XYZ789");

        ParkingLot parkingLot = new ParkingLot(2);
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        parkingAttendant.parkVehicle(parkingLot, mockVehicle1);
        parkingAttendant.parkVehicle(parkingLot, mockVehicle2);

        // Test finding the first vehicle
        int foundLocation1 = parkingLot.findVehicleByNumberPlate("ABC123");
        assertTrue(foundLocation1 != -1); // Ensure vehicle is found

        // Test finding the second vehicle
        int foundLocation2 = parkingLot.findVehicleByNumberPlate("XYZ789");
        assertTrue(foundLocation2 != -1); // Ensure vehicle is found

        // Test finding a non-existing vehicle
        int nonExistingVehicle = parkingLot.findVehicleByNumberPlate("ZZZ999");
        assertEquals(-1,nonExistingVehicle); // Ensure vehicle is not found
    }

    /**
     * @desc Test function to get time for which car was parked
     */
    @Test
    public void testGetParkingDuration() {
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingAttendant parkingAttendant = new ParkingAttendant();

        Vehicle mockVehicle1 = mock(Vehicle.class);
        when(mockVehicle1.getNumberPlate()).thenReturn("ABC123");

        Vehicle mockVehicle2 = mock(Vehicle.class);
        when(mockVehicle2.getNumberPlate()).thenReturn("XYZ789");

        parkingAttendant.parkVehicle(parkingLot, mockVehicle1);
        parkingAttendant.parkVehicle(parkingLot, mockVehicle2);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long parkingDurationCar1 = parkingLot.getParkingDuration("ABC123");
        long parkingDurationCar2 = parkingLot.getParkingDuration("XYZ789");

        assertTrue(parkingDurationCar1 > 0);
        assertTrue(parkingDurationCar2 > 0);

        System.out.println("Parking duration for car1: " + parkingDurationCar1 + " milliseconds");
        System.out.println("Parking duration for car2: " + parkingDurationCar2 + " milliseconds");
    }

    /**
     * @desc Test case for even distribution of cars among parking lots
     */
    @Test
    public void testEvenDistribution() {

        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot lot1 = new ParkingLot(2);
        ParkingLot lot2 = new ParkingLot(2);
        parkingLots.add(lot1);
        parkingLots.add(lot2);

        ParkingAttendant parkingAttendant = new ParkingAttendant();

        for (int i = 0; i < 4; i++) {
            Vehicle car = new Vehicle("CAR" + (i + 1), "Honda", "Gray");
            boolean parked= parkingAttendant.refactoredParkVehicle(parkingLots, car);
            assertTrue(parked);
        }

        assertEquals(2, lot1.getParkedVehicles().size());
        assertEquals(2, lot2.getParkedVehicles().size());
    }

    /**
     * @desc Test case for parking a handicapped driver's car in the nearest available space
     */
    @Test
    public void testParkHandicappedDriverCar() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);

        ParkingAttendant parkingAttendant = new ParkingAttendant();
        Vehicle handicappedCar = new Vehicle("HND123", "Toyota", "Silver");

        assertTrue(parkingAttendant.parkVehicleForHandicapDriver(List.of(parkingLot1, parkingLot2), handicappedCar));

        assertEquals(1, parkingLot1.getParkedVehicles().size());
        assertEquals(handicappedCar, parkingLot1.getParkedVehicles().get(0));
        assertEquals(0, parkingLot2.getParkedVehicles().size());
    }

    /**
     * @desc Test case for parking a large vehicle in the lot with the highest number of free spaces
     */
    @Test
    public void testParkLargeVehicle() {
        Vehicle mockLargeVehicle = mock(Vehicle.class);
        when(mockLargeVehicle.getNumberPlate()).thenReturn("LARGE001");

        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);

        ParkingAttendant parkingAttendant = new ParkingAttendant();

        assertTrue(parkingAttendant.parkLargeVehicle(List.of(parkingLot1, parkingLot2), mockLargeVehicle));

        assertEquals(0, parkingLot1.getParkedVehicles().size());
        assertEquals(1, parkingLot2.getParkedVehicles().size());
        assertTrue(parkingLot2.getParkedVehicles().contains(mockLargeVehicle));
    }
}
