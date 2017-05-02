/**
 * Created by Shin on 2017-05-01.
 */
public class Vertex {
    public int index;

    public Vertex(int x, int y) {
        setX(x);
        setY(y);

        this.index = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) { this.y = y; }

    public int hashCode() { // generate unique identifier with hash calculation
        int hash = 0;

        hash = hash * 37 + getX();
        hash = hash * 37 + getY();

        return hash;
    }

    private int x;
    private int y;
}
