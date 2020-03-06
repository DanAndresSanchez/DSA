package hashDriver;

/**
 * 
 * @author Dan Sanchez
 *
 */
public class HomeTown {

	String name;
	String state;
	String zipCode;
	
	public HomeTown(String name, String state, String zipCode) {
		this.name = name;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public boolean equals(Object other) {
		if(!(other instanceof HomeTown))
			return false;
		HomeTown ht = (HomeTown)other;
		if(ht.getZip().equals(this.getZip()))
			return true;
		return false;
	}
	
	public String getZip() {
		return zipCode;
	}

	public int hashCode() {
		return zipCode.hashCode();
	}
	
	public String toString() {
		return name + " , " + state + " " + zipCode;
	}
}
