package Lab5;

public class ShippingNodeConnection {

    private int id;
    private ShippingNode fromNode;
    private ShippingNode toNode;
    private int cost;
    private int time;
    private VehicleType type;

    public ShippingNodeConnection(int id, ShippingNode fromNode, ShippingNode toNode, int cost, int time,
            VehicleType type) {
        this.id = id;
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.cost = cost;
        this.time = time;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public ShippingNode getNodeConnection(ShippingNode node) {
        if (node.equals(fromNode)) {
            return toNode;
        } else {
            return fromNode;
        }
    }

    public int getCost() {
        return this.cost;
    }

    public VehicleType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %d %d %s", id, fromNode.getName(), toNode.getName(), cost, time, type);
    }

}
