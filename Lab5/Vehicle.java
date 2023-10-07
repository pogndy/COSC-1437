package Lab5;

import java.util.ArrayList;

public class Vehicle {

    private VehicleType type;
    private ShippingNode currentNode;
    private boolean isAvailable;

    public Vehicle(VehicleType vehicleType) {
        this.type = vehicleType;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setCurrentNode(ShippingNode nextNode) {
        this.currentNode = nextNode;
    }

    public boolean canTraverse(ShippingNodeConnection connection) {
        VehicleType connectionType = connection.getType();
        return (connectionType.getType() == type.getType());
    }

    public int getTimeToNode(ShippingNode target) {
        Path pathToTarget = PathFinder.findPathWithVehicle(this.currentNode, target, this);
        if (pathToTarget != null) {
            return pathToTarget.getCumulativeTime();
        } else {
            return Integer.MAX_VALUE; // Return a large value to represent inaccessibility.
        }
    }
}