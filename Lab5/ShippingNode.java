package Lab5;

import java.util.ArrayList;
import java.util.Objects;

public class ShippingNode {
    private String name;
    private int cost;
    private ArrayList<ShippingNode> pathToGetTo;
    private ArrayList<ShippingNodeConnection> neighbors = new ArrayList<>();

    public ShippingNode(String name) {
        this.name = name;
        this.cost = Integer.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<ShippingNode> getPath() {
        return this.pathToGetTo;
    }

    public void setPath(ArrayList<ShippingNode> path) {
        this.pathToGetTo = path;
    }

    public ArrayList<ShippingNodeConnection> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<ShippingNodeConnection> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(ShippingNodeConnection connection) {
        this.neighbors.add(connection);
    }

    public static ShippingNode getNodeByName(ArrayList<ShippingNode> nodes, String name) {
        return nodes.stream()
                .filter(node -> name.equals(node.getName()))
                .findFirst()
                .orElse(null);
    }

    public static void connectNeighbors(int id, ShippingNode fromNode, ShippingNode toNode, int cost, int time,
            VehicleType type) {
        ShippingNodeConnection newConnection = new ShippingNodeConnection(id, fromNode, toNode, cost, time, type);
        fromNode.addNeighbor(newConnection);
    }

    // Override to allow a comparison of nodes based on names using List.contains()
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ShippingNode otherNode = (ShippingNode) obj;
        return name.equals(otherNode.name);
    }

    // Override for consistancy to match equals override, so hash comparison output
    // matches List.contains();
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
