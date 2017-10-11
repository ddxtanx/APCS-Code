package messingAround;

import java.util.ArrayList;

public class GraphExample {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Edge e1 = new Edge(v1, v2, 1);
        Edge e2 = new Edge(v2, v3, 2);
        Edge e3 = new Edge(v1, v3, 4);
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph(vertices);
        g.links();
    }
}
