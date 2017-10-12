package messingAround;

import java.util.LinkedList;

public class DijkstraCard {

    private Vertex to;
    private double distance;
    private LinkedList<Vertex> path = new LinkedList<>();

    public DijkstraCard(Vertex start, Vertex to, double distance){
        this.to = to;
        this.distance = distance;
        path.add(start);
    }

    public Vertex getTo() {
        return to;
    }

    public double getDistance() {
        return distance;
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
}
