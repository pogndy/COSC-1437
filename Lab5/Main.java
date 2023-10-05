package Lab5;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("squares.txt");
        Sqr[][] squares = reader.readFile(new Sqr[6][7]);

        var start = squares[0][0];
        start.isStart = true;
        var end = squares[3][6];
        end.isEnd = true;

        PathFinder pathFinder = new PathFinder(squares);
        pathFinder.setNeighbors();
        pathFinder.drawSquares();
        System.out.println(pathFinder.findPath(start, end));
    }
}
