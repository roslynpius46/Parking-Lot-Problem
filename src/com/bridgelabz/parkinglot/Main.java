package com.bridgelabz.parkinglot;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Implementation of Parking Lot Problem");

        ParkingLot parkingLot = new ParkingLot(2);
        ParkingAttendant parkingAttendant = new ParkingAttendant();

        Vehicle car1 = new Vehicle("ABC123", "Toyota", "Blue");
        Vehicle car2 = new Vehicle("XYZ789", "Honda", "Red");

        // Parking attendant parks the vehicles
        parkingAttendant.parkVehicle(parkingLot, car1);
        parkingAttendant.parkVehicle(parkingLot, car2);

        System.out.println("Parked Vehicles:");
        for (Vehicle vehicle : parkingLot.getParkedVehicles()) {
            System.out.println("Number Plate: " + vehicle.getNumberPlate());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Time Parked: " + vehicle.getTimeParked());
            System.out.println("Parking Location: " + vehicle.getParkingLocation(parkingLot));
            System.out.println();
        }

        // USE CASE 2: Unpark a vehicle
        System.out.println("Unparking Vehicle with Number Plate: " + car1.getNumberPlate());
        boolean unparked = parkingLot.unparkVehicle(car1);

        if (unparked) {
            System.out.println("Vehicle unparked successfully.");
        } else {
            System.out.println("Failed to unpark the vehicle. It may not be in the parking lot.");
        }

        // Print updated information about parked vehicles
        System.out.println("\nUpdated Parked Vehicles:");
        for (Vehicle vehicle : parkingLot.getParkedVehicles()) {
            System.out.println("Number Plate: " + vehicle.getNumberPlate());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Time Parked: " + vehicle.getTimeParked());
            System.out.println("Parking Location: " + vehicle.getParkingLocation(parkingLot));
            System.out.println();
        }

        // USE CASE 3: Check if the parking lot is full after unparking
        System.out.println("Is the Parking Lot Full? " + parkingLot.isFull());

        //USE CASE 5:
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        parkingLot.register(parkingLotOwner);
        System.out.println("Is the Parking Space Available? " + !(parkingLotOwner.isCapacityFull()));

        //USE CASE 7: Finding Car location by giving number plate
        parkingAttendant.parkVehicle(parkingLot, car1);
        System.out.println("Vehicle ABC123 is at: "+parkingLot.findVehicleByNumberPlate("ABC123"));

        //USE CASE 8: Know when a particular car was parked
        String searchNumberPlate = "XYZ789";
        int foundLocation = parkingLot.findVehicleByNumberPlate(searchNumberPlate);
        if (foundLocation != -1) {
            Vehicle foundVehicle = parkingLot.getParkedVehicles().get(foundLocation);

            // Get parking duration in milliseconds
            long parkingDuration = parkingLot.getParkingDuration(searchNumberPlate);

            System.out.println("\nFound Vehicle:");
            System.out.println("Number Plate: " + foundVehicle.getNumberPlate());
            System.out.println("Make: " + foundVehicle.getMake());
            System.out.println("Color: " + foundVehicle.getColor());
            System.out.println("Time Parked: " + foundVehicle.getTimeParked());
            System.out.println("Parking Location: " + foundVehicle.getParkingLocation(parkingLot));
            System.out.println("Parking Duration: " + parkingDuration + " milliseconds");
        } else {
            System.out.println("\nVehicle not found.");
        }

    }
}
