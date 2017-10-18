package messingAroundTest;

import messingAround.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {
    @Test
    void getName() {
        Vertex v = new Vertex("asd");
        assertEquals("asd", v.getName());
    }

    @Test
    void addEdge() {
        Vertex v = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        v.addEdge(v2, 10);
        assertEquals(v2, v.getEdges().get(0).getTo(), "AddEdge adds incorrect edge");
        assertEquals(10, v2.getEdges().get(0).getWeight(), "AddEdge adds incorrect weight");
    }

    @Test
    void getEdge(){
        Vertex v = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        v4.addEdge(v, 20);
        v4.addEdge(v2, 10);
        v4.addEdge(v3, 1);
        v.addEdge(v2, 10);
        assertEquals(v.getEdges().get(1), v.getEdge(v2), "GetEdge returns incorrect edge");
        assertEquals(v4.getEdges().get(1), v4.getEdge(v2), "GetEdge returns incorrect edge");
    }

    @Test
    void removeEdge() {
        Vertex v = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v6");
        v.addEdge(v2, 10);
        Vertex[] removedVertices = v.removeEdge(v2);
        v = removedVertices[0];
        v2 = removedVertices[1];
        assertEquals(0, v.getEdges().size(), "Operand vertex");
        assertEquals(0, v2.getEdges().size());
    }

    @Test
    void getEdges() {
    }

    @Test
    void addEdge1() {
    }

    @Test
    void equals() {
    }

    @Test
    void toStringTest() {
    }

    @Test
    void cloneTest() {
    }

}