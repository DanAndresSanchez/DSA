package recursion;

public class Position {
	int row, col;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * @return true only if this position has the same row and col numbers as the
	 *         given posisition
	 */
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return row == other.row && col == other.col;
	}

	public String toString() {
		return "(" + row + "," + col + ")";
	}

	/**
	 * 
	 * @param other
	 * @return true iff a Queen in this position is attacking a Queen in the other position
	 */
	public boolean isAttacking(Position other) {
		return row == other.row ||
			   col == other.col || 
			   row+col == other.row + other.col ||	//same major diagonal
			   row-col == other.row-other.col;		//same minor diagonal
	}
}
