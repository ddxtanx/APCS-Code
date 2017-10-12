package messingAround;

import java.util.ArrayList;

public class Vertex {
    private String name;
    private ArrayList<Edge> edges = new ArrayList<>();
    public Vertex(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public ArrayList<Edge> getEdges(){
        return edges;
    }

    public Vertex traverseEdge(int index){
        if(index<0 || index>=edges.size()){
            throw new IllegalArgumentException("You cannot traverse to a vertex that does not exist!");
        }
        return edges.get(index).getTo();
    }

    public Edge addEdge(Vertex v2, double weight){
        Edge e = new Edge(v2, weight);
        edges.add(e);
        v2.addEdge(new Edge(this, weight));
        return e.clone();
    }
    @Override
    public boolean equals(Object e){
        if(!(e instanceof Vertex)){
            return false;
        }
        Vertex v = (Vertex) e;

        return (v.getName().equals(name) && v.getEdges().equals(edges));
    }

    public ArrayList<Vertex> getNeighbors(){
        ArrayList<Vertex> neighbors = new ArrayList<>();
        for(Edge e: edges){
            neighbors.add(e.getTo());
        }
        return neighbors;
    }
}
