package messingAround;

import java.util.ArrayList;

public class GraphExample {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        v1.addEdge(v2, 1);
        v2.addEdge(v3, 2);
        v1.addEdge(v3, 4);
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        Graph g = new Graph(vertices);
        g.links();
        System.out.println("___---___---___");
        Vertex v4 = new Vertex("v4");
        v4.addEdge(v1, 50);
        g.addVertex(v4);
        g.links();
        Vertex v5 = new Vertex("v5");
        DijkstraCard c = new DijkstraCard(v1, v2, 0);
        System.out.println(g.distance(v1, v2));
    }
}
