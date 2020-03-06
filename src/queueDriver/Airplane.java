package queueDriver;

/**
 * An Airplane has an arrival time and a fuel level.
 * 
 * @author (sdb & ADD YOUR NAME HERE)
 * @version (Nov 2018)
 */
public class Airplane implements Comparable<Airplane> {
	int flight;
	int arrivalTime;
	int fuelLevel; // gallons of jet fuel remaining

	public Airplane(int arrival, int fuel, int flight) {
		arrivalTime = arrival;
		fuelLevel = fuel;
		this.flight = flight;
		System.out.println(this + " has arrived at time " + arrival);

	}

	public int getFuel() {
		return fuelLevel;
	}

	public int getTime() {
		return arrivalTime;
	}

	public int compareTo(Airplane o) {
		if (((Airplane) o).getFuel() < 4 && fuelLevel < 4)
			if (((Airplane) o).getFuel() == fuelLevel) {
				if (((Airplane) o).getTime() < arrivalTime)
					return -1;
				if (arrivalTime < ((Airplane) o).getTime())
					return 1;
				return 0;
			} else
				return ((Airplane) o).getFuel() - fuelLevel;
		if (((Airplane) o).getFuel() < 4)
			return -1;
		if (fuelLevel < 4)
			return 1;
		return ((Airplane) o).getTime() - arrivalTime;
	}

	public String toString() {
		return "[Flight Number: " + flight + ". Gallons: " + fuelLevel + "]";
	}

}