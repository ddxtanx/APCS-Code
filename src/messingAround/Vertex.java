package messingAround;

import java.lang.reflect.Array;
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

    public Vertex removeEdge(Vertex v){
        ArrayList<Edge> edgesClone = new ArrayList<>(edges);
        edgesClone.remove(v);
        return new Vertex(name, edgesClone);
    }

    public ArrayList<Edge> getEdges(){
        return edges;
    }
    //Returns false if the edge already exists, else it returns true
    public boolean addEdge(Vertex v2, double weight){
        Edge e = new Edge(v2, weight);
        if(edges.indexOf(e)==-1) {
            edges.add(e);
            v2.addEdge(new Edge(this, weight));
            return true;
        } else{
            return false;
        }
    }
    @Override
    public boolean equals(Object e){
        if(!(e instanceof Vertex)){
            if(e instanceof DijkstraCard){
                DijkstraCard d = (DijkstraCard) e;
                Vertex v = d.getTo();
                return equals(v);
            } else if(e instanceof Edge){
                Edge ed = (Edge) e;
                Vertex to = ed.getTo();
                return equals(to);
            }
            return false;
        }
        Vertex v = (Vertex) e;

        return (v.getName().equals(name));
    }
    
    @Override
    public String toString(){
        return name;
    }

    @Override
    public Vertex clone(){
        ArrayList<Edge> edgesCopy = new ArrayList<>();
        for(Edge e: edges){
            edgesCopy.add(e.clone());
        }
        return new Vertex(name, edgesCopy);
    }
}
