package Lab5;

import java.util.ArrayList;

public class ShippingNode {

    String name;
    ArrayList<ShippingNodeConnection> neighbors = new ArrayList<>();

    int cost;

    boolean isStart;
    boolean isEnd;

    ArrayList<ShippingNode> pathToGetTo;

    public ShippingNode(String name) {
        // Todo - consider how cost is calculated
        this.name = name;
        this.cost = 1;
    }

    public void connectNeighbors(int id, ShippingNode neighborNode, int cost, int time, String type) {
        connectNeighbors(id, neighborNode, cost, time, type, true);
    }

    private void connectNeighbors(int id, ShippingNode neighborNode, int cost, int time, String type,
            boolean establishBiDirectionalConnection) {
        boolean connectionAlreadyExists = false;

        ShippingNodeConnection newConnection = new ShippingNodeConnection(id, this, neighborNode, cost, time, type);
        // check if the new connection exists already
        for (ShippingNodeConnection connection : neighbors) {
            if (connection.connectionExists(newConnection)) {
                connectionAlreadyExists = true;
                break;
            }
        }

        if (!connectionAlreadyExists) {
            neighbors.add(newConnection);
        }

        if (establishBiDirectionalConnection) {
            neighborNode.connectNeighbors(id, this, cost, time, type, false);
        }

    }

    public static int getPathToCost(ArrayList<ShippingNode> path) {
        int costToGetTo = 0;
        for (ShippingNode s : path)
            costToGetTo += s.cost;
        return costToGetTo;
    }
}
