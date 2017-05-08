import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shin on 2017-05-02.
 */
public class Graph {
    public Vertex[] vertices;
    public List<Edge> edges;

    public Graph() {
        this.vertices = null;
        this.edges = null;
    }

    public Graph(int[][] coords) {
        this.setVertices(coords);
        this.updateEdge();   // edges are depend on vertices
    }

    public void setVertices(int[][] coords) {
        this.vertices = new Vertex[coords.length];

        for(int i = 0; i < coords.length; i++) {
            this.vertices[i] = new Vertex(coords[i][0], coords[i][1]);
            this.vertices[i].index = i;
        }

        this.updateEdge();
    }

    public void updateEdge() {
        edges = new ArrayList<>();

        for(int i = 0; i < this.vertices.length; i++) {
            for(int j = i + 1; j < this.vertices.length; j++) {
                edges.add(new Edge(this.vertices[i], this.vertices[j]));
            }
        }
    }
}
