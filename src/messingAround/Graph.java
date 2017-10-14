package messingAround;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;

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
        if(vertices.indexOf(v1)==-1 || vertices.indexOf(v2)==-1){
            throw new IllegalArgumentException("Vertices must be in the graph!");
        }
        HashMap<Vertex, DijkstraCard> cards = new HashMap<>();
        ArrayList<Vertex> unvisited = new ArrayList<>();
        Vertex currentVertex;
        double minValue = 0;
        for(Vertex v: vertices){
            DijkstraCard card;
            if(!v.equals(v1)){
                unvisited.add(v.clone());
                card = new DijkstraCard(v1, v, Double.POSITIVE_INFINITY);
            } else{
                card = new DijkstraCard(v1, v1, 0);
            }
            cards.put(v, card);
        }
        DijkstraCard finalCard = new DijkstraCard();
        int rounds = 1;
        while((unvisited.indexOf(v2)!=-1) && minValue!=Double.POSITIVE_INFINITY){
            ArrayList<DijkstraCard> cardsList = new ArrayList<>(cards.values());
            Collections.sort(cardsList);
            DijkstraCard min = cardsList.get(cards.size() - rounds);
            rounds++;
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
                v = v.removeEdge(currentVertex);
            }
            if(currentVertex.equals(v2)){
                finalCard = cards.get(currentVertex);
            }
            unvisited.remove(currentVertex);
        }
        if(finalCard.getPath().get(0).equals(finalCard.getPath().get(1))){
            finalCard.getPath().remove(0);
        }
        finalCard.addVertex(v2);
        if(finalCard.getDistance() == 0){
            finalCard.setDistance(Double.POSITIVE_INFINITY);
        }
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
        if(vertices.indexOf(v)==-1){
            throw new IllegalArgumentException("Vertex must be in the graph!");
        }
        double total = 0;
        for(Vertex vert: vertices){
            if(!vert.equals(v)){
                total += 1.0/distances.get(v).get(vert);
            }
        }
        return total;
    }

    public void writeToFile(String fileName) throws IOException {
        String graph = "";
        graph += vertices.size();
        for(Vertex v: vertices){
            for(Edge e: v.getEdges()){
                graph += "\n";
                String vertexString = v.toString();
                vertexString = vertexString.replaceAll("v", "");
                graph += vertexString+","+e.getTo().toString().replaceAll("v","")+","+e.getWeight();
            }
        }
        Path path = Paths.get(fileName);
        
        byte[] graphBytes = graph.getBytes();
        
        Files.write(path, graphBytes);
    }

    public static Graph readFromFile(String fileName){
        Path path = Paths.get(fileName);
        Graph g = new Graph(new ArrayList<>());
        try{
            List<String> graphStrings = Files.readAllLines(path);
            int numVertices = Integer.parseInt(graphStrings.get(0));
            ArrayList<Vertex> vertices = new ArrayList<>();
            for(int x = 0; x<numVertices; x++){
                vertices.add(new Vertex("v"+x));
            }
            graphStrings.remove(0);
            for(String edge: graphStrings){
                String[] partitions = edge.split(",");
                int startIndex = Integer.parseInt(partitions[0]);
                int toIndex = Integer.parseInt(partitions[1]);
                double weight = Double.parseDouble(partitions[2]);
                vertices.get(startIndex).addEdge(vertices.get(toIndex), weight);
            }
            g = new Graph(vertices);
        } catch(IOException e){
            e.printStackTrace();
        }
        return g;
    }

    public static Graph randomGraph(int vertices){
        Random rand = new Random();
        ArrayList<Vertex> vertexList = new ArrayList<>();
        for(int x = 0; x<vertices; x++){
            vertexList.add(new Vertex("v"+x));
        }
        for(int x = 0; x<vertices*2; x++){
            int index1 = rand.nextInt(vertices);
            int index2 = rand.nextInt(vertices);
            while(index2==index1){
                index2 = rand.nextInt(vertices);
            }
            Vertex e1 = vertexList.get(index1);
            Vertex e2 = vertexList.get(index2);
            double distance = (double) rand.nextInt(vertices)+1;
            e1.addEdge(e2, distance);
        }
        ArrayList<Vertex> realList = new ArrayList<>();
        for(Vertex v: vertexList){
            realList.add(v);
        }
        Graph g = new Graph(realList);
        return g;
    }
}
