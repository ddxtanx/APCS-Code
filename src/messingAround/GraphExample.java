package messingAround;

import java.util.ArrayList;

public class GraphExample {

    public static void main(String[] args) {
        Graph g = Graph.randomGraph(5);
        g.links();
        ArrayList<Vertex> vertices = g.getVertices();
        Vertex v5 = vertices.get(1);
        Vertex v6 = vertices.get(4);
        DijkstraCard distance = g.distance(v5, v6);
        System.out.println("The distance from " + v5 + " to " + v6 + " is " + distance.getDistance() + " path being " + distance.getPath());
        System.out.println(g.vote(v5));
    }
}
