import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shin on 2017-05-02.
 */
public class Graph implements Network{
    public Vertex[] vertices = null;
    public List<Edge> edges = null;

    public Graph(int[][] coords) {
        this.vertices = new Vertex[coords.length];

        for(int i = 0; i < coords.length; i++) {
            this.vertices[i] = new Vertex(coords[i][0] * 3, coords[i][1] * 3);
        }

        updateEdge();   // edges are depend on vertices
    }

    private void updateEdge() {
        edges = new ArrayList<>();

        for(int i = 0; i < this.vertices.length; i++) {
            for(int j = i + 1; j < this.vertices.length; j++) {
                edges.add(new Edge(this.vertices[i], this.vertices[j]));
            }
        }
    }
}
