package messingAround;

import java.util.ArrayList;
import java.util.Random;

public class GraphExample {

    public static void main(String[] args) {
        int vertices = 20;
        Random rand = new Random();
        ArrayList<Vertex> vertexList = new ArrayList<>();
        for(int x = 0; x<vertices; x++){
            vertexList.add(new Vertex("v"+x));
        }
        for(int x = 0; x<vertices*vertices; x++){
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
        g.links();
        int index1 = rand.nextInt(vertices);
        int index2 = rand.nextInt(vertices);
        while(index2==index1){
            index2 = rand.nextInt(vertices);
        }
        Vertex v1 = vertexList.get(index1);
        Vertex v2 = vertexList.get(index2);
        DijkstraCard distance = g.distance(v1, v2);
        System.out.println("Distance between " + v1 + " and " + v2 + " is " + distance.getDistance() + " via " + distance.getPath());
        index1 = rand.nextInt(vertices);
        index2 = rand.nextInt(vertices);
        while(index2==index1){
            index2 = rand.nextInt(vertices);
        }
        v1 = vertexList.get(index1);
        v2 = vertexList.get(index2);
        distance = g.distance(v1, v2);
        System.out.println("Distance between " + v1 + " and " + v2 + " is " + distance.getDistance() + " via " + distance.getPath());
        System.out.println(g.getDistances());
    }
}
