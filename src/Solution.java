
public class Solution {
	
}

class ParkingLot {
	private final int numMotorcycleSpots;
	private final int numCompactSpots;
	private final int numRegularSpots;
	
	private int occupiedMotorcycleSpots;
	private int occupiedCompactSpots;
	private int occupiedRegularSpots;
	
	private int numMotorcyclesInMotorcycleSpaces;
	private int numMotorcyclesInCompactSpaces;
	private int numMotorcyclesInRegularSpaces;
	private int numCarsInCompactSpaces;
	private int numCarsInRegularSpaces;
	private int numVans;
	
	public ParkingLot(int motorcycleSpots, int compactSpots, int regularSpots) {
		numMotorcycleSpots = motorcycleSpots;
		numCompactSpots = compactSpots;
		numRegularSpots = regularSpots;
		
		occupiedMotorcycleSpots = 0;
		occupiedCompactSpots = 0;
		occupiedRegularSpots = 0;
		
		numMotorcyclesInMotorcycleSpaces = 0;
		numMotorcyclesInCompactSpaces = 0;
		numMotorcyclesInRegularSpaces = 0;
		numCarsInCompactSpaces = 0;
		numCarsInRegularSpaces = 0;
		numVans = 0;
	}
	
	
	/**
	 * Adds a motorcycle to the parking lot.
	 * @return true if the motorcycle could be added, false otherwise.
	 */
	public boolean addMotorcycle() {
		if(!areMotorcycleSpotsFull()) {
			//TODO: adjust motorcycle spot counts
			numMotorcyclesInMotorcycleSpaces++;
			occupiedMotorcycleSpots++;
			return true;
		}else if(!areCompactSpotsFull()) {
			//TODO: adjust compact spot counts
			numMotorcyclesInCompactSpaces++;
			occupiedCompactSpots++;
			return true;
		}else if(!areRegularSpotsFull()) {
			//TODO: adjust regular spot counts
			numMotorcyclesInRegularSpaces++;
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
			numCarsInCompactSpaces++;
			occupiedCompactSpots++;
			return true;
		}else if(!areRegularSpotsFull()) {
			//TODO: adjust regular spot counts
			numCarsInRegularSpaces++;
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
	
	/**
	 * Removes a motorcycle from the parking lot, if there is one.
	 */
	public void removeMotorcycle() {
		if(numMotorcyclesInRegularSpaces > 0) {
			numMotorcyclesInRegularSpaces--;
			occupiedRegularSpots--;
		}else if(numMotorcyclesInCompactSpaces > 0) {
			numMotorcyclesInCompactSpaces--;
			occupiedCompactSpots--;
		}else if(numMotorcyclesInMotorcycleSpaces > 0) {
			numMotorcyclesInMotorcycleSpaces--;
			occupiedMotorcycleSpots--;
		}
	}
	
	/**
	 * Removes a car from the parking lot, if there is one.
	 */
	public void removeCar() {
		if(numCarsInRegularSpaces > 0) {
			System.out.println("regular remove");
			numCarsInRegularSpaces--;
			occupiedRegularSpots--;
		}else if(numCarsInCompactSpaces > 0) {
			System.out.println("compact remove");
			numCarsInCompactSpaces--;
			occupiedCompactSpots--;
		}
	}
	
	/**
	 * Removes a van from the parking lot, if there is one.
	 */
	public void removeVan() {
		if(numVans > 0) {
			numVans--;
			occupiedRegularSpots-=3;
		}
	}
	
	//Getters
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