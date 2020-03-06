/**
 * 
 */
package tree;

/**
 * @author Dan Sanchez
 *
 */
public class Sum extends Expression{
	
	public Sum(Expression l, Expression r) {
		left = l;
		right = r;
	}
	
	@Override
	public int eval() {
		return left.eval() + right.eval();
	}

	@Override
	public Expression simplify() {
		left = left.simplify();
		right = right.simplify();
		
		//addition by 0
		if(right instanceof Constant && right.eval() == 0)
			return left;
		if(left instanceof Constant && left.eval() == 0)
			return right;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Sum))
			return false;
		Sum other = (Sum)obj;
		return left.equals(other.left) && right.equals(other.right)    //addition is commutative
			   || left.equals(other.right) && right.equals(other.left);
	}

	@Override
	/**
	 * @return an infix string
	 */
	public String toString() {
		return "(" + left + " + " + right + ")";
	}
}
