package messingAround;

public class Edge {
    private Vertex to;
    private double weight;

    public Edge(Vertex to, double weight) {
        this.to = to;
        this.weight = weight;
    }

    public Edge(){
        this.to = new Vertex("");
        this.weight = 0;
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
    
    @Override
    public String toString(){
        return "To " + to + " with distance: " + weight;
    }
//    TODO: Fix equality; as it stands, even if an edge starts at 2 different vertices, but ends at the same vertex with the same weight, it will return true.
    @Override
    public boolean equals(Object e){
        if(!(e instanceof Edge)){
            return false;
        }

        Edge ed = (Edge) e;
        return ed.getTo().equals(to);
    }

    public void setTo(Vertex to){
        this.to = to;
    }
}
