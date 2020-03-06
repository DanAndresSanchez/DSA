package tree;

/**
 * A constant has an int value
 * @author Dan Sanchez
 *
 */
public class Constant extends Expression{
	int value;
	
	public Constant(int v) {
		value = v;
	}
	
	@Override
	public int eval() {
		return value;
	}

	@Override
	public Expression simplify() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Constant))
			return false;
		Constant c = (Constant)obj;
		return value == c.value;
	}

	@Override
	public String toString() {
		return "" + value;
	}

}
