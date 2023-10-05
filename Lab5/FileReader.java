package Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private String fileName;

    public FileReader(String filename) {
        this.fileName = filename;
    }

    public Sqr[][] readFile(Sqr squares[][]) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileName));
        int lineNumber = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != '0')
                    squares[lineNumber][i] = new Sqr(lineNumber, i, line.charAt(i) - '0');
                else
                    squares[lineNumber][i] = new Sqr(lineNumber, i, true);
            }
            lineNumber++;
        }
        return squares;
    }

}
