package airlineDemo;

/**
 * 
 * @author Dan Sanchez
 *
 */
public class Airport implements Comparable<Airport> {
		String name;
		boolean visited = false;
		boolean hub;
		
		public Airport(String name) {
			this.name = name;
			hub = false;
		}
		
		public Airport(String name, boolean hub) {
			this.name = name;
			this.hub = hub;
		}
		
		public String toString() {
			if(hub == false)
				return name;
			else
				return name + "(H)";
		}
		
		public boolean equals(Object obj) {
			if(!(obj instanceof Airport))
				return false;
			Airport other = (Airport)obj;
			return name.equals(other.name);
		}
		
		public void setHub(boolean hub) {
			this.hub = hub;
		}

		@Override
		public int compareTo(Airport other) {
			if(this.hub && other.hub)
				return 0;
			else {
				if(this.hub  && !other.hub)
					return 1;
				else
					return -1;
			}
			
		}
}
