package messingAround;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<>();

    public Graph(ArrayList<Vertex> v){
        vertices = (ArrayList<Vertex>) v.clone();
    }

    public void links(){
        for(Vertex v: vertices){
            System.out.println(v.getName() + " is linked to ");
            for(int x = 0; x<v.getEdges().size(); x++){
                Edge e = v.getEdges().get(x);
                System.out.println("\t " + e.getTo().getName() + " with a weight of " + e.getWeight());
            }
        }
    }

    public ArrayList<Vertex> getVertices(){
        return vertices;
    }

    public void addVertex(Vertex v){
        vertices.add(v);
    }

    public double distance(Vertex v1, Vertex v2){
        if(vertices.indexOf(v1)==-1 || vertices.indexOf(v2)==-1){
            throw new IllegalArgumentException("Vertices must be in the graph!");
        }
        ArrayList<DijkstraCard> cards = new ArrayList<>();
        ArrayList<Vertex> unvisited = new ArrayList<>();
        Vertex currentVertex = v1;
        double minValue = 0;
        for(Vertex v: vertices){
            DijkstraCard card;
            if(!v.equals(v1)){
                unvisited.add(v);
                card = new DijkstraCard(v1, v, Double.POSITIVE_INFINITY);
            } else{
                card = new DijkstraCard(v1, v1, 0);
            }
            cards.add(card);
        }
        while((!currentVertex.equals(v2)) && minValue!=Double.POSITIVE_INFINITY){
            ArrayList<Vertex> neighbors = currentVertex.getNeighbors();
            for(Vertex v: neighbors){
                int index = vertices.indexOf(v);
            }
        }
        return 2.0;
    }
}
