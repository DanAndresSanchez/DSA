package tree;

public class Product extends Expression{

	public Product(Expression l, Expression r) {
		left = l;
		right = r;
	}
	
	@Override
	public int eval() {
		return left.eval() * right.eval();
	}

	@Override
	public Expression simplify() {
		left = left.simplify();
		right = right.simplify();
		
		//multiplied by 0
		if(right instanceof Constant && right.eval() == 0)
			return right;
		if(left instanceof Constant && left.eval() == 0)
			return left;
		
		//multiplied by 1
		if(right instanceof Constant && right.eval() == 1)
			return left;
		if(left instanceof Constant && left.eval() == 1)
			return right;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Product))
			return false;
		Product other = (Product)obj;
		return left.equals(other.left) && right.equals(other.right)         //multiplication is commutative
				   || left.equals(other.right) && right.equals(other.left);
	}

	@Override
	public String toString() {
		return "(" + left + " * " + right + ")";
	}

}
