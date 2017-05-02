import java.awt.*;
import java.applet.Applet;

public class Main extends Applet {

    int[][] coords = { {87, 20}, {92, 53}, {19, 55}, {99, 52}, {61, 99}, {43, 68}, {56, 0}, {61, 36}, {5, 14}, {56, 70}, {50, 12}, {65, 57}, {89, 85}, {53, 59}, {66, 34}, {93, 25}, {30, 1}, {45, 4}, {16, 99}, {25, 30}, {97, 35}, {48, 66}, {63, 91}, {65, 82}, {99, 10}, {80, 26}, {39, 24}, {88, 10}, {8, 29}, {87, 12}, {24, 73}, {99, 12}, {98, 37}, {33, 50}, {27, 71}, {33, 1}, {27, 89}, {76, 21}, {25, 73}, {32, 31}, {83, 57}, {50, 68}, {5, 96}, {74, 55}, {37, 24}, {94, 15}, {1, 59}, {89, 97}, {14, 98} };

    Graph graph = null;
    MST mst = null;

    public void init() {
        graph = new Graph(coords);
        mst = new MST(graph);
    }

    public void start() {
        ;
    }

    public void paint(Graphics g) {
        for(Vertex v : this.graph.vertices) {
            g.setColor(Color.BLACK);
            g.fillOval(v.getX(), v.getY(), 6, 6);
        }

        for(Edge e : mst.minimumSpanningTree) {
            g.setColor(Color.RED);
            g.drawLine(e.getU().getX(), e.getU().getY(), e.getV().getX(),e.getV().getY());
            try {
                Thread.sleep(100);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }
    }

}