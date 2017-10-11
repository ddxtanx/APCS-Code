package messingAround;

import java.util.ArrayList;

public class Vertex {
    private String name;
    private ArrayList<Edge> edges = new ArrayList<Edge>();
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
        return edges.get(index).getEnd();
    }
}
