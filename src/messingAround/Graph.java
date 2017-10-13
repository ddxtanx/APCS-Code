package messingAround;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<>();

    public Graph(ArrayList<Vertex> v){
        vertices = new ArrayList<>(v);
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
        Vertex v1Copy = new Vertex(v1.getName(), new ArrayList<>(v1.getEdges()));
        Vertex v2Copy = new Vertex(v2.getName(), new ArrayList<>(v2.getEdges()));
        if(vertices.indexOf(v1)==-1 || vertices.indexOf(v2)==-1){
            throw new IllegalArgumentException("Vertices must be in the graph!");
        }
        HashMap<Vertex, DijkstraCard> cards = new HashMap<>();
        ArrayList<Vertex> unvisited = new ArrayList<>();
        Vertex currentVertex = v1Copy;
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
            DijkstraCard min = cardsList.get(cards.size() - 1);
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
            }
            for(Vertex v: unvisited){
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
        /*if(finalCard.getDistance()==0 && finalCard.getDistance()!=Double.POSITIVE_INFINITY){
            finalCard.setDistance(v1Copy.getEdgeToVertex(v2Copy).getWeight());
        }*/
        return finalCard;
    }

    public HashMap<Vertex, HashMap<Vertex, Double>> getDistances(){
        HashMap<Vertex, HashMap<Vertex, Double>> distances = new HashMap<>();
        for(Vertex v: vertices){
            HashMap<Vertex, Double> vertexDistances = new HashMap<>();
            for(Vertex V: vertices){
                if(!V.equals(v)) {
                    vertexDistances.put(V, this.distance(v, V).getDistance());
                }
            }
            distances.put(v, vertexDistances);
        }
        return distances;
    }

    public double vote(Vertex v){
        HashMap<Vertex, HashMap<Vertex, Double>> distances = getDistances();
        System.out.println(distances);
        if(vertices.indexOf(v)==-1){
            throw new IllegalArgumentException("Vertex must be in the graph!");
        }
        double total = 0;
        for(Vertex vert: vertices){
            if(!vert.equals(v)){
                System.out.println(distances.get(v).get(vert));
                total += 1.0/distances.get(v).get(vert);
            }
        }
        return total;
    }

    public void writeToFile(String fileName) throws IOException{
        String graph = "";
        graph += vertices.size();
        for(Vertex v: vertices){
            for(Edge e: v.getEdges()){
                graph += "\n";
                graph += v+","+e.getTo()+","+e.getWeight();
            }
        }
        Path path = Paths.get(fileName);
        
        byte[] graphBytes = graph.getBytes();
        
        Files.write(path, graphBytes);
        System.out.println(graph);
    }
}
