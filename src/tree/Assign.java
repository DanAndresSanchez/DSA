package tree;

public class Assign extends Expression{
	Variable left;
	Expression right;
	
	public Assign(Expression b, Constant constant) {
		left = (Variable) b;
		left.value = constant.value;
		left.hasValue = true;
	}
	public Assign(Expression a, Expression b) {
		if(a instanceof Variable && b instanceof Variable) {
			left = (Variable) a;
			Variable right = (Variable) b;
			left.value = right.value;
			left.hasValue = true;
		}
		
		if(a instanceof Variable && b instanceof Sum) {
			left = (Variable) a;
			right  = b;
		}
	}

	@Override
	public int eval() {
		return left.value;
	}

	@Override
	public Expression simplify() {
		left = (Variable) left.simplify();
		right = right.simplify();
		
		if(right.eval() == 0) {
			Sum sum = new Sum(left, right);
			return sum;
		}
			
			
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "(" + left.name + " = " + right + ")" ;
	}

}
