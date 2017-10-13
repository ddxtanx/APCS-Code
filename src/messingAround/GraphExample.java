package messingAround;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GraphExample {

    public static void main(String[] args) {
        Graph g = Graph.readFromFile("graph.txt");
        g.links();
        System.out.println(g.getDistances());
        ArrayList<Vertex> vertices = g.getVertices();
        Vertex v5 = vertices.get(5);
        Vertex v6 = vertices.get(6);
        DijkstraCard distance = g.distance(v5, v6);
        System.out.println("The distance from " + v5 + " to " + v6 + " is " + distance.getDistance() + " path being " + distance.getPath());
    }
}
