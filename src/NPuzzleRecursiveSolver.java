
public class NPuzzleRecursiveSolver {
	protected Board solutionBoard;
	
	Board solve(Board board) {
		initializeSearch();
		
		searchSolution(new Board(board));
		
		return solutionBoard;
	}
	
	void initializeSearch() {
		solutionBoard = null;
	}
	
	private void searchSolution(Board boardConfiguration) {
		// student code
	}

}
