package Lab5;

import java.util.ArrayList;
import java.util.Arrays;

public class PathFinder {
	public static ArrayList<ShippingNode> findPath(ShippingNode start, ShippingNode end) {
		ArrayList<ShippingNode> path = null;
		// open tracks the squares that haven't been closed yet.
		ArrayList<ShippingNode> open = new ArrayList<ShippingNode>();
		// close tracks the squares we have already examined.
		ArrayList<ShippingNode> closed = new ArrayList<ShippingNode>();
		// add the first node to the open list prior to beginning
		open.add(start);
		// initialize the path to get to for the initial square, as this square has
		// never been visited before.
		start.pathToGetTo = new ArrayList<ShippingNode>(Arrays.asList(start));
		// loop while the open list has squares on it.
		while (!open.isEmpty()) {
			// Get the first item from open list and set as current
			ShippingNode current = open.get(0);
			// Remove the first item from the open list (we will add it to closed at the
			// end)
			open.remove(0);
			// Check if we are at the end
			if (current.isEnd) {
				// It we are at the end, output the path cost
				System.out.println("Found path: " + ShippingNode.getPathToCost(current.pathToGetTo));
				// If we are at the end set the path variable if it hasn't been set
				if (path == null)
					path = current.pathToGetTo;
				// Error handling, we check the current path if it already exists and compare it
				// to the path to get to of the current square, then adjust the path
				else if (ShippingNode.getPathToCost(path) > ShippingNode.getPathToCost(current.pathToGetTo))
					path = current.pathToGetTo;
			}
			// if we aren't at the end place the current square on the closed list.
			if (!current.isEnd) {
				closed.add(current);
			}

			// get all the adjacent squares and iterate over them.
			ArrayList<ShippingNodeConnection> neighborConnections = current.neighbors;
			for (ShippingNodeConnection connection : neighborConnections) {
				// if the suqare isn't on the closed list AND hasn't been added to the open list
				ShippingNode neighborNode = connection.getNodeConnection(current);
				if (!closed.contains(neighborNode) && !open.contains(neighborNode)) {
					// deep copy the path to get to of the current square
					ArrayList<ShippingNode> pathtoCurrent = new ArrayList<>(current.pathToGetTo);
					// add"s", the adjecent square to the list
					pathtoCurrent.add(neighborNode);
					// set s's path to copy (so it knows how to reach itself)
					neighborNode.pathToGetTo = pathtoCurrent;

					// add the modified adjacent square to the open list
					open.add(neighborNode);
				} else {
					// if the square is on the closed list, deep copy the path to get the
					// current square
					ArrayList<ShippingNode> pathtoCurrent = new ArrayList<ShippingNode>(current.pathToGetTo);
					// add"s", the adjecent square to the list
					pathtoCurrent.add(neighborNode);
					// check if you have found a better path to s
					if (ShippingNode.getPathToCost(neighborNode.pathToGetTo) > ShippingNode
							.getPathToCost(pathtoCurrent)) {
						neighborNode.pathToGetTo = pathtoCurrent;
						// remove s from closed list and re-add it to open list, since we now have a
						// better path and we need to test it
						closed.remove(neighborNode);
						open.add(neighborNode);
					}
				}
			}
		}
		return path;
	}
}
