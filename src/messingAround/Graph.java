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
                System.out.println("\t " + e.getEnd().getName() + " with a weight of " + e.getWeight());
            }
        }
    }
}
