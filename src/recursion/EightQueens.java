package recursion;

public class EightQueens {
	public static final int size = 8;
	
	public static void main(String[] args) {
		EightQueens game = new EightQueens();
		System.out.println(game.placeQueens(0, new Board()));
	}
	
	/**
	 * Pre: Queens have been safely placed on Board B in cols 0...cols -1
	 * @return Board on which Queens have been safely placed in all columns
	 * 		   or null if not possible
	 */
	private Board placeQueens(int col, Board b) {
		Position p;
		Board result;
		for(int row = 0; row < size; row++) {
			p = new Position(row, col);
			result = new Board(b);		//copy constructor
			result.addQueen(p);
			System.out.println(result.toString());
			System.out.println("---------------");
			if(result.ok())
				if(!(col == size - 1)) {	//we are not in last column
					result = placeQueens(col + 1, result);
					if(result != null)
						return result;
				}
				else
					return result;
		}
		return null;
	}
}
