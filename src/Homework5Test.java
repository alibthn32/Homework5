
public class Homework5Test {

	public static void main(String[] args) {
		int size = 8;
		Board emptyBoard = new Board(size, size);
		System.out.println("Initial Board");
		System.out.println(emptyBoard);
		
		long startTime = System.nanoTime();
		NPuzzleRecursiveSolver puzzleSolver = new NPuzzleRecursiveSolver();
		Board solutionBoard = puzzleSolver.solve(emptyBoard); 
		long elapsedTime = System.nanoTime() - startTime;

		System.out.println("Found Solution");
		System.out.println(solutionBoard);
		
		System.out.println("Total execution time is " + (elapsedTime/1e6) + " milliseconds");
	}

}
