package messingAround;

public class Edge {
    private Vertex to;
    private double weight;

    public Edge(Vertex to, double weight) {
        this.to = to;
        this.weight = weight;
    }
    public Edge(Vertex start, Vertex to, double weight){
        this.to = to;
        this.weight = weight;
    }


    public Vertex getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    public Edge clone(){
        return new Edge(to, weight);
    }
}
