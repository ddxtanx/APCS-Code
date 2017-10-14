package messingAround;

import java.util.ArrayList;

public class GraphExample {

    public static void main(String[] args) {
        int vertices = 7;
        Graph g = Graph.readFromFile("graph.txt");
        g.links();
        ArrayList<Vertex> verticesList = g.getVertices();
        Vertex v1 = verticesList.get(1);
        Vertex v2 = verticesList.get(4);
        DijkstraCard distance = g.distance(v1, v2);
        System.out.println("The distance from " + v1 + " to " + v2 + " is " + distance.getDistance() + " path being " + distance.getPath());
        System.out.println(g.getDistances());
        System.out.println(g.vote(v1));
        System.out.println(g.isEulerPathable(v1));
        System.out.println(g.shortestPath(v1).getPath());
        System.out.println(g.shortestPath(v1).getDistance());
    }
}
