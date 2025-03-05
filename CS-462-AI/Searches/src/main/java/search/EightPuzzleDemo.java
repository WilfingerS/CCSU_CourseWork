package search;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;
import aima.core.environment.eightpuzzle.EightPuzzleGoalTest;
import aima.core.environment.eightpuzzle.ManhattanHeuristicFunction;
import aima.core.environment.eightpuzzle.MisplacedTilleHeuristicFunction;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.local.SimulatedAnnealingSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.search.uninformed.DepthFirstSearch;

/**
 * @author Ravi Mohan
 * 
 */

public class EightPuzzleDemo {
	// 3 IncludedMoves
	static EightPuzzleBoard threeMove = new EightPuzzleBoard(new int[] { 1, 2, 5, 3, 4, 0, 6, 7, 8 });
	static EightPuzzleBoard random1 = new EightPuzzleBoard(new int[] { 1, 4, 2, 7, 5, 8, 3, 0, 6 });
	static EightPuzzleBoard extreme = new EightPuzzleBoard(new int[] { 0, 8, 7, 6, 5, 4, 3, 2, 1 });
	// New Generated 7 Puzzles
	static EightPuzzleBoard newPuzzle1 = new EightPuzzleBoard(new int[] {0,2,4,6,8,1,3,5,7}); // Even -> Odd
	static EightPuzzleBoard newPuzzle2 = new EightPuzzleBoard(new int[] {0,1,3,5,7,2,4,6,8}); // Odd -> Even
	static EightPuzzleBoard newPuzzle3 = new EightPuzzleBoard(new int[] {8,7,6,5,4,3,2,1,0}); // Inverse counting order
	static EightPuzzleBoard newPuzzle4 = new EightPuzzleBoard(new int[] {3,0,6,5,8,7,4,2,1});
	static EightPuzzleBoard newPuzzle5 = new EightPuzzleBoard(new int[] {1,2,0,3,5,7,6,8,4});
	static EightPuzzleBoard newPuzzle6 = new EightPuzzleBoard(new int[] {7,5,6,4,0,2,1,8,3});
	static EightPuzzleBoard newPuzzle7 = new EightPuzzleBoard(new int[] {7,0,6,5,1,8,3,4,2});

	static EightPuzzleBoard testChoice = newPuzzle1;
	static EightPuzzleBoard[] tests = new EightPuzzleBoard[] {newPuzzle1,newPuzzle2,newPuzzle3,newPuzzle4,newPuzzle5,newPuzzle6,newPuzzle7};
	public static void main(String[] args) {
		for (int i = 0; i < tests.length; i++) {
			System.out.println("\n\nnewPuzzle"+(i+1)+"\n");
			eightPuzzleAStarDemo(tests[i]);
			eightPuzzleAStarManhattanDemo(tests[i]);
		}
		//eightPuzzleDLSDemo();
		//eightPuzzleIDLSDemo();
		//eightPuzzleGreedyBestFirstDemo();
		//eightPuzzleGreedyBestFirstManhattanDemo();
		//eightPuzzleAStarDemo();
		//eightPuzzleAStarManhattanDemo();
		//eightPuzzleSimulatedAnnealingDemo();
	}

	private static void eightPuzzleDLSDemo() {
		System.out.println("\nEightPuzzleDemo recursive DLS (31) -->");
		try {
			Problem problem = new Problem(testChoice, EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new DepthLimitedSearch(31);
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleIDLSDemo() {
		System.out.println("\nEightPuzzleDemo Iterative DLS -->");
		try {
			Problem problem = new Problem(testChoice, EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new IterativeDeepeningSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleGreedyBestFirstDemo() {
		System.out.println("\nEightPuzzleDemo Greedy Best First Search (MisplacedTileHeursitic)-->");
		try {
			Problem problem = new Problem(testChoice, EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new GreedyBestFirstSearch(new GraphSearch(),
					new MisplacedTilleHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleGreedyBestFirstManhattanDemo() {
		System.out.println("\nEightPuzzleDemo Greedy Best First Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(testChoice, EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new GreedyBestFirstSearch(new GraphSearch(), new ManhattanHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleAStarDemo(EightPuzzleBoard test) {
		System.out.println("\nEightPuzzleDemo AStar Search (MisplacedTileHeursitic)-->");
		try {
			Problem problem = new Problem(test, EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new AStarSearch(new GraphSearch(), new MisplacedTilleHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void eightPuzzleSimulatedAnnealingDemo() {
		System.out.println("\nEightPuzzleDemo Simulated Annealing  Search -->");
		try {
			Problem problem = new Problem(testChoice, EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(new ManhattanHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			System.out.println("Search Outcome=" + search.getOutcome());
			System.out.println("Final State=\n" + search.getLastSearchState());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void eightPuzzleAStarManhattanDemo(EightPuzzleBoard test) {
		System.out.println("\nEightPuzzleDemo AStar Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(test, EightPuzzleFunctionFactory.getActionsFunction(),
					EightPuzzleFunctionFactory.getResultFunction(), new EightPuzzleGoalTest());
			SearchForActions search = new AStarSearch(new GraphSearch(), new ManhattanHeuristicFunction());
			SearchAgent agent = new SearchAgent(problem, search);
			//printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}

}