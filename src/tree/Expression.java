package tree;

/**
 * An expression of ints may have left and right children, each of which is an expression
 * @author Dan Sanchez
 *
 */
public abstract class Expression {
	Expression left,right;
	
	/**
	 * @return the value of this expression
	 */
	public abstract int eval();
	
	/**
	 * @return a simplified version of this expression 
	 */
	public abstract Expression simplify();
	
	/**
	 * @return true if and only this expression equals obj
	 */
	public abstract boolean equals(Object obj);
	
	/**
	 * @return this expression as a String
	 */
	public abstract String toString();
}
