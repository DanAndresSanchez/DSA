package recursion;

public class Mod {
	
	public static void main(String[] args) {
		System.out.println(mod(1,3));
		System.out.println(mod(3,1));
		System.out.println(mod(7,2));
		System.out.println(mod(10,2));
		System.out.println(mod(37,8));
		System.out.println(2/2);
	}
	
	/** @return the modulus, or remainder, when x is divided by y.
	  @param x and y are both positive  
	*/
	public static int mod (int x, int y) {
		if(x < y) {
			return x;
		}
		int n = x -y;
		return mod(n,y);
	}
}
