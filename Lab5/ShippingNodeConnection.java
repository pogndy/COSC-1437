package Lab5;

public class ShippingNodeConnection {

    private ShippingNode firstNode;
    private ShippingNode secondNode;
    private int cost;

    public ShippingNodeConnection(ShippingNode firstNode, ShippingNode secondNode, int cost) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.cost = cost;
    }

    public ShippingNode getNodeConnection(ShippingNode node) {
        if (node.equals(firstNode)) {
            return secondNode;
        } else {
            return firstNode;
        }
    }

    public boolean connectionExists(ShippingNodeConnection connection) {
        boolean firstNodeFound = false;
        boolean secondNodeFound = false;
        if (connection.firstNode.equals(this.firstNode) || connection.firstNode.equals(this.secondNode)) {
            firstNodeFound = true;
        }
        if (connection.secondNode.equals(this.firstNode) || connection.secondNode.equals(this.secondNode)) {
            secondNodeFound = true;
        }
        return firstNodeFound && secondNodeFound;
    }

    public int getConnectionCost() {
        return cost;
    }

}
