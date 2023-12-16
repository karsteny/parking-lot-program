import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTester {
	ParkingLot pl;
	@Test
	void testAddingVehicle() {
		pl = new ParkingLot(2, 3, 8);
		assertEquals(13, pl.getTotalSpots());
		pl.addMotorcycle();
		pl.addCar();
		pl.addVan();
		assertEquals(1, pl.getMotorcycleSpotsRemaining());
		assertEquals(2, pl.getCompactSpotsRemaining());
		assertEquals(5, pl.getRegularSpotsRemaining());
		assertEquals(8, pl.getTotalSpotsRemaining());
	}
	
	@Test
	void testRemovingVehicle() {
		pl = new ParkingLot(2, 3, 8);
		pl.addMotorcycle();
		pl.addCar();
		pl.addVan();
		assertEquals(1, pl.getMotorcycleSpotsRemaining());
		assertEquals(2, pl.getCompactSpotsRemaining());
		assertEquals(5, pl.getRegularSpotsRemaining());
		assertEquals(8, pl.getTotalSpotsRemaining());
		pl.removeCar();
		pl.removeMotorcycle();
		pl.removeVan();
		assertEquals(2, pl.getMotorcycleSpotsRemaining());
		assertEquals(3, pl.getCompactSpotsRemaining());
		assertEquals(8, pl.getRegularSpotsRemaining());
		assertEquals(13, pl.getTotalSpotsRemaining());
		//Test preventing negative cars in spots
		pl.removeCar();
		pl.removeMotorcycle();
		pl.removeVan();
		assertEquals(2, pl.getMotorcycleSpotsRemaining());
		assertEquals(3, pl.getCompactSpotsRemaining());
		assertEquals(8, pl.getRegularSpotsRemaining());
		assertEquals(13, pl.getTotalSpotsRemaining());
		//Stress test
		pl = new ParkingLot(5, 4, 9);
		pl.addCar();
		pl.addCar();
		pl.removeCar();
		pl.addCar();
		pl.addMotorcycle();
		pl.addMotorcycle();
		pl.addMotorcycle();
		pl.removeMotorcycle();
		pl.removeMotorcycle();
		pl.addCar();
		pl.addVan();
		pl.addVan();
		pl.addVan();
		pl.addVan();
		pl.removeVan();
		pl.addMotorcycle();
		assertEquals(3, pl.getMotorcycleSpotsRemaining());
		assertEquals(1, pl.getCompactSpotsRemaining());
		assertEquals(3, pl.getRegularSpotsRemaining());
		assertEquals(7, pl.getTotalSpotsRemaining());
	}
	
	@Test
	void testAddingVehicleWithRollover() {
		pl = new ParkingLot(1, 2, 3);
		assertEquals(6, pl.getTotalSpots());
		pl.addMotorcycle();
		assertEquals(0, pl.getMotorcycleSpotsRemaining());
		assertEquals(2, pl.getCompactSpotsRemaining());
		assertEquals(3, pl.getRegularSpotsRemaining());
		//This motorcycle should cross over to filling compact spaces
		assertEquals(true, pl.addMotorcycle());
		assertEquals(0, pl.getMotorcycleSpotsRemaining());
		assertEquals(1, pl.getCompactSpotsRemaining());
		assertEquals(3, pl.getRegularSpotsRemaining());
		pl.addMotorcycle();
		//This motorcycle should roll over to filling regular spaces
		assertEquals(true, pl.addMotorcycle());
		assertEquals(0, pl.getMotorcycleSpotsRemaining());
		assertEquals(0, pl.getCompactSpotsRemaining());
		assertEquals(2, pl.getRegularSpotsRemaining());
		//Reset
		pl = new ParkingLot(1, 1, 3);
		pl.addCar();
		//This car should roll over to filling regular spaces
		pl.addCar();
		assertEquals(1, pl.getMotorcycleSpotsRemaining());
		assertEquals(0, pl.getCompactSpotsRemaining());
		assertEquals(2, pl.getRegularSpotsRemaining());
	}
	
	@Test
	void testRemovingVehicleWithRollover() {
		//Motorcycle test
		pl = new ParkingLot(1, 2, 3);
		pl.addMotorcycle();
		pl.addMotorcycle();
		pl.addMotorcycle();
		pl.addMotorcycle();
		assertEquals(0, pl.getMotorcycleSpotsRemaining());
		assertEquals(0, pl.getCompactSpotsRemaining());
		assertEquals(2, pl.getRegularSpotsRemaining());
		pl.removeMotorcycle();
		assertEquals(0, pl.getMotorcycleSpotsRemaining());
		assertEquals(0, pl.getCompactSpotsRemaining());
		assertEquals(3, pl.getRegularSpotsRemaining());
		pl.removeMotorcycle();
		pl.removeMotorcycle();
		assertEquals(0, pl.getMotorcycleSpotsRemaining());
		assertEquals(2, pl.getCompactSpotsRemaining());
		assertEquals(3, pl.getRegularSpotsRemaining());
		pl.removeMotorcycle();
		pl.removeMotorcycle();
		assertEquals(1, pl.getMotorcycleSpotsRemaining());
		assertEquals(2, pl.getCompactSpotsRemaining());
		assertEquals(3, pl.getRegularSpotsRemaining());
		pl.addCar();
		pl.addCar();
		pl.addCar();
		pl.addCar();
		assertEquals(1, pl.getMotorcycleSpotsRemaining());
		assertEquals(0, pl.getCompactSpotsRemaining());
		assertEquals(1, pl.getRegularSpotsRemaining());
		pl.removeCar();
		pl.removeCar();
		assertEquals(1, pl.getMotorcycleSpotsRemaining());
		assertEquals(0, pl.getCompactSpotsRemaining());
		assertEquals(3, pl.getRegularSpotsRemaining());
		pl.removeCar();
		assertEquals(1, pl.getMotorcycleSpotsRemaining());
		assertEquals(1, pl.getCompactSpotsRemaining());
		assertEquals(3, pl.getRegularSpotsRemaining());
	}
	
	@Test
	void testSpacesFull() {
		pl = new ParkingLot(1, 1, 3);
		assertEquals(true, pl.isParkingLotEmpty());
		pl.addMotorcycle();
		pl.addCar();
		assertEquals(true, pl.areMotorcycleSpotsFull());
		assertEquals(true, pl.areCompactSpotsFull());
		assertEquals(false, pl.areRegularSpotsFull());
		assertEquals(false, pl.isParkingLotEmpty());
		assertEquals(false, pl.isParkingLotFull());
		pl.addVan();
		assertEquals(false, pl.addVan());
		assertEquals(true, pl.areRegularSpotsFull());
		assertEquals(true, pl.isParkingLotFull());
	}
}
