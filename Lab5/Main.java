package Lab5;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        FileParser reader = new FileParser("squares.txt");
        ArrayList<ShippingNode> nodes = reader.readFile();

        // Todo - comes from cargo class
        String startName = "Abaca";
        ShippingNode start = ShippingNode.getNodeByName(nodes, startName);
        start.setTime(0);

        String endName = "Chiano";
        ShippingNode end = ShippingNode.getNodeByName(nodes, endName);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle(VehicleType.fromString("road"));
        vehicle.setCurrentNode(end);
        vehicles.add(vehicle);

        var path = PathFinder.findPath(start, end, vehicles);

        for (ShippingNode node : path.getNodes()) {
            System.out.println(node.getName());
        }
    }
}
