package messingAround;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;

public class Graph {
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private boolean connected = true;
    private HashMap<Vertex, HashMap<Vertex, Double>> distances = null;
    public Graph(ArrayList<Vertex> vertices){
        ArrayList<String> names = new ArrayList<>();
        for(Vertex v: vertices){
            if(names.indexOf(v.getName())==-1){
                names.add(v.getName());
            } else{
                throw new IllegalArgumentException("All vertices in a graph must have a unique name");
            }
        }
        this.vertices = new ArrayList<>(vertices);
    }

    public Graph(){
        vertices = new ArrayList<>();
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
                DijkstraCard neighborCard = cards.get(vertices.get(vertices.indexOf(v)));
                double tenetiveDistance = currentCard.getDistance() + distance;
                if(tenetiveDistance<neighborCard.getDistance()){
                    neighborCard.setDistance(tenetiveDistance);
                    neighborCard.addVertex(currentVertex);
                }
            }
            for(Vertex v: unvisited){
                unvisited.set(unvisited.indexOf(v), v.removeEdge(currentVertex)[0]);
            }
            if(currentVertex.equals(v2)){
                finalCard = cards.get(currentVertex);
            }
            unvisited.remove(currentVertex);
        }
        finalCard.addVertex(v2);
        try {
            if (finalCard.getPath().get(0).equals(finalCard.getPath().get(1))) {
                finalCard.getPath().remove(0);
            }
        } catch(IndexOutOfBoundsException n){
            n.printStackTrace();
        }
        if(finalCard.getDistance() == 0 || finalCard.getDistance() == Double.POSITIVE_INFINITY){
            finalCard.setDistance(Double.POSITIVE_INFINITY);
            finalCard.removePath();
            connected = false;
        }
        return finalCard;
    }

    public HashMap<Vertex, HashMap<Vertex, Double>> getDistances(){
        if(distances != null){
            return distances;
        } else {
            HashMap<Vertex, HashMap<Vertex, Double>> localDistances = new HashMap<>();
            for (Vertex v : vertices) {
                HashMap<Vertex, Double> vertexDistances = new HashMap<>();
                for (Vertex V : vertices) {
                    if (!V.equals(v)) {
                        vertexDistances.put(V, this.distance(v, V).getDistance());
                    }
                }
                localDistances.put(v, vertexDistances);
            }
            if (distances == null) {
                distances = new HashMap<>();
                distances.putAll(localDistances);
            }
            return localDistances;
        }
    }

    public double vote(Vertex v){
        HashMap<Vertex, HashMap<Vertex, Double>> distances = getDistances();
        if(vertices.indexOf(v)==-1){
            throw new IllegalArgumentException("Vertex must be in the graph!");
        }
        double total = 0;
        for(Vertex vert: vertices){
            if(!vert.equals(v)){
                v = vertices.get(vertices.indexOf(v));
                vert = vertices.get(vertices.indexOf(vert));
                total += 1.0/distances.get(v).get(vert);
            }
        }
        return total;
    }

    public void writeToFile(String fileName) throws IOException {
        String graph = "";
        for(Vertex v: vertices){
            graph += v.getName()+",";
        }
        graph = graph.substring(0, graph.length()-1);
        for(Vertex v: vertices){
            for(Edge e: v.getEdges()){
                graph += "\n";
                String vertexString = v.toString();
                graph += vertexString+","+e.getTo().toString()+","+e.getWeight();
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
            String[] vertexNames = graphStrings.get(0).split(",");
            ArrayList<Vertex> vertices = new ArrayList<>();
            for(String vertexName: vertexNames){
                Vertex v = new Vertex(vertexName);
                vertices.add(v);
            }
            graphStrings.remove(0);
            for(String edge: graphStrings){
                String[] partitions = edge.split(",");
                String startVertex = partitions[0];
                int startIndex = vertices.indexOf(new Vertex(startVertex));
                String toVertex = partitions[1];
                int toIndex = vertices.indexOf(new Vertex(toVertex));
                double weight = Double.parseDouble(partitions[2]);
                vertices.get(startIndex).addEdge(vertices.get(toIndex), weight);
            }
            g = new Graph(vertices);
        } catch(IOException e){
            e.printStackTrace();
        }
        return g;
    }

    public static Graph random(int vertices, int edges){
        Random rand = new Random();
        ArrayList<Vertex> vertexList = new ArrayList<>();
        for(int x = 0; x<vertices; x++){
            vertexList.add(new Vertex("v"+x));
        }
        for(int x = 0; x<edges; x++){
            int index1 = rand.nextInt(vertices);
            int index2 = rand.nextInt(vertices);
            while(index2==index1){
                index2 = rand.nextInt(vertices);
            }
            Vertex e1 = vertexList.get(index1);
            Vertex e2 = vertexList.get(index2);
            double distance = (double) rand.nextInt(vertices)+1;
            if(!e1.addEdge(e2, distance)){
                x--;
            };
        }
        ArrayList<Vertex> realList = new ArrayList<>();
        realList.addAll(vertexList);
        Graph g = new Graph(realList);
        return g;
    }

    public boolean isConnected(){
        if(distances == null){
            getDistances();
        }
        return connected;
    }
    public boolean isEulerPathable(Vertex startVertex){
        int numOfOdds = 0;
        for(Vertex v: vertices){
            numOfOdds += v.getEdges().size() % 2;
        }
        return numOfOdds==0;
    }
    public DijkstraCard shortestPath(Vertex startingVertex){
        if(vertices.indexOf(startingVertex)==-1){
            throw new IllegalArgumentException("Starting vertex must be in the graph!");
        }
        if(!isConnected() || !isEulerPathable(startingVertex)){
            return new DijkstraCard();
        }
        ArrayList<Vertex> verticesCopy = new ArrayList<>(vertices);
        Graph g = new Graph(verticesCopy);
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex currentVertex = startingVertex;
        Edge bestEdge = startingVertex.getEdges().get(0);
        double maxScore = 0;
        int rounds = 0;
        double distance = 0;
        ArrayList<Vertex> unvisited = new ArrayList<>(vertices);
        while((unvisited.size()!=0)){
            rounds++;
            maxScore = 0;
            path.add(currentVertex);
            for(Edge e: currentVertex.getEdges()){
                Vertex toVertex = e.getTo();
                double score;
                try {
                    score = g.vote(toVertex);
                } catch(NullPointerException n){
                    n.printStackTrace();
                    score = 0;
                }
                //System.out.println(currentVertex + "," + toVertex + "," + maxScore + "," + score);
                if(score>maxScore){
                    maxScore = score;
                    bestEdge = e;
                }
            }
            distance += bestEdge.getWeight();
            Vertex currentVertexCopy = currentVertex.clone();
            Vertex to = bestEdge.getTo();
            Vertex[] verticesWOEdges = currentVertexCopy.removeEdge(to);
            currentVertex.set(verticesWOEdges[0]);
            to.set(verticesWOEdges[1]);
            currentVertex = to;
            unvisited.remove(currentVertex);
            g = new Graph(verticesCopy);
        }
        path.add(startingVertex);
        return new DijkstraCard(startingVertex, distance, path);
    }

    public static Graph randomCompleteGraph(int vertices){
        return random(vertices, (vertices*(vertices-1))/2);
    }
}
