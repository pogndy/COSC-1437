package Lab5;

import java.util.ArrayList;

public class Sqr {

    int x, y;
    int cost;

    boolean isStart;
    boolean isEnd;
    boolean isBlank;
    ArrayList<Sqr> neighbors = new ArrayList<>();

    ArrayList<Sqr> pathToGetTo;

    public Sqr(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }

    public Sqr(int y, int x, boolean isBlank) {
        this.y = y;
        this.x = x;
        this.isBlank = isBlank;
        cost = Integer.MAX_VALUE;
    }

    public static int getPathToCost(ArrayList<Sqr> path) {
        int costToGetTo = 0;
        for (Sqr s : path)
            costToGetTo += s.cost;
        return costToGetTo;
    }

    public String toString() {
        return "Sqr(" + y + "," + x + ")";
    }

    public void setNeighbors(Sqr[][] sqrs) {
        if (y > 0 && !sqrs[y - 1][x].isBlank)
            neighbors.add(sqrs[y - 1][x]);
        if (y + 1 < sqrs.length && !sqrs[y + 1][x].isBlank)
            neighbors.add(sqrs[y + 1][x]);
        if (x > 0 && !sqrs[y][x - 1].isBlank)
            neighbors.add(sqrs[y][x - 1]);
        if (x + 1 < sqrs[y].length && !sqrs[y][x + 1].isBlank)
            neighbors.add(sqrs[y][x + 1]);
    }

    public void drawTop() {
        if (isBlank)
            System.out.print("     ");
        else
            System.out.print("|‾‾‾|");
    }

    public void drawBottom() {
        if (isBlank)
            System.out.print("     ");
        else if (isStart)
            System.out.print("|_S_|");
        else if (isEnd)
            System.out.print("|_E_|");
        else
            System.out.print("|___|");
    }
}
