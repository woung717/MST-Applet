/**
 * Created by Shin on 2017-05-01.
 */
public class Edge {
    public double getDist() {
        return dist;
    }

    public Edge(Vertex u, Vertex v) {
        this.u = u;
        this.v = v;
        dist = Distance.euclidean(u.getX(), u.getY(), v.getX(), v.getY());
    }

    public Edge clone() {
        return new Edge(this.getU(), this.getV());
    }

    public Vertex getU() {
        return u;
    }

    public Vertex getV() {
        return v;
    }

    private Vertex u;
    private Vertex v;
    private double dist;

    public static class Distance {
        public static double euclidean(int x1, int y1, int x2, int y2) {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }
    }
}
