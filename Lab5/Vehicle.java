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

    public Vehicle findNearestEligibleVehicle(ShippingNode startNode, ArrayList<Vehicle> vehicles,
            VehicleType vehicleType) {
        Vehicle closestVehicle = null;
        int shortestTime = Integer.MAX_VALUE;

        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isAvailable() || vehicle.type != vehicleType)
                continue;

            Path pathToStartNode = PathFinder.findPath(vehicle.currentNode, startNode);
            int time = pathToStartNode.getCumulativeTime();

            if (time < shortestTime) {
                closestVehicle = vehicle;
                shortestTime = time;
            }
        }

        return closestVehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setCurrentNode(ShippingNode nextNode) {
        this.currentNode = nextNode;
    }

}