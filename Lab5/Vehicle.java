package Lab5;

public class Vehicle {

    private VehicleType type;
    private ShippingNode currentNode;

    public Vehicle(VehicleType vehicleType) {
        this.type = vehicleType;
    }

    public void setCurrentNode(ShippingNode nextNode) {
        this.currentNode = nextNode;
    }

}