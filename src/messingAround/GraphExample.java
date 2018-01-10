package messingAround;

import java.io.IOException;
import java.util.ArrayList;

public class GraphExample {

    public static void main(String[] args) {
        int vertices = 11;
        Graph g = Graph.random(vertices, 2*vertices);
        g.links();
        ArrayList<Vertex> verticesList = g.getVertices();
        Vertex v1 = verticesList.get(0);
        Vertex v2 = verticesList.get(7);
        DijkstraCard distance = g.distance(v1, v2);
        System.out.println("The distance from " + v1 + " to " + v2 + " is " + distance.getDistance() + " path being " + distance.getPath());
        System.out.println(g.getDistances());
        System.out.println(g.vote(v1));
        System.out.println(g.isEulerPathable(v1));
        DijkstraCard shortestPath = g.shortestPath(v1);
        System.out.println(shortestPath.getDistance());
        System.out.println(shortestPath.getPath());
    }
}
