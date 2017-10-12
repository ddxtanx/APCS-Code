package messingAround;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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

    public DijkstraCard distance(Vertex v1, Vertex v2){
        if(vertices.indexOf(v1)==-1 || vertices.indexOf(v2)==-1){
            throw new IllegalArgumentException("Vertices must be in the graph!");
        }
        HashMap<Vertex, DijkstraCard> cards = new HashMap<>();
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
            cards.put(v, card);
        }
        DijkstraCard finalCard = new DijkstraCard();
        while((unvisited.indexOf(v2)!=-1) && minValue!=Double.POSITIVE_INFINITY){
            ArrayList<DijkstraCard> cardsList = new ArrayList<>(cards.values());
            Collections.sort(cardsList);
            DijkstraCard min = cardsList.get(cards.size()-1);
            currentVertex = min.getTo();
            minValue = min.getDistance();
            ArrayList<Edge> neighborsEdges = currentVertex.getEdges();
            for(Edge e: neighborsEdges){
                Vertex v = e.getTo();
                double distance = e.getWeight();
                DijkstraCard currentCard = cards.get(currentVertex);
                DijkstraCard neighborCard = cards.get(v);
                double tenetiveDistance = currentCard.getDistance() + distance;
                if(tenetiveDistance<neighborCard.getDistance()){
                    neighborCard.setDistance(tenetiveDistance);
                    neighborCard.addVertex(currentVertex);
                }
                v.removeEdge(currentVertex);
            }
            if(currentVertex.equals(v2)){
                finalCard = cards.get(currentVertex);
            }
            cards.remove(currentVertex);
            unvisited.remove(currentVertex);
        }
        finalCard.addVertex(v2);
        finalCard.getPath().remove(0);
        return finalCard;
    }
}
