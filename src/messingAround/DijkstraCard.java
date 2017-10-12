package messingAround;

import java.util.LinkedList;

public class DijkstraCard implements Comparable<DijkstraCard>{

    private Vertex to;
    private double distance;
    private LinkedList<Vertex> path = new LinkedList<>();
//TODO: For some reason, the start of the path includes the starting vertex twice.
    public DijkstraCard(Vertex start, Vertex to, double distance){
        this.to = to;
        this.distance = distance;
        path.add(start);
    }

    public DijkstraCard(){
        this.to = new Vertex("");
        this.distance = 0;
    }
        
    public int compareTo(DijkstraCard d){
        if(d.getDistance()>distance){
            return 1;
        }
        else if(d.getDistance()==distance){
            return 0;
        }
        else{
            return -1;
        }
    }
    public Vertex getTo() {
        return to;
    }

    public double getDistance() {
        return distance;
    }
    
    public void setDistance(double d){
        distance = d;
    }
    public LinkedList<Vertex> getPath() {
        return path;
    }

    public void addVertex(Vertex v){
        path.add(v);
    }

    public void addDistance(double d){
        distance += d;
    }

    public void addPath(Vertex v, double d){
        addVertex(v);
        addDistance(d);
    }

    @Override
    public boolean equals(Object e){
        if(!(e instanceof DijkstraCard)) {
            return e instanceof Vertex && to.equals((Vertex) e);
        }

        DijkstraCard d = (DijkstraCard) e;

        return (d.getTo().equals(to));
    }
    
    @Override
    public String toString(){
        return "To " + to + " with a current distance of " + distance;
    }
}
