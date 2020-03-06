package recursion;
import list.*;

public class Board {
	//list of positions that are occupied by a queen
	List<Position> queens = new LinkedList<Position>();
	
	public Board() {}
	
	//Copy constructor
	public Board(Board b) {
		queens = new LinkedList<Position>(b.queens);
	}

	/**
	 * Add a Queen at position p on this board
	 * @param p
	 */
	public void addQueen(Position p) {
		queens.add(p);
	}
	
	/**
	 * 
	 * @return true of no two queens are attacking each other on this board
	 */
	public boolean ok() {
		Position p, other;
		Iterator<Position> itty1 = queens.iterator();
		Iterator<Position> itty2;
		
		while(itty1.hasNext()) {
			p = itty1.next();
			itty2 = queens.iterator();
			while(itty2.hasNext()) {
				other = itty2.next();
				if(!(p.equals(other)) && p.isAttacking(other))	//making sure not attacking self
					return false;
			}
		}
		return true;
	}
	
	public String toString() {
		String result = "";
		for(int row = 0; row < EightQueens.size; row++) {
			for(int col = 0; col < EightQueens.size; col++){
				if(queens.contains(new Position(row,col)))
					result += "Q ";
				else
					result += ". ";
			}
			result += "\n";
		}
		return result;
	}
}
