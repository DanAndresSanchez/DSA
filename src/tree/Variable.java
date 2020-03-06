package tree;

public class Variable extends Expression{
	protected char name;
	int value;
	//public boolean hasValue;
	protected boolean hasValue;
	
	public Variable(char c) {
		name = c;
		value = 0;
		hasValue = false;
	}

	@Override
	public int eval() {
		if(hasValue == false)
			throw new IllegalArgumentException("Attempt to evaluate a variable which has no value.");
		return value;
	}

	@Override
	public Expression simplify() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Variable))
			return false;
		Variable other = (Variable)obj;
		
		if(this.name == other.name)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "" + name;
	}
}
