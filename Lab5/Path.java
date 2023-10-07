package Lab5;

import java.util.ArrayList;

public class Path {
    private ArrayList<ShippingNode> nodesInPath;
    private int cumulativeCost;
    private int cumulativeTime;

    public Path() {
        nodesInPath = new ArrayList<>();
    }

    public ArrayList<ShippingNode> getNodes() {
        return nodesInPath;
    }

    public int getCumulativeCost() {
        return cumulativeCost;
    }

    public void setCumulativeCost(int cost) {
        this.cumulativeCost = cost;
    }

    public int getCumulativeTime() {
        return cumulativeTime;
    }

    public void setCumulativeTime(int time) {
        this.cumulativeTime = time;
    }

    public void addNodeToPath(ShippingNode node, int cost, int time) {
        this.nodesInPath.add(node);
        this.cumulativeCost += cost;
        this.cumulativeTime += time;
    }

    public Path copy() {
        Path newPath = new Path();
        for (ShippingNode node : this.nodesInPath) {
            newPath.getNodes().add(node);
        }
        newPath.setCumulativeTime(this.getCumulativeTime());
        newPath.setCumulativeCost(this.getCumulativeCost());
        return newPath;
    }

}
