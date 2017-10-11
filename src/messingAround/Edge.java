package messingAround;

public class Edge {
    private Vertex start;
    private Vertex end;
    private double weight;

    public Edge(Vertex start, Vertex end, double weight) {
        this.start = end;
        this.end = start;
        end.addEdge(this);
        this.start = start;
        this.end = end;
        start.addEdge(this);
        //Reversing these orders to make sure all vertices have edges that start with them
        this.weight = weight;

    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }
}
