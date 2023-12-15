
public class Solution {
	
}

class ParkingLot {
	private final int numMotorcycleSpots;
	private final int numCompactSpots;
	private final int numRegularSpots;
	
	private int occupiedMotorcycleSpots;
	private int occupiedCompactSpots;
	private int occupiedRegularSpots;
	
	private int numMotorcycles;
	private int numCars;
	private int numVans;
	
	public ParkingLot(int motorcycleSpots, int compactSpots, int regularSpots) {
		numMotorcycleSpots = motorcycleSpots;
		numCompactSpots = compactSpots;
		numRegularSpots = regularSpots;
		occupiedMotorcycleSpots = 0;
		occupiedCompactSpots = 0;
		occupiedRegularSpots = 0;
		numMotorcycles = 0;
		numCars = 0;
		numVans = 0;
	}
	
	
	/**
	 * Adds a motorcycle to the parking lot.
	 * @return true if the motorcycle could be added, false otherwise.
	 */
	public boolean addMotorcycle() {
		if(!areMotorcycleSpotsFull()) {
			//TODO: adjust motorcycle spot counts
			numMotorcycles++;
			occupiedMotorcycleSpots++;
			return true;
		}else if(!areCompactSpotsFull()) {
			//TODO: adjust compact spot counts
			numMotorcycles++;
			occupiedCompactSpots++;
			return true;
		}else if(!areRegularSpotsFull()) {
			//TODO: adjust regular spot counts
			numMotorcycles++;
			occupiedRegularSpots++;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Adds a car to the parking lot.
	 * @return true if the car could be added, false otherwise.
	 */
	public boolean addCar() {
		if(!areCompactSpotsFull()) {
			//TODO: adjust compact spot counts
			numCars++;
			occupiedCompactSpots++;
			return true;
		}else if(!areRegularSpotsFull()) {
			//TODO: adjust regular spot counts
			numCars++;
			occupiedRegularSpots++;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Adds a van to the parking lot.
	 * @return true if the van could be added, false otherwise.
	 */
	public boolean addVan() {
		if(getRegularSpotsRemaining() >= 3) {
			//TODO: adjust regular spot counts
			numVans++;
			occupiedRegularSpots+=3;
			return true;
		}else {
			return false;
		}
	}
	
	
	public int getTotalSpotsRemaining() { 
		return getMotorcycleSpotsRemaining() + getCompactSpotsRemaining() + getRegularSpotsRemaining(); 
	}
	public int getMotorcycleSpotsRemaining() { 
		return numMotorcycleSpots - occupiedMotorcycleSpots;	
	}
	public int getCompactSpotsRemaining() { 
		return numCompactSpots - occupiedCompactSpots; 
	}
	public int getRegularSpotsRemaining() { 
		return numRegularSpots - occupiedRegularSpots; 
	}
	
	public int getTotalSpots() { 
		return numMotorcycleSpots + numCompactSpots + numRegularSpots; 
	} 
	
	public int getNumSpacesWithVans() {
		return numVans * 3;
	}
	
	public boolean isParkingLotFull() { 
		return getTotalSpotsRemaining() == 0; 
	}
	public boolean isParkingLotEmpty() {
		return getTotalSpots() == getTotalSpotsRemaining();
	}
	public boolean areMotorcycleSpotsFull() {
		return getMotorcycleSpotsRemaining() == 0;
	}
	public boolean areCompactSpotsFull() {
		return getCompactSpotsRemaining() == 0;
	}
	public boolean areRegularSpotsFull() {
		return getRegularSpotsRemaining() == 0;
	}
	
}