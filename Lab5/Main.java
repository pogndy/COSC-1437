package Lab5;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("squares.txt");
        ArrayList<ShippingNode> nodes = reader.readFile();

        // Todo - Flesh out this code, it will come from the file and need to be passed
        // out of the readfile class.
        // We will get to that. For now, will manually add the start and end nodes when
        // testing code.
        ShippingNode start = new ShippingNode("someNode");
        start.isStart = true;
        ShippingNode end = new ShippingNode("someOtherNode");
        end.isEnd = true;

        PathFinder.findPath(start, end);

    }
}
