package Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private String fileName;

    public FileReader(String filename) {
        this.fileName = filename;
    }

    public ArrayList<ShippingNode> readFile() throws FileNotFoundException {
        ArrayList<ShippingNode> nodes = new ArrayList<>();

        Scanner s = new Scanner(new File(fileName));
        int lineNumber = 0;
        while (s.hasNextLine()) {
            // Todo -
            // 1. Load the first node from the line into memory
            // 2. Check if the node exists in the list?
            // 3. If the node doesn't exist, add to list
            // 4. Load the second node form the line into memory
            // 5. Check if the node exists in the list?
            // 6. If the node doesn't exist, add it to the list
            // 7. Run the Connect Neighbors method for one of the nodes with the other as an
            // argument
            // 8. Connect neighbors is bidirectional, you only need to run it once for two
            // nodes and it will connnect both ways
            // Todo - establish each connection
            lineNumber++;
        }
        return nodes;
    }

}
