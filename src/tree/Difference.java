package tree;

public class Difference extends Expression{

	public Difference(Expression l, Expression r) {
		left = l;
		right = r;
	}
	
	@Override
	public int eval() {
		return left.eval() - right.eval();
	}

	@Override
	public Expression simplify() {
		left = left.simplify();
		right = right.simplify();
		
		//subtraction by 0
		if(right instanceof Constant && right.eval() == 0)
			return left;
		
		//subtraction by itself
		tree.Constant zero = new Constant(0);
		if(left.equals(right))
			return zero;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Difference))
			return false;
		Difference other = (Difference)obj;
		return left.equals(other.left) && right.equals(other.right);    //subtraction is not commutative
	}

	@Override
	/**
	 * @return an infix string
	 */
	public String toString() {
		return "(" + left + " - " + right + ")";
	}

}
