package Lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileParser {
    private String filename;

    public FileParser(String filename) {
        this.filename = filename;
    }

    public ArrayList<ShippingNode> readFile() throws FileNotFoundException {
        // Hashmap for easy membership check and computeIfAbsent method
        Map<String, ShippingNode> nodeMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                int id = Integer.parseInt(parts[0]);
                String start = parts[1];
                String end = parts[2];
                int cost = Integer.parseInt(parts[3]);
                int time = Integer.parseInt(parts[4]);
                VehicleType type = VehicleType.fromString(parts[5]);

                // Create the nodes if they don't already exist
                ShippingNode fromNode = nodeMap.computeIfAbsent(start, name -> new ShippingNode(name));
                ShippingNode toNode = nodeMap.computeIfAbsent(end, name -> new ShippingNode(name));

                ShippingNode.connectNeighbors(id, fromNode, toNode, cost, time, type);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading file", e);
        }

        return new ArrayList<>(nodeMap.values());
    }

}
