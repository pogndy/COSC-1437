package Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Simplified example to show how to chain method calls to "discover" useful info
public class PathFinder {

	public static ArrayList<Sqr> findPath(Sqr start, Sqr end) {
		ArrayList<Sqr> path = null;
		ArrayList<Sqr> open = new ArrayList<Sqr>();
		ArrayList<Sqr> closed = new ArrayList<Sqr>();
		open.add(start);
		start.pathToGetTo = new ArrayList<Sqr>(Arrays.asList(start));
		while (!open.isEmpty()) {
			Sqr current = open.get(0);
			open.remove(0);
			System.out.println("Current: " + current.y + ", " + current.x);
			if (current.isEnd) {
				System.out.println("Found path: " + Sqr.getPathToCost(current.pathToGetTo));
				if (path == null)
					path = current.pathToGetTo;
				else if (Sqr.getPathToCost(path) > Sqr.getPathToCost(current.pathToGetTo))
					path = current.pathToGetTo;
			}
			if (!current.isEnd)
				closed.add(current);

			ArrayList<Sqr> adj = current.neighbors;
			for (Sqr s : adj) {
				if (!closed.contains(s) && !open.contains(s)) // this should check if the current path is better or
																// worse
				{
					ArrayList<Sqr> copy = new ArrayList<Sqr>(current.pathToGetTo); // deep copy
					copy.add(s);
					s.pathToGetTo = copy;
					open.add(s);
				} else // if they are on the closed list but the new path to get there is better then
						// set that as the pathtoget there and add them back to the open list
				{
					ArrayList<Sqr> copy = new ArrayList<Sqr>(current.pathToGetTo); // deep copy
					copy.add(s);
					if (Sqr.getPathToCost(s.pathToGetTo) > Sqr.getPathToCost(copy)) {
						s.pathToGetTo = copy;
						closed.remove(s);
						open.add(s);
					}
				}
			}
		}

		return path;

	}

	public static void setNeighbors(Sqr squares[][]) {
		for (int r = 0; r < squares.length; r++)
			for (int c = 0; c < squares[r].length; c++)
				squares[r][c].setNeighbors(squares);
	}

	public static void drawSquares(Sqr squares[][]) {
		for (int r = 0; r < squares.length; r++) {
			// top row for squares
			for (int c = 0; c < squares[r].length; c++)
				squares[r][c].drawTop();
			System.out.println();
			// bottom row
			for (int c = 0; c < squares[r].length; c++)
				squares[r][c].drawBottom();
			System.out.println();
			// note that you can have as many rows per square/node/space or whatever you
			// want
		}
	}

}
