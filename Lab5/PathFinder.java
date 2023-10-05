package Lab5;

import java.util.ArrayList;
import java.util.Arrays;

public class PathFinder {
	// main list of squares, owned by aggregation in path finder class
	private Sqr[][] squares;

	// constructor of Pathfinder class. Potentially will need a deep copy here
	// depending on behavior of main method. It's important that the vehicles
	// stay in the ending position after each peice of cargo moves through the
	// network
	public PathFinder(Sqr[][] squares) {
		this.squares = squares;
	}

	public ArrayList<Sqr> findPath(Sqr start, Sqr end) {
		// path tracks the best path as each square is tested
		ArrayList<Sqr> path = null;
		// open tracks the squares that haven't been closed yet.
		ArrayList<Sqr> open = new ArrayList<Sqr>();
		// close tracks the squares we have already examined.
		ArrayList<Sqr> closed = new ArrayList<Sqr>();
		// add the first node to the open list prior to beginning
		open.add(start);
		// initialize the path to get to for the initial square, as this square has
		// never been visited before.
		start.pathToGetTo = new ArrayList<Sqr>(Arrays.asList(start));
		// loop while the open list has squares on it.
		while (!open.isEmpty()) {
			// Get the first item from open list and set as current
			Sqr current = open.get(0);
			// Remove the first item from the open list (we will add it to closed at the
			// end)
			open.remove(0);
			// output the current x and y value of the square we are looking at to the
			// console
			System.out.println("Current: " + current.y + ", " + current.x);
			// Check if we are at the end
			if (current.isEnd) {
				// It we are at the end, output the path cost
				System.out.println("Found path: " + Sqr.getPathToCost(current.pathToGetTo));
				// If we are at the end set the path variable if it hasn't been set
				if (path == null)
					path = current.pathToGetTo;
				// Error handling, we check the current path if it already exists and compare it
				// to the path to get to of the current square, then adjust the path
				else if (Sqr.getPathToCost(path) > Sqr.getPathToCost(current.pathToGetTo))
					path = current.pathToGetTo;
			}
			// if we aren't at the end place the current square on the closed list.
			if (!current.isEnd) {
				closed.add(current);
			}

			// get all the adjacent squares and iterate over them.
			ArrayList<Sqr> adj = current.neighbors;
			for (Sqr s : adj) {
				// if the suqare isn't on the closed list AND hasn't been added to the open list
				if (!closed.contains(s) && !open.contains(s)) {
					// deep copy the path to get to of the current square
					ArrayList<Sqr> copy = new ArrayList<Sqr>(current.pathToGetTo);
					// add"s", the adjecent square to the list
					copy.add(s);
					// set s's path to copy (so it knows how to reach itself)
					s.pathToGetTo = copy;
					// add the modified adjacent square to the open list
					open.add(s);
				} else {
					// if the square is on the closed list, deep copy the path to get to of the
					// current square
					ArrayList<Sqr> copy = new ArrayList<Sqr>(current.pathToGetTo);
					// add"s", the adjecent square to the list
					copy.add(s);
					// check if you have found a better path to s
					if (Sqr.getPathToCost(s.pathToGetTo) > Sqr.getPathToCost(copy)) {
						s.pathToGetTo = copy;
						// remove s from closed list and re-add it to open list, since we now have a
						// better path and we need to test it
						closed.remove(s);
						open.add(s);
					}
				}
			}
		}
		return path;
	}

	public void setNeighbors() {
		// This method iterates over all of the squares and calls the square's
		// setNeighbors method,
		// the square finds it's immediate neighbors and stores them in it's own list so
		// it know who it's neighbors are
		for (int r = 0; r < squares.length; r++)
			for (int c = 0; c < squares[r].length; c++)
				squares[r][c].setNeighbors(squares);
	}

	public void drawSquares() {
		// iterate over all the squares and print them to the console so you
		// can see the network visually on the screen.
		for (int r = 0; r < squares.length; r++) {
			// top row for squares
			for (int c = 0; c < squares[r].length; c++)
				squares[r][c].drawTop();
			System.out.println();
			// bottom row
			for (int c = 0; c < squares[r].length; c++)
				squares[r][c].drawBottom();
			System.out.println();
		}
	}

}
