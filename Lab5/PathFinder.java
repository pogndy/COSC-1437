package Lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Slightly altered algorithm to use Dijkstra instead of A*
// Did this because A* is better suited to coordinate plane problems or problems
// where the individual peices are spatially related. Becuase the sites aren't
// clearly spatially related, this problem lends itself to graph traversal.
// With A* I was continually fighting the code to make it not
// exit prematurely.
public class PathFinder {
	public static ArrayList<ShippingNode> findPath(ShippingNode start, ShippingNode end) {
		ArrayList<ShippingNode> open = new ArrayList<ShippingNode>();
		ArrayList<ShippingNode> closed = new ArrayList<ShippingNode>();

		start.setPath(new ArrayList<>(Arrays.asList(start)));
		open.add(start);

		while (!open.isEmpty()) {
			// Get the most promising node from the list
			ShippingNode current = open.stream().min(Comparator.comparingInt(node -> node.getCost())).orElse(null);

			open.remove(current);

			if (current.equals(end)) {
				break;
			}

			ArrayList<ShippingNodeConnection> neighborConnections = current.getNeighbors();
			for (ShippingNodeConnection connection : neighborConnections) {
				// Find the cost of the connection to the neighbor
				ShippingNode neighborNode = connection.getNodeConnection(current);
				int tentativeCost = current.getCost() + connection.getCost();

				if (closed.contains(neighborNode)) {
					continue;
				}

				if (!open.contains(neighborNode) || tentativeCost < neighborNode.getCost()) {
					// Set path and cost for connection to neighbor if we have
					// found a better path
					ArrayList<ShippingNode> pathtoCurrent = new ArrayList<>(current.getPath());
					pathtoCurrent.add(neighborNode);
					neighborNode.setPath(pathtoCurrent);
					neighborNode.setCost(tentativeCost);
					// Add to open list if we haven't visited this node
					if (!open.contains(neighborNode)) {
						open.add(neighborNode);
					}

				}
			}
		}
		System.out.println("End Node cost is " + end.getCost());
		return end.getPath() != null ? end.getPath() : null;
	}
}
