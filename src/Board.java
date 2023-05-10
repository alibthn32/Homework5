import java.util.Arrays;

public class Board {
	public final int width;
	public final int height;
	private final int[] queens;
	private static final int NoQueen = -1;
	
	Board(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.queens = new int[width];
		Arrays.fill(queens, NoQueen);
	}
	
	Board(Board board) {
		this.width = board.width;
		this.height = board.height;
		this.queens = board.queens.clone();
	}
	
	final public boolean isInsideBoard(int x, int y) {
		return (x >= 0 && x < width && y >= 0 && y < height);
	}
	
	public boolean addQueen(int x, int y) {
		if (isInsideBoard(x, y)) {
			queens[x] = y;
			
			return true;
		}
		else
			return false;
	}
	
	public void removeQueen(int x) {
		if (x >= 0 && x < width) {
			queens[x] = NoQueen;			
		}
	}
	
	public Integer getFirstEmptyColumn() {
		for (int x=0; x<width; x++) {
			if (queens[x] == NoQueen) {
				return x;
			}
		}		
		
		return null; 
	}
	
	public boolean isFull() {
		for (int x=0; x<width; x++) {
			if (queens[x] == NoQueen) {
				return false;
			}
		}		
		
		return true; 
	}	

	public boolean hasQueen(int x) {
		return (x >= 0 && x < width && queens[x] >= 0 && queens[x] < height);
	}
	
	public boolean isQueen(int x, int y) {
		return (x >= 0 && x < width && queens[x] == y);
	}
	
	private boolean checkAttackInDirection(int x, int y, int delta_x, int delta_y) {
		int xp = x + delta_x;
		int yp = y + delta_y;
		
		while (isInsideBoard(xp, yp)) {
			if (isQueen(xp, yp)) {
				return true;
			}

			xp += delta_x;
			yp += delta_y;
		}
		
		return false;
	}
	
	public boolean canAttackOtherQueens(int x, int y) {
		// no need to check same column x
		// since there is single queen in each column (see Lecture Video on recursion)
		
		// check the row y
		if (checkAttackInDirection(x, y, +1, 0)) return true;
		if (checkAttackInDirection(x, y, -1, 0)) return true;
		
		// check diagonals
		if (checkAttackInDirection(x, y, +1, +1)) return true;
		if (checkAttackInDirection(x, y, +1, -1)) return true;
		if (checkAttackInDirection(x, y, -1, +1)) return true;
		if (checkAttackInDirection(x, y, -1, -1)) return true;
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int y=0; y<height; y++) {
			for (int x=0; x<width; x++) {
				if (queens[x] == y) 
					sb.append('Q');
				else
					sb.append('.');
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}	
}
