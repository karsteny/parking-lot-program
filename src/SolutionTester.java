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
	void testSpacesFull() {
		pl = new ParkingLot(1, 1, 2);
		assertEquals(true, pl.isParkingLotEmpty());
		pl.addMotorcycle();
		pl.addCar();
		assertEquals(false, pl.addVan());
		assertEquals(true, pl.areMotorcycleSpotsFull());
		assertEquals(true, pl.areCompactSpotsFull());
		pl.addMotorcycle();
		pl.addCar();
		assertEquals(false, pl.addVan());
		assertEquals(false, pl.addCar());
		assertEquals(false, pl.addMotorcycle());
		assertEquals(true, pl.areRegularSpotsFull());
		assertEquals(true, pl.isParkingLotFull());
	}
}
