package messingAround;

import java.util.ArrayList;

public class Vertex {
    private String name;
    private ArrayList<Edge> edges = new ArrayList<>();
    public Vertex(String n){
        name = n;
    }
    public Vertex(String n, ArrayList<Edge> ed){
        name = n;
        edges = ed;
    }
    public String getName(){
        return name;
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }
    
    public void removeEdge(Edge edge){
        edges.remove(edge);
    }
    
    public void removeEdge(Vertex v){
        edges.remove(v);
    }

    public ArrayList<Edge> getEdges(){
        return edges;
    }

    public Edge getEdgeToVertex(Vertex v){
        int index = edges.indexOf(v);
        System.out.println(edges);
        if(index==-1){
            throw new IllegalArgumentException("Vertices must have an edge between them to return an edge!");
        }
        return edges.get(index);
    }
    public Vertex traverseEdge(int index){
        if(index<0 || index>=edges.size()){
            throw new IllegalArgumentException("You cannot traverse to a vertex that does not exist!");
        }
        return edges.get(index).getTo();
    }

    public Edge addEdge(Vertex v2, double weight){
        Edge e = new Edge(v2, weight);
        if(edges.indexOf(e)==-1) {
            edges.add(e);
            v2.addEdge(new Edge(this, weight));
            return e.clone();
        } else{
            return e.clone();
        }
    }
    @Override
    public boolean equals(Object e){
        if(!(e instanceof Vertex)){
            if(e instanceof DijkstraCard){
                DijkstraCard d = (DijkstraCard) e;
                return d.getTo().getName().equals(name) && d.getTo().getEdges().equals(edges);
            } else if(e instanceof Edge){
                Edge ed = (Edge) e;
                Vertex to = ed.getTo();
                return equals(to);
            }
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
    
    @Override
    public String toString(){
        return name;
    }
}
