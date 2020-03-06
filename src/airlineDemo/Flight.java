package airlineDemo;

public class Flight {
	Airport origin, destination;
	
	public Flight(Airport o, Airport d) {
		this.origin = o;
		this.destination = d;
	}
	
	public String toString() {
		return "(" + origin + "->" + destination + ")";
	}
}
