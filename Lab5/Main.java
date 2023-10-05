package Lab5;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("squares.txt");
        Sqr[][] squares = reader.readFile(new Sqr[6][7]);
        squares[0][0].isStart = true;
        squares[3][6].isEnd = true;
        PathFinder.setNeighbors(squares);
        PathFinder.drawSquares(squares);
        System.out.println(PathFinder.findPath(squares[0][0], squares[3][6]));
    }
}
