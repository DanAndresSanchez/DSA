package tree;

public class Quotient extends Expression {

	public Quotient(Expression l, Expression r) {
		left = l;
		right = r;
	}
	
	@Override
	public int eval() {
		return left.eval() / right.eval();
	}

	@Override
	public Expression simplify() {
		left = left.simplify();
		right = right.simplify();
		
		//divided by 0
		if(right instanceof Constant && right.eval() == 0)
			return null;
		if(left instanceof Constant && left.eval() == 0)
			return left;
		
		//divided by 1
		if(right instanceof Constant && right.eval() == 1)
			return left;
		
		
		//division by itself
		tree.Constant one;
		if(left.equals(right)) {
			one = new Constant(1);
			return one;
		}

		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Quotient))
			return false;
		Quotient other = (Quotient)obj;
		
		return left.equals(other.left) && right.equals(other.right);         //division is not commutative
	}

	@Override
	public String toString() {
		return "(" + left + " / " + right + ")";
	}

}
