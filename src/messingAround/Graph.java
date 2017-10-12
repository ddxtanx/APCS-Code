package messingAround;

import java.util.ArrayList;
import java.util.Collections;
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
        while((unvisited.indexOf(v2)!=-1) && minValue!=Double.POSITIVE_INFINITY){
            System.out.println("Currently @ " + currentVertex);
            ArrayList<Edge> neighborsEdges = currentVertex.getEdges();
            for(Edge e: neighborsEdges){
                Vertex v = e.getTo();
                System.out.println("Looking @ vertex " + v);
                double distance = e.getWeight();
                int currentCardIndex = cards.indexOf(currentVertex);
                DijkstraCard currentCard = cards.get(currentCardIndex);
                int neighborCardIndex = cards.indexOf(v);
                DijkstraCard neighborCard = cards.get(neighborCardIndex);
                double tenetiveDistance = currentCard.getDistance() + distance;
                if(tenetiveDistance<neighborCard.getDistance()){
                    System.out.println("Tenetive Distance is less");
                    neighborCard.setDistance(tenetiveDistance);
                    neighborCard.addVertex(currentVertex);
                }
            }
            cards.remove(currentVertex);
            unvisited.remove(currentVertex);
            Collections.sort(cards);
            DijkstraCard min = cards.get(min.size()-1);
            Vertex minVertex = min.getTo();
            min.getTo().removeEdge(currentVertex);
            currentVertex = min.getTo();
            minValue = min.getDistance();
        }
        return minValue;
    }
}
