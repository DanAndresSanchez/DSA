package airlineDemo;

import list.*;
import map.*;
import queue.PriorityQueue;
import queue.Queue;
import queue.QueueADT;

import java.io.*;
import java.util.Scanner;


/**
 * 
 * @author Dan Sanchez
 *
 */
public class Airline {
	List<Flight> flights; // direct flights
	Map<String, Airport> map; // maps airport names to an Airport

	public static void main(String[] args) {
		Airline airline = new Airline();
		airline.getFlights(); // gets all flights and creates map
		System.out.println("Flights: " + airline.flights);
		System.out.println("Map: " + airline.map);
		System.out.println("Path from CVG to Paris");
		airline.setHub("SND", true);

	}

	private List<Airport> path(String origin, String dest) {
		Airport o = map.get(origin);
		Airport d = map.get(dest);
		List<Airport> result;
		result = path(o, d);
		return result;
	}

	private List<Airport> path(Airport origin, Airport dest) {
		List<Airport> result = new ArrayList<Airport>();
		origin.visited = true;
		
		if (origin.equals(dest)) { // base case
			result.add(origin);
			return result;
		}
		
		Iterator<Airport> itty = getDirect(origin).iterator();
		while (itty.hasNext()) {
			Airport port = itty.next();
			port.visited = true;
			result = path(port, dest);
			if (!(result.isEmpty())) {
				result.add(0, origin);
				return result;
			}
		}
		return result; // empty list. no path found
	}

	/**
	 * reads flights from a text file
	 */
	private void getFlights() {
		File inFile = new File("flights2.txt");
		map = new HashMap<String, Airport>();
		flights = new ArrayList<Flight>();

		// need to catch FileNotFoundException
		try {
			Scanner scan = new Scanner(inFile);
			String flight, origin, dest;
			Airport o, d;

			// reads text file
			while (scan.hasNextLine()) {
				flight = scan.nextLine();
				origin = flight.split(" ")[0];
				dest = flight.split(" ")[1];

				// check if origin airport is already in map
				if (map.containsKey(origin))
					o = map.get(origin);
				else {
					o = new Airport(origin);
					map.put(origin, o);
				}

				// check if destination airport is already in map
				if (map.containsKey(dest))
					d = map.get(dest);
				else {
					d = new Airport(dest);
					map.put(dest, d);
				}

				flights.add(new Flight(o, d));
			}

			scan.close(); // good practice to close scanner after finished reading file
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
	}

	// Return a list of Airports which can be reached directly from 'from',
	// and which have not already been visited.
	private List<Airport> getDirect(Airport from) {
		QueueADT<Airport> queue = new PriorityQueue<Airport>();

		Iterator<Flight> itty = flights.iterator();
		Flight flight;
		while (itty.hasNext()) {
			flight = itty.next();
			if (flight.origin.equals(from) && !flight.destination.visited) { // flight.destination.visited = true;
				queue.add(flight.destination);
			}
		}
		List<Airport> result = new ArrayList<Airport>();
		while(queue.size() != 0) 
			result.add(queue.remove());
			
		return result;
	}

	private void clearAirports() {
		Flight flight;
		Airport port;
		Iterator<Flight> itty = flights.iterator();
		while (itty.hasNext()) {
			flight = itty.next();
			flight.origin.visited = false;
			flight.destination.visited = false;
		}
	}

	public void setHub(String a, boolean hub) {
		Airport h = map.get(a);
		h.setHub(hub);
		System.out.println(a + " is now a hub");
	}
}
