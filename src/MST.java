/**
 * Created by Shin on 2017-05-02.
 */

import java.util.*;

public class MST {

    public List<Edge> minimumSpanningTree = null;

    public MST(Graph g) {
        int i = 0;
        for(Vertex v : g.vertices) {    // make vertice hashmap to find vertex faster
            v.index = i++;  // keep a index from the ArrayList
            verticeMap.put(v.hashCode(), v);    // key is hashCode of the Vertex object
        }

        this.edges = new LinkedList<>();    // shallow copy (only edges)
        for(Edge e : g.edges) {
            this.edges.add(e.clone());
        }

        this.minimumSpanningTree = new LinkedList<>();

        this.groups = new int[verticeMap.size()];   // make group array to identify whether two edges are in the same group
        for(int j = 0; j < this.groups.length; j++) {
            this.groups[j] = j;
        }

        this.makeMST();
    }

    private Map<Integer, Vertex> verticeMap = new HashMap<>();
    private List<Edge> edges = null;
    private int[] groups = null;

    private void makeMST() {
        // beginning of the Kruskal's Algorithm
        Collections.sort(this.edges, new Ascending());

        Edge e;
        while(minimumSpanningTree.size() < verticeMap.size() - 1) {
            e = this.edges.remove(0);  // pick least one

            // find group of each vertex
            int u = UnionFind.find(this.groups, this.groups[verticeMap.get(e.getU().hashCode()).index]);
            int v = UnionFind.find(this.groups, this.groups[verticeMap.get(e.getV().hashCode()).index]);
            if(u != v) {    // if they are in different group. it will not make cycle (Union-Find Scheme)
                minimumSpanningTree.add(e);
                UnionFind.union(this.groups, u, v); // merge the group
            }
        }
    }

    class Ascending implements Comparator<Edge> {   // compared by distance
        @Override
        public int compare(Edge e1, Edge e2) {
            return Double.compare(e1.getDist(), e2.getDist());
        }
    }

    public static class UnionFind {     // Utility Class
        public static int find(int[] groups, int i) {
            if (groups[i] != i)  groups[i] = find(groups, groups[i]);

            return groups[i];
        }

        public static void union(int[] groups, int x, int y) {
            x = find(groups, x);
            y = find(groups, y);

            if(((int)(Math.random() * 10) % 2) == 0)
                groups[x] = y;
            else
                groups[y] = x;
        }
    }
}
